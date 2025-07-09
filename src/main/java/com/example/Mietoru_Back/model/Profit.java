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
 * Profit
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Profit {

  private String profitId;

  private String userId;

  private Integer year;

  private Integer month;

  private Integer profitTarget;

  private Integer profitResult;

  public Profit profitId(String profitId) {
    this.profitId = profitId;
    return this;
  }

  /**
   * 利益ID（UUID）
   * @return profitId
  */
  
  @Schema(name = "profitId", description = "利益ID（UUID）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("profitId")
  public String getProfitId() {
    return profitId;
  }

  public void setProfitId(String profitId) {
    this.profitId = profitId;
  }

  public Profit userId(String userId) {
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

  public Profit year(Integer year) {
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

  public Profit month(Integer month) {
    this.month = month;
    return this;
  }

  /**
   * 対象月（1-12）
   * minimum: 1
   * maximum: 12
   * @return month
  */
  @Min(1) @Max(12) 
  @Schema(name = "month", description = "対象月（1-12）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("month")
  public Integer getMonth() {
    return month;
  }

  public void setMonth(Integer month) {
    this.month = month;
  }

  public Profit profitTarget(Integer profitTarget) {
    this.profitTarget = profitTarget;
    return this;
  }

  /**
   * 利益目標
   * @return profitTarget
  */
  
  @Schema(name = "profitTarget", description = "利益目標", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("profitTarget")
  public Integer getProfitTarget() {
    return profitTarget;
  }

  public void setProfitTarget(Integer profitTarget) {
    this.profitTarget = profitTarget;
  }

  public Profit profitResult(Integer profitResult) {
    this.profitResult = profitResult;
    return this;
  }

  /**
   * 利益実績
   * @return profitResult
  */
  
  @Schema(name = "profitResult", description = "利益実績", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("profitResult")
  public Integer getProfitResult() {
    return profitResult;
  }

  public void setProfitResult(Integer profitResult) {
    this.profitResult = profitResult;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Profit profit = (Profit) o;
    return Objects.equals(this.profitId, profit.profitId) &&
        Objects.equals(this.userId, profit.userId) &&
        Objects.equals(this.year, profit.year) &&
        Objects.equals(this.month, profit.month) &&
        Objects.equals(this.profitTarget, profit.profitTarget) &&
        Objects.equals(this.profitResult, profit.profitResult);
  }

  @Override
  public int hashCode() {
    return Objects.hash(profitId, userId, year, month, profitTarget, profitResult);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Profit {\n");
    sb.append("    profitId: ").append(toIndentedString(profitId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    month: ").append(toIndentedString(month)).append("\n");
    sb.append("    profitTarget: ").append(toIndentedString(profitTarget)).append("\n");
    sb.append("    profitResult: ").append(toIndentedString(profitResult)).append("\n");
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

