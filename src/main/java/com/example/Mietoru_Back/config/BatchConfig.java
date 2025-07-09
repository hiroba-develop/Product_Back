package com.example.Mietoru_Back.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Batchの設定クラス
 */
@Configuration
@EnableBatchProcessing
public class BatchConfig {
    // 基本設定のみ。ジョブの具体的な設定は各ジョブクラスで行う
}