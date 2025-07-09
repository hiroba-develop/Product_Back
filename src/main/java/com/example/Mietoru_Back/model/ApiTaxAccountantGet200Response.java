package com.example.Mietoru_Back.model;

import java.net.URI;
import java.util.Objects;
import com.example.Mietoru_Back.model.AdminUserInfo;
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
 * ApiTaxAccountantGet200Response
 */

@JsonTypeName("_api_taxAccountant_get_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ApiTaxAccountantGet200Response {

  private Integer responseStatus;

  @Valid
  private List<@Valid AdminUserInfo> users;

  public ApiTaxAccountantGet200Response responseStatus(Integer responseStatus) {
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

  public ApiTaxAccountantGet200Response users(List<@Valid AdminUserInfo> users) {
    this.users = users;
    return this;
  }

  public ApiTaxAccountantGet200Response addUsersItem(AdminUserInfo usersItem) {
    if (this.users == null) {
      this.users = new ArrayList<>();
    }
    this.users.add(usersItem);
    return this;
  }

  /**
   * Get users
   * @return users
  */
  @Valid 
  @Schema(name = "users", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("users")
  public List<@Valid AdminUserInfo> getUsers() {
    return users;
  }

  public void setUsers(List<@Valid AdminUserInfo> users) {
    this.users = users;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiTaxAccountantGet200Response apiTaxAccountantGet200Response = (ApiTaxAccountantGet200Response) o;
    return Objects.equals(this.responseStatus, apiTaxAccountantGet200Response.responseStatus) &&
        Objects.equals(this.users, apiTaxAccountantGet200Response.users);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseStatus, users);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiTaxAccountantGet200Response {\n");
    sb.append("    responseStatus: ").append(toIndentedString(responseStatus)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
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

