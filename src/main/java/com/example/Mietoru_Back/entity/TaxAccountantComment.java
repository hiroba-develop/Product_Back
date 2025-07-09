package com.example.Mietoru_Back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TAX_ACCOUNTANT_COMMENTS")
public class TaxAccountantComment {

    @Id
    @Column(name = "TAX_ACCOUNTANT_COMMENT_ID", length = 36, nullable = false)
    private String taxAccountantCommentId;

    @Column(name = "USER_ID", length = 36, nullable = false)
    private String userId;

    @Column(name = "YEAR", precision = 4, nullable = false)
    private Integer year;

    @Column(name = "MONTH", precision = 2, nullable = false)
    private Integer month;

    @Column(name = "TAX_ACCOUNTANT_COMMENT", length = 1024)
    private String taxAccountantComment;

    @Column(name = "TAX_ACCOUNTANT_COMMENT_FLG", length = 1)
    private String taxAccountantCommentFlg;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT", nullable = false)
    private LocalDateTime updatedAt;
}