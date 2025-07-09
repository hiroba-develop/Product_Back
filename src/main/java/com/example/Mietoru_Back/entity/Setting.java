package com.example.Mietoru_Back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "SETTINGS")
public class Setting {

    @Id
    @Column(name = "SETTING_ID", length = 36, nullable = false)
    private String settingId;

    @Column(name = "USER_ID", length = 36, nullable = false)
    private String userId;

    @Column(name = "COMPANY_SIZE", precision = 2)
    private Integer companySize;

    @Column(name = "INDUSTRY", precision = 2)
    private Integer industry;

    @Column(name = "FISCAL_YEAR_START_YEAR", precision = 4)
    private Integer fiscalYearStartYear;

    @Column(name = "FISCAL_YEAR_START_MONTH", precision = 2)
    private Integer fiscalYearStartMonth;

    @Column(name = "TOTAL_ASSETS", precision = 10)
    private Long totalAssets;

    @Column(name = "BUSINESS_EXPERIENCE", precision = 2)
    private Integer businessExperience;

    @Column(name = "FINANCIAL_KNOWLEDGE", precision = 2)
    private Integer financialKnowledge;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT", nullable = false)
    private LocalDateTime updatedAt;
}