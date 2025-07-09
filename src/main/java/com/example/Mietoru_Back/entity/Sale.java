package com.example.Mietoru_Back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "SALES")
public class Sale {

    @Id
    @Column(name = "SALE_ID", length = 36, nullable = false)
    private String saleId;

    @Column(name = "USER_ID", length = 36, nullable = false)
    private String userId;

    @Column(name = "YEAR", precision = 4, nullable = false)
    private Integer year;

    @Column(name = "MONTH", precision = 2, nullable = false)
    private Integer month;

    @Column(name = "SALE_TARGET", precision = 10)
    private Long saleTarget;

    @Column(name = "SALE_RESULT", precision = 10)
    private Long saleResult;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT", nullable = false)
    private LocalDateTime updatedAt;
}