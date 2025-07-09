package com.example.Mietoru_Back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TASKS")
public class Task {

    @Id
    @Column(name = "TASK_ID", length = 36, nullable = false)
    private String taskId;

    @Column(name = "USER_ID", length = 36, nullable = false)
    private String userId;

    @Column(name = "TASK_NAME", length = 255)
    private String taskName;

    @Column(name = "NOTIFICATION_COMPLETED", length = 1)
    private String notificationCompleted;

    @Column(name = "NOTIFICATION_ENABLED", length = 1)
    private String notificationEnabled;

    @Column(name = "NOTIFICATION_DAY", precision = 2)
    private Integer notificationDay;

    @Column(name = "DEL_FLG", length = 1)
    private String delFlg;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT", nullable = false)
    private LocalDateTime updatedAt;
}