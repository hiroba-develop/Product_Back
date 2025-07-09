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
 * TaxAccountantComment
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class TaxAccountantComment {

  private String taxAccountantCommentId;

  private String userId;

  private Integer year;

  private Integer month;

  private String comment;

  private String commentFlg;

  public TaxAccountantComment taxAccountantCommentId(String taxAccountantCommentId) {
    this.taxAccountantCommentId = taxAccountantCommentId;
    return this;
  }

  /**
   * 税理士コメントID（UUID）
   * @return taxAccountantCommentId
  */
  
  @Schema(name = "taxAccountantCommentId", description = "税理士コメントID（UUID）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("taxAccountantCommentId")
  public String getTaxAccountantCommentId() {
    return taxAccountantCommentId;
  }

  public void setTaxAccountantCommentId(String taxAccountantCommentId) {
    this.taxAccountantCommentId = taxAccountantCommentId;
  }

  public TaxAccountantComment userId(String userId) {
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

  public TaxAccountantComment year(Integer year) {
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

  public TaxAccountantComment month(Integer month) {
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

  public TaxAccountantComment comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * コメント内容
   * @return comment
  */
  @Size(max = 1024) 
  @Schema(name = "comment", description = "コメント内容", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("comment")
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public TaxAccountantComment commentFlg(String commentFlg) {
    this.commentFlg = commentFlg;
    return this;
  }

  /**
   * コメント済フラグ（0:コメント未実施、1:コメント実施済）
   * @return commentFlg
  */
  
  @Schema(name = "commentFlg", description = "コメント済フラグ（0:コメント未実施、1:コメント実施済）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("commentFlg")
  public String getCommentFlg() {
    return commentFlg;
  }

  public void setCommentFlg(String commentFlg) {
    this.commentFlg = commentFlg;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaxAccountantComment taxAccountantComment = (TaxAccountantComment) o;
    return Objects.equals(this.taxAccountantCommentId, taxAccountantComment.taxAccountantCommentId) &&
        Objects.equals(this.userId, taxAccountantComment.userId) &&
        Objects.equals(this.year, taxAccountantComment.year) &&
        Objects.equals(this.month, taxAccountantComment.month) &&
        Objects.equals(this.comment, taxAccountantComment.comment) &&
        Objects.equals(this.commentFlg, taxAccountantComment.commentFlg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taxAccountantCommentId, userId, year, month, comment, commentFlg);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaxAccountantComment {\n");
    sb.append("    taxAccountantCommentId: ").append(toIndentedString(taxAccountantCommentId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    month: ").append(toIndentedString(month)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    commentFlg: ").append(toIndentedString(commentFlg)).append("\n");
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

