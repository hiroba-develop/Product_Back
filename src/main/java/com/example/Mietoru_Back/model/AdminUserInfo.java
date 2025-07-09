package com.example.Mietoru_Back.model;

import java.net.URI;
import java.util.Objects;
import com.example.Mietoru_Back.model.CommentHistory;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AdminUserInfo
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class AdminUserInfo {

  private String userId;

  private String userName;

  private String email;

  private String businessName;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime lastUpdated;

  private Integer fiscalYearEndMonth;

  private Integer lastMonthSalesTarget;

  private Integer lastMonthSalesActual;

  private Float lastMonthSalesAchievementRate;

  private Integer lastMonthProfitTarget;

  private Integer lastMonthProfitActual;

  private Float lastMonthProfitAchievementRate;

  private Integer currentMonthSalesTarget;

  private Integer currentMonthSalesActual;

  private Float currentMonthSalesAchievementRate;

  private Integer currentMonthProfitTarget;

  private Integer currentMonthProfitActual;

  private Float currentMonthProfitAchievementRate;

  private Float yearOverYearComparison;

  private Float cumulativeAchievementRate;

  private Boolean hasComment;

  private String comment;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime commentDate;

  @Valid
  private List<@Valid CommentHistory> commentHistory;

  public AdminUserInfo userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * ユーザーID
   * @return userId
  */
  
  @Schema(name = "userId", description = "ユーザーID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userId")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public AdminUserInfo userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * ユーザー名
   * @return userName
  */
  
  @Schema(name = "userName", description = "ユーザー名", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userName")
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public AdminUserInfo email(String email) {
    this.email = email;
    return this;
  }

  /**
   * メールアドレス
   * @return email
  */
  
  @Schema(name = "email", description = "メールアドレス", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public AdminUserInfo businessName(String businessName) {
    this.businessName = businessName;
    return this;
  }

  /**
   * 事業者名
   * @return businessName
  */
  
  @Schema(name = "businessName", description = "事業者名", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("businessName")
  public String getBusinessName() {
    return businessName;
  }

  public void setBusinessName(String businessName) {
    this.businessName = businessName;
  }

  public AdminUserInfo lastUpdated(LocalDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

  /**
   * 最終更新日時
   * @return lastUpdated
  */
  @Valid 
  @Schema(name = "lastUpdated", description = "最終更新日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastUpdated")
  public LocalDateTime getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(LocalDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public AdminUserInfo fiscalYearEndMonth(Integer fiscalYearEndMonth) {
    this.fiscalYearEndMonth = fiscalYearEndMonth;
    return this;
  }

  /**
   * 決算月（1-12）
   * minimum: 1
   * maximum: 12
   * @return fiscalYearEndMonth
  */
  @Min(1) @Max(12) 
  @Schema(name = "fiscalYearEndMonth", description = "決算月（1-12）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fiscalYearEndMonth")
  public Integer getFiscalYearEndMonth() {
    return fiscalYearEndMonth;
  }

  public void setFiscalYearEndMonth(Integer fiscalYearEndMonth) {
    this.fiscalYearEndMonth = fiscalYearEndMonth;
  }

  public AdminUserInfo lastMonthSalesTarget(Integer lastMonthSalesTarget) {
    this.lastMonthSalesTarget = lastMonthSalesTarget;
    return this;
  }

  /**
   * 先月の売上目標
   * @return lastMonthSalesTarget
  */
  
  @Schema(name = "lastMonthSalesTarget", description = "先月の売上目標", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastMonthSalesTarget")
  public Integer getLastMonthSalesTarget() {
    return lastMonthSalesTarget;
  }

  public void setLastMonthSalesTarget(Integer lastMonthSalesTarget) {
    this.lastMonthSalesTarget = lastMonthSalesTarget;
  }

  public AdminUserInfo lastMonthSalesActual(Integer lastMonthSalesActual) {
    this.lastMonthSalesActual = lastMonthSalesActual;
    return this;
  }

  /**
   * 先月の売上実績
   * @return lastMonthSalesActual
  */
  
  @Schema(name = "lastMonthSalesActual", description = "先月の売上実績", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastMonthSalesActual")
  public Integer getLastMonthSalesActual() {
    return lastMonthSalesActual;
  }

  public void setLastMonthSalesActual(Integer lastMonthSalesActual) {
    this.lastMonthSalesActual = lastMonthSalesActual;
  }

  public AdminUserInfo lastMonthSalesAchievementRate(Float lastMonthSalesAchievementRate) {
    this.lastMonthSalesAchievementRate = lastMonthSalesAchievementRate;
    return this;
  }

  /**
   * 先月の売上達成率
   * @return lastMonthSalesAchievementRate
  */
  
  @Schema(name = "lastMonthSalesAchievementRate", description = "先月の売上達成率", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastMonthSalesAchievementRate")
  public Float getLastMonthSalesAchievementRate() {
    return lastMonthSalesAchievementRate;
  }

  public void setLastMonthSalesAchievementRate(Float lastMonthSalesAchievementRate) {
    this.lastMonthSalesAchievementRate = lastMonthSalesAchievementRate;
  }

  public AdminUserInfo lastMonthProfitTarget(Integer lastMonthProfitTarget) {
    this.lastMonthProfitTarget = lastMonthProfitTarget;
    return this;
  }

  /**
   * 先月の利益目標
   * @return lastMonthProfitTarget
  */
  
  @Schema(name = "lastMonthProfitTarget", description = "先月の利益目標", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastMonthProfitTarget")
  public Integer getLastMonthProfitTarget() {
    return lastMonthProfitTarget;
  }

  public void setLastMonthProfitTarget(Integer lastMonthProfitTarget) {
    this.lastMonthProfitTarget = lastMonthProfitTarget;
  }

  public AdminUserInfo lastMonthProfitActual(Integer lastMonthProfitActual) {
    this.lastMonthProfitActual = lastMonthProfitActual;
    return this;
  }

  /**
   * 先月の利益実績
   * @return lastMonthProfitActual
  */
  
  @Schema(name = "lastMonthProfitActual", description = "先月の利益実績", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastMonthProfitActual")
  public Integer getLastMonthProfitActual() {
    return lastMonthProfitActual;
  }

  public void setLastMonthProfitActual(Integer lastMonthProfitActual) {
    this.lastMonthProfitActual = lastMonthProfitActual;
  }

  public AdminUserInfo lastMonthProfitAchievementRate(Float lastMonthProfitAchievementRate) {
    this.lastMonthProfitAchievementRate = lastMonthProfitAchievementRate;
    return this;
  }

  /**
   * 先月の利益達成率
   * @return lastMonthProfitAchievementRate
  */
  
  @Schema(name = "lastMonthProfitAchievementRate", description = "先月の利益達成率", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastMonthProfitAchievementRate")
  public Float getLastMonthProfitAchievementRate() {
    return lastMonthProfitAchievementRate;
  }

  public void setLastMonthProfitAchievementRate(Float lastMonthProfitAchievementRate) {
    this.lastMonthProfitAchievementRate = lastMonthProfitAchievementRate;
  }

  public AdminUserInfo currentMonthSalesTarget(Integer currentMonthSalesTarget) {
    this.currentMonthSalesTarget = currentMonthSalesTarget;
    return this;
  }

  /**
   * 今月の売上目標
   * @return currentMonthSalesTarget
  */
  
  @Schema(name = "currentMonthSalesTarget", description = "今月の売上目標", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("currentMonthSalesTarget")
  public Integer getCurrentMonthSalesTarget() {
    return currentMonthSalesTarget;
  }

  public void setCurrentMonthSalesTarget(Integer currentMonthSalesTarget) {
    this.currentMonthSalesTarget = currentMonthSalesTarget;
  }

  public AdminUserInfo currentMonthSalesActual(Integer currentMonthSalesActual) {
    this.currentMonthSalesActual = currentMonthSalesActual;
    return this;
  }

  /**
   * 今月の売上実績
   * @return currentMonthSalesActual
  */
  
  @Schema(name = "currentMonthSalesActual", description = "今月の売上実績", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("currentMonthSalesActual")
  public Integer getCurrentMonthSalesActual() {
    return currentMonthSalesActual;
  }

  public void setCurrentMonthSalesActual(Integer currentMonthSalesActual) {
    this.currentMonthSalesActual = currentMonthSalesActual;
  }

  public AdminUserInfo currentMonthSalesAchievementRate(Float currentMonthSalesAchievementRate) {
    this.currentMonthSalesAchievementRate = currentMonthSalesAchievementRate;
    return this;
  }

  /**
   * 今月の売上達成率
   * @return currentMonthSalesAchievementRate
  */
  
  @Schema(name = "currentMonthSalesAchievementRate", description = "今月の売上達成率", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("currentMonthSalesAchievementRate")
  public Float getCurrentMonthSalesAchievementRate() {
    return currentMonthSalesAchievementRate;
  }

  public void setCurrentMonthSalesAchievementRate(Float currentMonthSalesAchievementRate) {
    this.currentMonthSalesAchievementRate = currentMonthSalesAchievementRate;
  }

  public AdminUserInfo currentMonthProfitTarget(Integer currentMonthProfitTarget) {
    this.currentMonthProfitTarget = currentMonthProfitTarget;
    return this;
  }

  /**
   * 今月の利益目標
   * @return currentMonthProfitTarget
  */
  
  @Schema(name = "currentMonthProfitTarget", description = "今月の利益目標", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("currentMonthProfitTarget")
  public Integer getCurrentMonthProfitTarget() {
    return currentMonthProfitTarget;
  }

  public void setCurrentMonthProfitTarget(Integer currentMonthProfitTarget) {
    this.currentMonthProfitTarget = currentMonthProfitTarget;
  }

  public AdminUserInfo currentMonthProfitActual(Integer currentMonthProfitActual) {
    this.currentMonthProfitActual = currentMonthProfitActual;
    return this;
  }

  /**
   * 今月の利益実績
   * @return currentMonthProfitActual
  */
  
  @Schema(name = "currentMonthProfitActual", description = "今月の利益実績", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("currentMonthProfitActual")
  public Integer getCurrentMonthProfitActual() {
    return currentMonthProfitActual;
  }

  public void setCurrentMonthProfitActual(Integer currentMonthProfitActual) {
    this.currentMonthProfitActual = currentMonthProfitActual;
  }

  public AdminUserInfo currentMonthProfitAchievementRate(Float currentMonthProfitAchievementRate) {
    this.currentMonthProfitAchievementRate = currentMonthProfitAchievementRate;
    return this;
  }

  /**
   * 今月の利益達成率
   * @return currentMonthProfitAchievementRate
  */
  
  @Schema(name = "currentMonthProfitAchievementRate", description = "今月の利益達成率", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("currentMonthProfitAchievementRate")
  public Float getCurrentMonthProfitAchievementRate() {
    return currentMonthProfitAchievementRate;
  }

  public void setCurrentMonthProfitAchievementRate(Float currentMonthProfitAchievementRate) {
    this.currentMonthProfitAchievementRate = currentMonthProfitAchievementRate;
  }

  public AdminUserInfo yearOverYearComparison(Float yearOverYearComparison) {
    this.yearOverYearComparison = yearOverYearComparison;
    return this;
  }

  /**
   * 前年同月比
   * @return yearOverYearComparison
  */
  
  @Schema(name = "yearOverYearComparison", description = "前年同月比", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("yearOverYearComparison")
  public Float getYearOverYearComparison() {
    return yearOverYearComparison;
  }

  public void setYearOverYearComparison(Float yearOverYearComparison) {
    this.yearOverYearComparison = yearOverYearComparison;
  }

  public AdminUserInfo cumulativeAchievementRate(Float cumulativeAchievementRate) {
    this.cumulativeAchievementRate = cumulativeAchievementRate;
    return this;
  }

  /**
   * 累計達成率
   * @return cumulativeAchievementRate
  */
  
  @Schema(name = "cumulativeAchievementRate", description = "累計達成率", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cumulativeAchievementRate")
  public Float getCumulativeAchievementRate() {
    return cumulativeAchievementRate;
  }

  public void setCumulativeAchievementRate(Float cumulativeAchievementRate) {
    this.cumulativeAchievementRate = cumulativeAchievementRate;
  }

  public AdminUserInfo hasComment(Boolean hasComment) {
    this.hasComment = hasComment;
    return this;
  }

  /**
   * コメントの有無
   * @return hasComment
  */
  
  @Schema(name = "hasComment", description = "コメントの有無", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("hasComment")
  public Boolean getHasComment() {
    return hasComment;
  }

  public void setHasComment(Boolean hasComment) {
    this.hasComment = hasComment;
  }

  public AdminUserInfo comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * コメント内容
   * @return comment
  */
  
  @Schema(name = "comment", description = "コメント内容", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("comment")
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public AdminUserInfo commentDate(LocalDateTime commentDate) {
    this.commentDate = commentDate;
    return this;
  }

  /**
   * コメント日付
   * @return commentDate
  */
  @Valid 
  @Schema(name = "commentDate", description = "コメント日付", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("commentDate")
  public LocalDateTime getCommentDate() {
    return commentDate;
  }

  public void setCommentDate(LocalDateTime commentDate) {
    this.commentDate = commentDate;
  }

  public AdminUserInfo commentHistory(List<@Valid CommentHistory> commentHistory) {
    this.commentHistory = commentHistory;
    return this;
  }

  public AdminUserInfo addCommentHistoryItem(CommentHistory commentHistoryItem) {
    if (this.commentHistory == null) {
      this.commentHistory = new ArrayList<>();
    }
    this.commentHistory.add(commentHistoryItem);
    return this;
  }

  /**
   * コメント履歴
   * @return commentHistory
  */
  @Valid 
  @Schema(name = "commentHistory", description = "コメント履歴", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("commentHistory")
  public List<@Valid CommentHistory> getCommentHistory() {
    return commentHistory;
  }

  public void setCommentHistory(List<@Valid CommentHistory> commentHistory) {
    this.commentHistory = commentHistory;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdminUserInfo adminUserInfo = (AdminUserInfo) o;
    return Objects.equals(this.userId, adminUserInfo.userId) &&
        Objects.equals(this.userName, adminUserInfo.userName) &&
        Objects.equals(this.email, adminUserInfo.email) &&
        Objects.equals(this.businessName, adminUserInfo.businessName) &&
        Objects.equals(this.lastUpdated, adminUserInfo.lastUpdated) &&
        Objects.equals(this.fiscalYearEndMonth, adminUserInfo.fiscalYearEndMonth) &&
        Objects.equals(this.lastMonthSalesTarget, adminUserInfo.lastMonthSalesTarget) &&
        Objects.equals(this.lastMonthSalesActual, adminUserInfo.lastMonthSalesActual) &&
        Objects.equals(this.lastMonthSalesAchievementRate, adminUserInfo.lastMonthSalesAchievementRate) &&
        Objects.equals(this.lastMonthProfitTarget, adminUserInfo.lastMonthProfitTarget) &&
        Objects.equals(this.lastMonthProfitActual, adminUserInfo.lastMonthProfitActual) &&
        Objects.equals(this.lastMonthProfitAchievementRate, adminUserInfo.lastMonthProfitAchievementRate) &&
        Objects.equals(this.currentMonthSalesTarget, adminUserInfo.currentMonthSalesTarget) &&
        Objects.equals(this.currentMonthSalesActual, adminUserInfo.currentMonthSalesActual) &&
        Objects.equals(this.currentMonthSalesAchievementRate, adminUserInfo.currentMonthSalesAchievementRate) &&
        Objects.equals(this.currentMonthProfitTarget, adminUserInfo.currentMonthProfitTarget) &&
        Objects.equals(this.currentMonthProfitActual, adminUserInfo.currentMonthProfitActual) &&
        Objects.equals(this.currentMonthProfitAchievementRate, adminUserInfo.currentMonthProfitAchievementRate) &&
        Objects.equals(this.yearOverYearComparison, adminUserInfo.yearOverYearComparison) &&
        Objects.equals(this.cumulativeAchievementRate, adminUserInfo.cumulativeAchievementRate) &&
        Objects.equals(this.hasComment, adminUserInfo.hasComment) &&
        Objects.equals(this.comment, adminUserInfo.comment) &&
        Objects.equals(this.commentDate, adminUserInfo.commentDate) &&
        Objects.equals(this.commentHistory, adminUserInfo.commentHistory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, userName, email, businessName, lastUpdated, fiscalYearEndMonth, lastMonthSalesTarget, lastMonthSalesActual, lastMonthSalesAchievementRate, lastMonthProfitTarget, lastMonthProfitActual, lastMonthProfitAchievementRate, currentMonthSalesTarget, currentMonthSalesActual, currentMonthSalesAchievementRate, currentMonthProfitTarget, currentMonthProfitActual, currentMonthProfitAchievementRate, yearOverYearComparison, cumulativeAchievementRate, hasComment, comment, commentDate, commentHistory);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdminUserInfo {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    businessName: ").append(toIndentedString(businessName)).append("\n");
    sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
    sb.append("    fiscalYearEndMonth: ").append(toIndentedString(fiscalYearEndMonth)).append("\n");
    sb.append("    lastMonthSalesTarget: ").append(toIndentedString(lastMonthSalesTarget)).append("\n");
    sb.append("    lastMonthSalesActual: ").append(toIndentedString(lastMonthSalesActual)).append("\n");
    sb.append("    lastMonthSalesAchievementRate: ").append(toIndentedString(lastMonthSalesAchievementRate)).append("\n");
    sb.append("    lastMonthProfitTarget: ").append(toIndentedString(lastMonthProfitTarget)).append("\n");
    sb.append("    lastMonthProfitActual: ").append(toIndentedString(lastMonthProfitActual)).append("\n");
    sb.append("    lastMonthProfitAchievementRate: ").append(toIndentedString(lastMonthProfitAchievementRate)).append("\n");
    sb.append("    currentMonthSalesTarget: ").append(toIndentedString(currentMonthSalesTarget)).append("\n");
    sb.append("    currentMonthSalesActual: ").append(toIndentedString(currentMonthSalesActual)).append("\n");
    sb.append("    currentMonthSalesAchievementRate: ").append(toIndentedString(currentMonthSalesAchievementRate)).append("\n");
    sb.append("    currentMonthProfitTarget: ").append(toIndentedString(currentMonthProfitTarget)).append("\n");
    sb.append("    currentMonthProfitActual: ").append(toIndentedString(currentMonthProfitActual)).append("\n");
    sb.append("    currentMonthProfitAchievementRate: ").append(toIndentedString(currentMonthProfitAchievementRate)).append("\n");
    sb.append("    yearOverYearComparison: ").append(toIndentedString(yearOverYearComparison)).append("\n");
    sb.append("    cumulativeAchievementRate: ").append(toIndentedString(cumulativeAchievementRate)).append("\n");
    sb.append("    hasComment: ").append(toIndentedString(hasComment)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    commentDate: ").append(toIndentedString(commentDate)).append("\n");
    sb.append("    commentHistory: ").append(toIndentedString(commentHistory)).append("\n");
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

