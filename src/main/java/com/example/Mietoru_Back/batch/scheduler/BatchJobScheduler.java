package com.example.Mietoru_Back.batch.scheduler;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * バッチジョブのスケジューラクラス
 */
@Component
@Slf4j
public class BatchJobScheduler {

    private final JobLauncher jobLauncher;
    private final Job monthlyTaskResetJob;
    private final Job dailyEmailJob;

    @Autowired
    public BatchJobScheduler(
            JobLauncher jobLauncher,
            @Qualifier("monthlyTaskResetJob") Job monthlyTaskResetJob,
            @Qualifier("dailyEmailJob") Job dailyEmailJob) {
        this.jobLauncher = jobLauncher;
        this.monthlyTaskResetJob = monthlyTaskResetJob;
        this.dailyEmailJob = dailyEmailJob;
    }

    /**
     * 毎月1日の午前0時0分に実行
     * タスク通知完了フラグをリセットするジョブを実行
     */
    @Scheduled(cron = "0 0 0 1 * ?", zone = "Asia/Tokyo") // 毎月1日の午前0時0分
    public void runMonthlyTaskResetJob() {
        log.info("月次タスク通知完了フラグリセットジョブを開始します");
        JobParameters params = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
        try {
            jobLauncher.run(monthlyTaskResetJob, params);
            log.info("月次タスク通知完了フラグリセットジョブが正常に完了しました");
        } catch (JobExecutionAlreadyRunningException | JobRestartException
                | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
            log.error("月次タスク通知完了フラグリセットジョブの実行中にエラーが発生しました", e);
        }
    }

    /**
     * 毎日午前9時0分に実行
     * タスクリマインドメールを送信するジョブを実行
     */
    @Scheduled(cron = "0 0 9 * * ?", zone = "Asia/Tokyo") // 毎日午前9時0分
    public void runDailyEmailJob() {
        log.info("日次メール送信ジョブを開始します");
        JobParameters params = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
        try {
            jobLauncher.run(dailyEmailJob, params);
            log.info("日次メール送信ジョブが正常に完了しました");
        } catch (JobExecutionAlreadyRunningException | JobRestartException
                | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
            log.error("日次メール送信ジョブの実行中にエラーが発生しました", e);
        }
    }
}