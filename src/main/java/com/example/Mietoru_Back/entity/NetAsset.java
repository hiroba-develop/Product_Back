package com.example.Mietoru_Back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "NET_ASSETS")
public class NetAsset {

    @Id
    @Column(name = "NET_ASSET_ID", length = 36, nullable = false)
    private String netAssetId;

    @Column(name = "USER_ID", length = 36, nullable = false)
    private String userId;

    @Column(name = "YEAR", precision = 4, nullable = false)
    private Integer year;

    @Column(name = "NET_ASSET_TARGET", precision = 10)
    private Long netAssetTarget;

    @Column(name = "NET_ASSET_RESULT", precision = 10)
    private Long netAssetResult;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT", nullable = false)
    private LocalDateTime updatedAt;
}