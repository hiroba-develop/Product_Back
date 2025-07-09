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
 * ApiAuthSetupPostRequest
 */

@JsonTypeName("_api_auth_setup_post_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ApiAuthSetupPostRequest {

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

  public ApiAuthSetupPostRequest userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * ユーザーID（UUID）
   * @return userId
  */
  
  @Schema(name = "userId", example = "550e8400-e29b-41d4-a716-446655440000", description = "ユーザーID（UUID）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userId")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public ApiAuthSetupPostRequest name(String name) {
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

  public ApiAuthSetupPostRequest company(String company) {
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

  public ApiAuthSetupPostRequest telNo(String telNo) {
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

  public ApiAuthSetupPostRequest companySize(Integer companySize) {
    this.companySize = companySize;
    return this;
  }

  /**
   * 企業規模 - 1: 個人事業主 - 2: 法人(従業員1-5名) - 3: 法人(従業員6-20名) - 4: 法人(従業員21名以上) 
   * @return companySize
  */
  
  @Schema(name = "companySize", description = "企業規模 - 1: 個人事業主 - 2: 法人(従業員1-5名) - 3: 法人(従業員6-20名) - 4: 法人(従業員21名以上) ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("companySize")
  public Integer getCompanySize() {
    return companySize;
  }

  public void setCompanySize(Integer companySize) {
    this.companySize = companySize;
  }

  public ApiAuthSetupPostRequest industry(Integer industry) {
    this.industry = industry;
    return this;
  }

  /**
   * 業界 - 1: IT・ソフトウェア - 2: 製造業 - 3: 小売業 - 4: 飲食業 - 5: サービス業 - 6: 建設業 - 7: 医療・福祉 - 8: 教育 - 9: 金融・保険 - 10: 不動産 - 11: その他 
   * @return industry
  */
  
  @Schema(name = "industry", description = "業界 - 1: IT・ソフトウェア - 2: 製造業 - 3: 小売業 - 4: 飲食業 - 5: サービス業 - 6: 建設業 - 7: 医療・福祉 - 8: 教育 - 9: 金融・保険 - 10: 不動産 - 11: その他 ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("industry")
  public Integer getIndustry() {
    return industry;
  }

  public void setIndustry(Integer industry) {
    this.industry = industry;
  }

  public ApiAuthSetupPostRequest fiscalYearStartYear(Integer fiscalYearStartYear) {
    this.fiscalYearStartYear = fiscalYearStartYear;
    return this;
  }

  /**
   * 事業年度開始年
   * @return fiscalYearStartYear
  */
  
  @Schema(name = "fiscalYearStartYear", description = "事業年度開始年", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fiscalYearStartYear")
  public Integer getFiscalYearStartYear() {
    return fiscalYearStartYear;
  }

  public void setFiscalYearStartYear(Integer fiscalYearStartYear) {
    this.fiscalYearStartYear = fiscalYearStartYear;
  }

  public ApiAuthSetupPostRequest fiscalYearStartMonth(Integer fiscalYearStartMonth) {
    this.fiscalYearStartMonth = fiscalYearStartMonth;
    return this;
  }

  /**
   * 事業年度開始月（1-12）
   * minimum: 1
   * maximum: 12
   * @return fiscalYearStartMonth
  */
  @Min(1) @Max(12) 
  @Schema(name = "fiscalYearStartMonth", description = "事業年度開始月（1-12）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fiscalYearStartMonth")
  public Integer getFiscalYearStartMonth() {
    return fiscalYearStartMonth;
  }

  public void setFiscalYearStartMonth(Integer fiscalYearStartMonth) {
    this.fiscalYearStartMonth = fiscalYearStartMonth;
  }

  public ApiAuthSetupPostRequest totalAssets(Integer totalAssets) {
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

  public ApiAuthSetupPostRequest businessExperience(Integer businessExperience) {
    this.businessExperience = businessExperience;
    return this;
  }

  /**
   * 事業経験年数 - 1: 1年未満 - 2: 1-3年未満 - 3: 3-5年未満 - 4: 5-10年未満 - 5: 10年以上 
   * @return businessExperience
  */
  
  @Schema(name = "businessExperience", description = "事業経験年数 - 1: 1年未満 - 2: 1-3年未満 - 3: 3-5年未満 - 4: 5-10年未満 - 5: 10年以上 ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("businessExperience")
  public Integer getBusinessExperience() {
    return businessExperience;
  }

  public void setBusinessExperience(Integer businessExperience) {
    this.businessExperience = businessExperience;
  }

  public ApiAuthSetupPostRequest financialKnowledge(Integer financialKnowledge) {
    this.financialKnowledge = financialKnowledge;
    return this;
  }

  /**
   * 財務・会計の知識レベル - 1: 初心者 - 2: 基本レベル - 3: 中級レベル - 4: 上級レベル 
   * @return financialKnowledge
  */
  
  @Schema(name = "financialKnowledge", description = "財務・会計の知識レベル - 1: 初心者 - 2: 基本レベル - 3: 中級レベル - 4: 上級レベル ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    ApiAuthSetupPostRequest apiAuthSetupPostRequest = (ApiAuthSetupPostRequest) o;
    return Objects.equals(this.userId, apiAuthSetupPostRequest.userId) &&
        Objects.equals(this.name, apiAuthSetupPostRequest.name) &&
        Objects.equals(this.company, apiAuthSetupPostRequest.company) &&
        Objects.equals(this.telNo, apiAuthSetupPostRequest.telNo) &&
        Objects.equals(this.companySize, apiAuthSetupPostRequest.companySize) &&
        Objects.equals(this.industry, apiAuthSetupPostRequest.industry) &&
        Objects.equals(this.fiscalYearStartYear, apiAuthSetupPostRequest.fiscalYearStartYear) &&
        Objects.equals(this.fiscalYearStartMonth, apiAuthSetupPostRequest.fiscalYearStartMonth) &&
        Objects.equals(this.totalAssets, apiAuthSetupPostRequest.totalAssets) &&
        Objects.equals(this.businessExperience, apiAuthSetupPostRequest.businessExperience) &&
        Objects.equals(this.financialKnowledge, apiAuthSetupPostRequest.financialKnowledge);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, name, company, telNo, companySize, industry, fiscalYearStartYear, fiscalYearStartMonth, totalAssets, businessExperience, financialKnowledge);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiAuthSetupPostRequest {\n");
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

