package com.example.Mietoru_Back.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * NetAsset
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class NetAsset {

  private String netAssetId;

  private String userId;

  private Integer year;

  private Integer netAssetTarget;

  private Integer netAssetResult;

  public NetAsset netAssetId(String netAssetId) {
    this.netAssetId = netAssetId;
    return this;
  }

  /**
   * 純利益ID（UUID）
   * @return netAssetId
  */
  
  @Schema(name = "netAssetId", description = "純利益ID（UUID）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("netAssetId")
  public String getNetAssetId() {
    return netAssetId;
  }

  public void setNetAssetId(String netAssetId) {
    this.netAssetId = netAssetId;
  }

  public NetAsset userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * ユーザーID（UUID）
   * @return userId
  */
  
  @Schema(name = "userId", description = "ユーザーID（UUID）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userId")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public NetAsset year(Integer year) {
    this.year = year;
    return this;
  }

  /**
   * 対象年
   * @return year
  */
  
  @Schema(name = "year", description = "対象年", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("year")
  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public NetAsset netAssetTarget(Integer netAssetTarget) {
    this.netAssetTarget = netAssetTarget;
    return this;
  }

  /**
   * 純利益目標
   * @return netAssetTarget
  */
  
  @Schema(name = "netAssetTarget", description = "純利益目標", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("netAssetTarget")
  public Integer getNetAssetTarget() {
    return netAssetTarget;
  }

  public void setNetAssetTarget(Integer netAssetTarget) {
    this.netAssetTarget = netAssetTarget;
  }

  public NetAsset netAssetResult(Integer netAssetResult) {
    this.netAssetResult = netAssetResult;
    return this;
  }

  /**
   * 純利益実績
   * @return netAssetResult
  */
  
  @Schema(name = "netAssetResult", description = "純利益実績", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("netAssetResult")
  public Integer getNetAssetResult() {
    return netAssetResult;
  }

  public void setNetAssetResult(Integer netAssetResult) {
    this.netAssetResult = netAssetResult;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetAsset netAsset = (NetAsset) o;
    return Objects.equals(this.netAssetId, netAsset.netAssetId) &&
        Objects.equals(this.userId, netAsset.userId) &&
        Objects.equals(this.year, netAsset.year) &&
        Objects.equals(this.netAssetTarget, netAsset.netAssetTarget) &&
        Objects.equals(this.netAssetResult, netAsset.netAssetResult);
  }

  @Override
  public int hashCode() {
    return Objects.hash(netAssetId, userId, year, netAssetTarget, netAssetResult);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetAsset {\n");
    sb.append("    netAssetId: ").append(toIndentedString(netAssetId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    netAssetTarget: ").append(toIndentedString(netAssetTarget)).append("\n");
    sb.append("    netAssetResult: ").append(toIndentedString(netAssetResult)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

