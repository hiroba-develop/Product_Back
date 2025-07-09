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
 * ApiTaskRegistrationPostRequest
 */

@JsonTypeName("_api_task_registration_post_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ApiTaskRegistrationPostRequest {

  @Valid
  private List<@Valid Task> tasks = new ArrayList<>();

  public ApiTaskRegistrationPostRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ApiTaskRegistrationPostRequest(List<@Valid Task> tasks) {
    this.tasks = tasks;
  }

  public ApiTaskRegistrationPostRequest tasks(List<@Valid Task> tasks) {
    this.tasks = tasks;
    return this;
  }

  public ApiTaskRegistrationPostRequest addTasksItem(Task tasksItem) {
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
  @NotNull @Valid 
  @Schema(name = "tasks", requiredMode = Schema.RequiredMode.REQUIRED)
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
    ApiTaskRegistrationPostRequest apiTaskRegistrationPostRequest = (ApiTaskRegistrationPostRequest) o;
    return Objects.equals(this.tasks, apiTaskRegistrationPostRequest.tasks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tasks);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiTaskRegistrationPostRequest {\n");
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

