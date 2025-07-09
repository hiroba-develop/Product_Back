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
 * ApiSettingUpdatePutRequest
 */

@JsonTypeName("_api_setting_update_put_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ApiSettingUpdatePutRequest {

  private String userId;

  private String name;

  private String company;

  private String telNo;

  private Integer companySize;

  private Integer industry;

  private Integer fiscalYearStartMonth;

  private Integer totalAssets;

  private Integer businessExperience;

  private Integer financialKnowledge;

  public ApiSettingUpdatePutRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ApiSettingUpdatePutRequest(String userId) {
    this.userId = userId;
  }

  public ApiSettingUpdatePutRequest userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * ユーザーID（UUID）
   * @return userId
  */
  @NotNull 
  @Schema(name = "userId", description = "ユーザーID（UUID）", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("userId")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public ApiSettingUpdatePutRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * ユーザー名
   * @return name
  */
  @Size(max = 100) 
  @Schema(name = "name", description = "ユーザー名", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ApiSettingUpdatePutRequest company(String company) {
    this.company = company;
    return this;
  }

  /**
   * 会社名
   * @return company
  */
  @Size(max = 200) 
  @Schema(name = "company", description = "会社名", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("company")
  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public ApiSettingUpdatePutRequest telNo(String telNo) {
    this.telNo = telNo;
    return this;
  }

  /**
   * 電話番号
   * @return telNo
  */
  @Size(max = 20) 
  @Schema(name = "telNo", description = "電話番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("telNo")
  public String getTelNo() {
    return telNo;
  }

  public void setTelNo(String telNo) {
    this.telNo = telNo;
  }

  public ApiSettingUpdatePutRequest companySize(Integer companySize) {
    this.companySize = companySize;
    return this;
  }

  /**
   * 企業規模
   * @return companySize
  */
  
  @Schema(name = "companySize", description = "企業規模", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("companySize")
  public Integer getCompanySize() {
    return companySize;
  }

  public void setCompanySize(Integer companySize) {
    this.companySize = companySize;
  }

  public ApiSettingUpdatePutRequest industry(Integer industry) {
    this.industry = industry;
    return this;
  }

  /**
   * 業界
   * @return industry
  */
  
  @Schema(name = "industry", description = "業界", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("industry")
  public Integer getIndustry() {
    return industry;
  }

  public void setIndustry(Integer industry) {
    this.industry = industry;
  }

  public ApiSettingUpdatePutRequest fiscalYearStartMonth(Integer fiscalYearStartMonth) {
    this.fiscalYearStartMonth = fiscalYearStartMonth;
    return this;
  }

  /**
   * 事業年度開始月
   * @return fiscalYearStartMonth
  */
  
  @Schema(name = "fiscalYearStartMonth", description = "事業年度開始月", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fiscalYearStartMonth")
  public Integer getFiscalYearStartMonth() {
    return fiscalYearStartMonth;
  }

  public void setFiscalYearStartMonth(Integer fiscalYearStartMonth) {
    this.fiscalYearStartMonth = fiscalYearStartMonth;
  }

  public ApiSettingUpdatePutRequest totalAssets(Integer totalAssets) {
    this.totalAssets = totalAssets;
    return this;
  }

  /**
   * 総資産
   * @return totalAssets
  */
  
  @Schema(name = "totalAssets", description = "総資産", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalAssets")
  public Integer getTotalAssets() {
    return totalAssets;
  }

  public void setTotalAssets(Integer totalAssets) {
    this.totalAssets = totalAssets;
  }

  public ApiSettingUpdatePutRequest businessExperience(Integer businessExperience) {
    this.businessExperience = businessExperience;
    return this;
  }

  /**
   * 事業経験年数
   * @return businessExperience
  */
  
  @Schema(name = "businessExperience", description = "事業経験年数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("businessExperience")
  public Integer getBusinessExperience() {
    return businessExperience;
  }

  public void setBusinessExperience(Integer businessExperience) {
    this.businessExperience = businessExperience;
  }

  public ApiSettingUpdatePutRequest financialKnowledge(Integer financialKnowledge) {
    this.financialKnowledge = financialKnowledge;
    return this;
  }

  /**
   * 財務・会計の知識レベル
   * @return financialKnowledge
  */
  
  @Schema(name = "financialKnowledge", description = "財務・会計の知識レベル", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    ApiSettingUpdatePutRequest apiSettingUpdatePutRequest = (ApiSettingUpdatePutRequest) o;
    return Objects.equals(this.userId, apiSettingUpdatePutRequest.userId) &&
        Objects.equals(this.name, apiSettingUpdatePutRequest.name) &&
        Objects.equals(this.company, apiSettingUpdatePutRequest.company) &&
        Objects.equals(this.telNo, apiSettingUpdatePutRequest.telNo) &&
        Objects.equals(this.companySize, apiSettingUpdatePutRequest.companySize) &&
        Objects.equals(this.industry, apiSettingUpdatePutRequest.industry) &&
        Objects.equals(this.fiscalYearStartMonth, apiSettingUpdatePutRequest.fiscalYearStartMonth) &&
        Objects.equals(this.totalAssets, apiSettingUpdatePutRequest.totalAssets) &&
        Objects.equals(this.businessExperience, apiSettingUpdatePutRequest.businessExperience) &&
        Objects.equals(this.financialKnowledge, apiSettingUpdatePutRequest.financialKnowledge);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, name, company, telNo, companySize, industry, fiscalYearStartMonth, totalAssets, businessExperience, financialKnowledge);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiSettingUpdatePutRequest {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("    telNo: ").append(toIndentedString(telNo)).append("\n");
    sb.append("    companySize: ").append(toIndentedString(companySize)).append("\n");
    sb.append("    industry: ").append(toIndentedString(industry)).append("\n");
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

