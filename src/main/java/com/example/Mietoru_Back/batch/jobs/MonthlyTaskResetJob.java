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

import com.example.Mietoru_Back.repository.task.TaskRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * 月次タスク通知完了フラグリセットジョブの設定クラス
 */
@Configuration("monthlyTaskResetJobConfig")
@Slf4j
public class MonthlyTaskResetJob {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final TaskRepository taskRepository;

    @Autowired
    public MonthlyTaskResetJob(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            TaskRepository taskRepository) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
        this.taskRepository = taskRepository;
    }

    /**
     * タスク通知完了フラグリセットのTasklet
     * 
     * @return Tasklet
     */
    @Bean
    public Tasklet resetTaskNotificationCompletedTasklet() {
        return (contribution, chunkContext) -> {
            log.info("タスク通知完了フラグのリセット処理を開始します");

            int updatedCount = taskRepository.resetAllNotificationCompleted();

            log.info("タスク通知完了フラグのリセット処理が完了しました。更新件数: {}", updatedCount);
            return RepeatStatus.FINISHED;
        };
    }

    /**
     * タスク通知完了フラグリセットのStep
     * 
     * @return Step
     */
    @Bean
    public Step resetTaskNotificationCompletedStep() {
        return new StepBuilder("resetTaskNotificationCompletedStep", jobRepository)
                .tasklet(resetTaskNotificationCompletedTasklet(), transactionManager)
                .build();
    }

    /**
     * タスク通知完了フラグリセットのJob
     * 
     * @return Job
     */
    @Bean
    public Job monthlyTaskResetJob() {
        return new JobBuilder("monthlyTaskResetJob", jobRepository)
                .start(resetTaskNotificationCompletedStep())
                .build();
    }
}