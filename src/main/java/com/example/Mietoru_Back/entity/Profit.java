package com.example.Mietoru_Back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "PROFITS")
public class Profit {

    @Id
    @Column(name = "PROFIT_ID", length = 36, nullable = false)
    private String profitId;

    @Column(name = "USER_ID", length = 36, nullable = false)
    private String userId;

    @Column(name = "YEAR", precision = 4, nullable = false)
    private Integer year;

    @Column(name = "MONTH", precision = 2, nullable = false)
    private Integer month;

    @Column(name = "PROFIT_TARGET", precision = 10)
    private Long profitTarget;

    @Column(name = "PROFIT_RESULT", precision = 10)
    private Long profitResult;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT", nullable = false)
    private LocalDateTime updatedAt;
}