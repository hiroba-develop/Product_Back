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
 * Sale
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Sale {

  private String saleId;

  private String userId;

  private Integer year;

  private Integer month;

  private Integer saleTarget;

  private Integer saleResult;

  public Sale saleId(String saleId) {
    this.saleId = saleId;
    return this;
  }

  /**
   * 売上ID（UUID）
   * @return saleId
  */
  
  @Schema(name = "saleId", description = "売上ID（UUID）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("saleId")
  public String getSaleId() {
    return saleId;
  }

  public void setSaleId(String saleId) {
    this.saleId = saleId;
  }

  public Sale userId(String userId) {
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

  public Sale year(Integer year) {
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

  public Sale month(Integer month) {
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

  public Sale saleTarget(Integer saleTarget) {
    this.saleTarget = saleTarget;
    return this;
  }

  /**
   * 売上目標
   * @return saleTarget
  */
  
  @Schema(name = "saleTarget", description = "売上目標", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("saleTarget")
  public Integer getSaleTarget() {
    return saleTarget;
  }

  public void setSaleTarget(Integer saleTarget) {
    this.saleTarget = saleTarget;
  }

  public Sale saleResult(Integer saleResult) {
    this.saleResult = saleResult;
    return this;
  }

  /**
   * 売上実績
   * @return saleResult
  */
  
  @Schema(name = "saleResult", description = "売上実績", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("saleResult")
  public Integer getSaleResult() {
    return saleResult;
  }

  public void setSaleResult(Integer saleResult) {
    this.saleResult = saleResult;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sale sale = (Sale) o;
    return Objects.equals(this.saleId, sale.saleId) &&
        Objects.equals(this.userId, sale.userId) &&
        Objects.equals(this.year, sale.year) &&
        Objects.equals(this.month, sale.month) &&
        Objects.equals(this.saleTarget, sale.saleTarget) &&
        Objects.equals(this.saleResult, sale.saleResult);
  }

  @Override
  public int hashCode() {
    return Objects.hash(saleId, userId, year, month, saleTarget, saleResult);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sale {\n");
    sb.append("    saleId: ").append(toIndentedString(saleId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    month: ").append(toIndentedString(month)).append("\n");
    sb.append("    saleTarget: ").append(toIndentedString(saleTarget)).append("\n");
    sb.append("    saleResult: ").append(toIndentedString(saleResult)).append("\n");
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

