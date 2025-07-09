package com.example.Mietoru_Back.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CommentHistory
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class CommentHistory {

  private String commentId;

  private String comment;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime commentDate;

  public CommentHistory commentId(String commentId) {
    this.commentId = commentId;
    return this;
  }

  /**
   * コメントID（UUID）
   * @return commentId
  */
  
  @Schema(name = "commentId", description = "コメントID（UUID）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("commentId")
  public String getCommentId() {
    return commentId;
  }

  public void setCommentId(String commentId) {
    this.commentId = commentId;
  }

  public CommentHistory comment(String comment) {
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

  public CommentHistory commentDate(LocalDateTime commentDate) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommentHistory commentHistory = (CommentHistory) o;
    return Objects.equals(this.commentId, commentHistory.commentId) &&
        Objects.equals(this.comment, commentHistory.comment) &&
        Objects.equals(this.commentDate, commentHistory.commentDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commentId, comment, commentDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommentHistory {\n");
    sb.append("    commentId: ").append(toIndentedString(commentId)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    commentDate: ").append(toIndentedString(commentDate)).append("\n");
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

