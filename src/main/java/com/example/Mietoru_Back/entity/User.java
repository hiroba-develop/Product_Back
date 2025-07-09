package com.example.Mietoru_Back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "USER_ID", length = 36, nullable = false)
    private String userId;

    @Column(name = "EMAIL", length = 255, nullable = false)
    private String email;

    @Column(name = "PASSWORD_HASH", length = 255)
    private String passwordHash;

    @Column(name = "GOOGLE_ID", length = 255)
    private String googleId;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "COMPANY", length = 200)
    private String company;

    @Column(name = "TEL_NO", length = 20)
    private String telNo;

    @Column(name = "ROLE", length = 1, nullable = false)
    private String role;

    @Column(name = "SETTING_FLG", length = 1, nullable = false)
    private String settingFlg;

    @Column(name = "DEL_FLG", length = 1, nullable = false)
    private String delFlg;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT", nullable = false)
    private LocalDateTime updatedAt;
}