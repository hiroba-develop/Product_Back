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
 * Task
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Task {

  private String taskId;

  private String userId;

  private String taskName;

  private String notificationCompleted;

  private String notificationEnabled;

  private Integer notificationDay;

  public Task taskId(String taskId) {
    this.taskId = taskId;
    return this;
  }

  /**
   * タスクID（UUID）
   * @return taskId
  */
  
  @Schema(name = "taskId", description = "タスクID（UUID）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("taskId")
  public String getTaskId() {
    return taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }

  public Task userId(String userId) {
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

  public Task taskName(String taskName) {
    this.taskName = taskName;
    return this;
  }

  /**
   * タスク名
   * @return taskName
  */
  
  @Schema(name = "taskName", description = "タスク名", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("taskName")
  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public Task notificationCompleted(String notificationCompleted) {
    this.notificationCompleted = notificationCompleted;
    return this;
  }

  /**
   * タスクの未完了・完了（0:未完了、1:完了）
   * @return notificationCompleted
  */
  
  @Schema(name = "notificationCompleted", description = "タスクの未完了・完了（0:未完了、1:完了）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("notificationCompleted")
  public String getNotificationCompleted() {
    return notificationCompleted;
  }

  public void setNotificationCompleted(String notificationCompleted) {
    this.notificationCompleted = notificationCompleted;
  }

  public Task notificationEnabled(String notificationEnabled) {
    this.notificationEnabled = notificationEnabled;
    return this;
  }

  /**
   * タスク通知の有効・無効（0:通知なし、1:通知あり）
   * @return notificationEnabled
  */
  
  @Schema(name = "notificationEnabled", description = "タスク通知の有効・無効（0:通知なし、1:通知あり）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("notificationEnabled")
  public String getNotificationEnabled() {
    return notificationEnabled;
  }

  public void setNotificationEnabled(String notificationEnabled) {
    this.notificationEnabled = notificationEnabled;
  }

  public Task notificationDay(Integer notificationDay) {
    this.notificationDay = notificationDay;
    return this;
  }

  /**
   * タスク通知日（1-31）
   * minimum: 1
   * maximum: 31
   * @return notificationDay
  */
  @Min(1) @Max(31) 
  @Schema(name = "notificationDay", description = "タスク通知日（1-31）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("notificationDay")
  public Integer getNotificationDay() {
    return notificationDay;
  }

  public void setNotificationDay(Integer notificationDay) {
    this.notificationDay = notificationDay;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Task task = (Task) o;
    return Objects.equals(this.taskId, task.taskId) &&
        Objects.equals(this.userId, task.userId) &&
        Objects.equals(this.taskName, task.taskName) &&
        Objects.equals(this.notificationCompleted, task.notificationCompleted) &&
        Objects.equals(this.notificationEnabled, task.notificationEnabled) &&
        Objects.equals(this.notificationDay, task.notificationDay);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskId, userId, taskName, notificationCompleted, notificationEnabled, notificationDay);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Task {\n");
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    taskName: ").append(toIndentedString(taskName)).append("\n");
    sb.append("    notificationCompleted: ").append(toIndentedString(notificationCompleted)).append("\n");
    sb.append("    notificationEnabled: ").append(toIndentedString(notificationEnabled)).append("\n");
    sb.append("    notificationDay: ").append(toIndentedString(notificationDay)).append("\n");
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

