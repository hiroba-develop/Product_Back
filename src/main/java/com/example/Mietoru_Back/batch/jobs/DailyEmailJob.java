package com.example.Mietoru_Back.batch.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.Mietoru_Back.entity.Task;
import com.example.Mietoru_Back.entity.User;
import com.example.Mietoru_Back.repository.auth.UserRepository;
import com.example.Mietoru_Back.repository.task.TaskRepository;
import com.example.Mietoru_Back.service.mail.EmailService;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

/**
 * 日次メール送信ジョブの設定クラス
 */
@Configuration("dailyEmailJobConfig")
@Slf4j
public class DailyEmailJob {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final EmailService emailService;

    @Autowired
    public DailyEmailJob(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            TaskRepository taskRepository,
            UserRepository userRepository,
            EmailService emailService) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    /**
     * 日次メール送信のTasklet
     * 
     * @return Tasklet
     */
    @Bean
    public Tasklet dailyEmailTasklet() {
        return (contribution, chunkContext) -> {
            log.info("日次メール送信処理を開始します");

            try {
                // 現在の日本時間の日付を取得
                LocalDate today = LocalDate.now();
                int dayOfMonth = today.getDayOfMonth();

                log.info("本日の日付: {}日", dayOfMonth);

                // 通知日が今日の日付と一致するタスクを取得
                List<Task> tasksToNotify = taskRepository.findByNotificationDayAndNotificationEnabledAndDelFlg(
                        dayOfMonth, "1", "0");

                log.info("通知対象タスク数: {}", tasksToNotify.size());

                // 各タスクに対してメール送信処理を実行
                for (Task task : tasksToNotify) {
                    String userId = task.getUserId();

                    // ユーザー情報を取得
                    Optional<User> userOpt = userRepository.findById(userId);

                    if (userOpt.isPresent()) {
                        User user = userOpt.get();
                        String email = user.getEmail();

                        if (email != null && !email.isEmpty()) {
                            // タスクリマインドメールを送信
                            sendTaskReminderEmail(user, task);
                            log.info("ユーザーID: {}、タスクID: {} のリマインドメールを送信しました", userId, task.getTaskId());
                        } else {
                            log.warn("ユーザーID: {} のメールアドレスが設定されていません", userId);
                        }
                    } else {
                        log.warn("ユーザーID: {} が見つかりません", userId);
                    }
                }
            } catch (Exception e) {
                log.error("日次メール送信処理でエラーが発生しました", e);
            }

            log.info("日次メール送信処理が完了しました");
            return RepeatStatus.FINISHED;
        };
    }

    /**
     * タスクリマインドメールを送信する
     * 
     * @param user タスクの所有ユーザー
     * @param task 通知対象のタスク
     */
    private void sendTaskReminderEmail(User user, Task task) {
        try {
            // 現在の日時を取得
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
            String formattedDate = now.format(formatter);

            // メールの件名
            String subject = "【ミエトル】タスクリマインド通知";

            // メールの本文
            StringBuilder body = new StringBuilder();
            body.append(user.getName()).append(" 様\n\n");
            body.append("ミエトルに登録されているタスクの通知日になりました。\n\n");
            body.append("■タスク名: ").append(task.getTaskName()).append("\n");
            body.append("■通知日: ").append(formattedDate).append("\n");
            body.append("\n");
            body.append("タスクの詳細はミエトルにログインしてご確認ください。\n");
            body.append("\n");
            body.append("※このメールは自動送信されています。返信はできませんのでご了承ください。");

            // メール送信
            emailService.sendSimpleEmail(user.getEmail(), subject, body.toString());

        } catch (Exception e) {
            log.error("タスクリマインドメール送信エラー", e);
        }
    }

    /**
     * 日次メール送信のStep
     * 
     * @return Step
     */
    @Bean
    public Step dailyEmailStep() {
        return new StepBuilder("dailyEmailStep", jobRepository)
                .tasklet(dailyEmailTasklet(), transactionManager)
                .build();
    }

    /**
     * 日次メール送信のJob
     * 
     * @return Job
     */
    @Bean
    public Job dailyEmailJob() {
        return new JobBuilder("dailyEmailJob", jobRepository)
                .start(dailyEmailStep())
                .build();
    }
}