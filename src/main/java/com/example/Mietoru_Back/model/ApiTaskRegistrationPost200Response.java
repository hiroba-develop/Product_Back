package com.example.Mietoru_Back.model;

import java.net.URI;
import java.util.Objects;
import com.example.Mietoru_Back.model.Task;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ApiTaskRegistrationPost200Response
 */

@JsonTypeName("_api_task_registration_post_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ApiTaskRegistrationPost200Response {

  private Integer responseStatus;

  @Valid
  private List<@Valid Task> tasks;

  public ApiTaskRegistrationPost200Response responseStatus(Integer responseStatus) {
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

  public ApiTaskRegistrationPost200Response tasks(List<@Valid Task> tasks) {
    this.tasks = tasks;
    return this;
  }

  public ApiTaskRegistrationPost200Response addTasksItem(Task tasksItem) {
    if (this.tasks == null) {
      this.tasks = new ArrayList<>();
    }
    this.tasks.add(tasksItem);
    return this;
  }

  /**
   * Get tasks
   * @return tasks
  */
  @Valid 
  @Schema(name = "tasks", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tasks")
  public List<@Valid Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<@Valid Task> tasks) {
    this.tasks = tasks;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiTaskRegistrationPost200Response apiTaskRegistrationPost200Response = (ApiTaskRegistrationPost200Response) o;
    return Objects.equals(this.responseStatus, apiTaskRegistrationPost200Response.responseStatus) &&
        Objects.equals(this.tasks, apiTaskRegistrationPost200Response.tasks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseStatus, tasks);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiTaskRegistrationPost200Response {\n");
    sb.append("    responseStatus: ").append(toIndentedString(responseStatus)).append("\n");
    sb.append("    tasks: ").append(toIndentedString(tasks)).append("\n");
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

