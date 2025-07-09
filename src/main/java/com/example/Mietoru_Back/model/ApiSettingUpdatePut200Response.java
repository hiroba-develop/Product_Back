package com.example.Mietoru_Back.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ApiSettingUpdatePut200Response
 */

@JsonTypeName("_api_setting_update_put_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ApiSettingUpdatePut200Response {

  private Integer responseStatus;

  private String userId;

  private String name;

  private String company;

  private String telNo;

  private Integer companySize;

  private Integer industry;

  private Integer fiscalYearStartYear;

  private Integer fiscalYearStartMonth;

  private Integer totalAssets;

  private Integer businessExperience;

  private Integer financialKnowledge;

  public ApiSettingUpdatePut200Response responseStatus(Integer responseStatus) {
    this.responseStatus = responseStatus;
    return this;
  }

  /**
   * レスポンスステータス（1:成功、0:失敗）
   * @return responseStatus
  */
  
  @Schema(name = "responseStatus", description = "レスポンスステータス（1:成功、0:失敗）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("responseStatus")
  public Integer getResponseStatus() {
    return responseStatus;
  }

  public void setResponseStatus(Integer responseStatus) {
    this.responseStatus = responseStatus;
  }

  public ApiSettingUpdatePut200Response userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  */
  
  @Schema(name = "userId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userId")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public ApiSettingUpdatePut200Response name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ApiSettingUpdatePut200Response company(String company) {
    this.company = company;
    return this;
  }

  /**
   * Get company
   * @return company
  */
  
  @Schema(name = "company", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("company")
  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public ApiSettingUpdatePut200Response telNo(String telNo) {
    this.telNo = telNo;
    return this;
  }

  /**
   * Get telNo
   * @return telNo
  */
  
  @Schema(name = "telNo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("telNo")
  public String getTelNo() {
    return telNo;
  }

  public void setTelNo(String telNo) {
    this.telNo = telNo;
  }

  public ApiSettingUpdatePut200Response companySize(Integer companySize) {
    this.companySize = companySize;
    return this;
  }

  /**
   * Get companySize
   * @return companySize
  */
  
  @Schema(name = "companySize", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("companySize")
  public Integer getCompanySize() {
    return companySize;
  }

  public void setCompanySize(Integer companySize) {
    this.companySize = companySize;
  }

  public ApiSettingUpdatePut200Response industry(Integer industry) {
    this.industry = industry;
    return this;
  }

  /**
   * Get industry
   * @return industry
  */
  
  @Schema(name = "industry", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("industry")
  public Integer getIndustry() {
    return industry;
  }

  public void setIndustry(Integer industry) {
    this.industry = industry;
  }

  public ApiSettingUpdatePut200Response fiscalYearStartYear(Integer fiscalYearStartYear) {
    this.fiscalYearStartYear = fiscalYearStartYear;
    return this;
  }

  /**
   * Get fiscalYearStartYear
   * @return fiscalYearStartYear
  */
  
  @Schema(name = "fiscalYearStartYear", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fiscalYearStartYear")
  public Integer getFiscalYearStartYear() {
    return fiscalYearStartYear;
  }

  public void setFiscalYearStartYear(Integer fiscalYearStartYear) {
    this.fiscalYearStartYear = fiscalYearStartYear;
  }

  public ApiSettingUpdatePut200Response fiscalYearStartMonth(Integer fiscalYearStartMonth) {
    this.fiscalYearStartMonth = fiscalYearStartMonth;
    return this;
  }

  /**
   * Get fiscalYearStartMonth
   * @return fiscalYearStartMonth
  */
  
  @Schema(name = "fiscalYearStartMonth", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fiscalYearStartMonth")
  public Integer getFiscalYearStartMonth() {
    return fiscalYearStartMonth;
  }

  public void setFiscalYearStartMonth(Integer fiscalYearStartMonth) {
    this.fiscalYearStartMonth = fiscalYearStartMonth;
  }

  public ApiSettingUpdatePut200Response totalAssets(Integer totalAssets) {
    this.totalAssets = totalAssets;
    return this;
  }

  /**
   * Get totalAssets
   * @return totalAssets
  */
  
  @Schema(name = "totalAssets", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalAssets")
  public Integer getTotalAssets() {
    return totalAssets;
  }

  public void setTotalAssets(Integer totalAssets) {
    this.totalAssets = totalAssets;
  }

  public ApiSettingUpdatePut200Response businessExperience(Integer businessExperience) {
    this.businessExperience = businessExperience;
    return this;
  }

  /**
   * Get businessExperience
   * @return businessExperience
  */
  
  @Schema(name = "businessExperience", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("businessExperience")
  public Integer getBusinessExperience() {
    return businessExperience;
  }

  public void setBusinessExperience(Integer businessExperience) {
    this.businessExperience = businessExperience;
  }

  public ApiSettingUpdatePut200Response financialKnowledge(Integer financialKnowledge) {
    this.financialKnowledge = financialKnowledge;
    return this;
  }

  /**
   * Get financialKnowledge
   * @return financialKnowledge
  */
  
  @Schema(name = "financialKnowledge", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("financialKnowledge")
  public Integer getFinancialKnowledge() {
    return financialKnowledge;
  }

  public void setFinancialKnowledge(Integer financialKnowledge) {
    this.financialKnowledge = financialKnowledge;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiSettingUpdatePut200Response apiSettingUpdatePut200Response = (ApiSettingUpdatePut200Response) o;
    return Objects.equals(this.responseStatus, apiSettingUpdatePut200Response.responseStatus) &&
        Objects.equals(this.userId, apiSettingUpdatePut200Response.userId) &&
        Objects.equals(this.name, apiSettingUpdatePut200Response.name) &&
        Objects.equals(this.company, apiSettingUpdatePut200Response.company) &&
        Objects.equals(this.telNo, apiSettingUpdatePut200Response.telNo) &&
        Objects.equals(this.companySize, apiSettingUpdatePut200Response.companySize) &&
        Objects.equals(this.industry, apiSettingUpdatePut200Response.industry) &&
        Objects.equals(this.fiscalYearStartYear, apiSettingUpdatePut200Response.fiscalYearStartYear) &&
        Objects.equals(this.fiscalYearStartMonth, apiSettingUpdatePut200Response.fiscalYearStartMonth) &&
        Objects.equals(this.totalAssets, apiSettingUpdatePut200Response.totalAssets) &&
        Objects.equals(this.businessExperience, apiSettingUpdatePut200Response.businessExperience) &&
        Objects.equals(this.financialKnowledge, apiSettingUpdatePut200Response.financialKnowledge);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseStatus, userId, name, company, telNo, companySize, industry, fiscalYearStartYear, fiscalYearStartMonth, totalAssets, businessExperience, financialKnowledge);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiSettingUpdatePut200Response {\n");
    sb.append("    responseStatus: ").append(toIndentedString(responseStatus)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("    telNo: ").append(toIndentedString(telNo)).append("\n");
    sb.append("    companySize: ").append(toIndentedString(companySize)).append("\n");
    sb.append("    industry: ").append(toIndentedString(industry)).append("\n");
    sb.append("    fiscalYearStartYear: ").append(toIndentedString(fiscalYearStartYear)).append("\n");
    sb.append("    fiscalYearStartMonth: ").append(toIndentedString(fiscalYearStartMonth)).append("\n");
    sb.append("    totalAssets: ").append(toIndentedString(totalAssets)).append("\n");
    sb.append("    businessExperience: ").append(toIndentedString(businessExperience)).append("\n");
    sb.append("    financialKnowledge: ").append(toIndentedString(financialKnowledge)).append("\n");
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

