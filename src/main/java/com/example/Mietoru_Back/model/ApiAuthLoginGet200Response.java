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
 * ApiAuthLoginGet200Response
 */

@JsonTypeName("_api_auth_login_get_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ApiAuthLoginGet200Response {

  private Integer responseStatus;

  private String userId;

  private String settingFlg;

  private String role;

  public ApiAuthLoginGet200Response responseStatus(Integer responseStatus) {
    this.responseStatus = responseStatus;
    return this;
  }

  /**
   * レスポンスステータス（1:成功、0:失敗）
   * @return responseStatus
  */
  
  @Schema(name = "responseStatus", example = "1", description = "レスポンスステータス（1:成功、0:失敗）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("responseStatus")
  public Integer getResponseStatus() {
    return responseStatus;
  }

  public void setResponseStatus(Integer responseStatus) {
    this.responseStatus = responseStatus;
  }

  public ApiAuthLoginGet200Response userId(String userId) {
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

  public ApiAuthLoginGet200Response settingFlg(String settingFlg) {
    this.settingFlg = settingFlg;
    return this;
  }

  /**
   * 設定フラグ（1:設定済み、0:未設定）
   * @return settingFlg
  */
  
  @Schema(name = "settingFlg", example = "1", description = "設定フラグ（1:設定済み、0:未設定）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("settingFlg")
  public String getSettingFlg() {
    return settingFlg;
  }

  public void setSettingFlg(String settingFlg) {
    this.settingFlg = settingFlg;
  }

  public ApiAuthLoginGet200Response role(String role) {
    this.role = role;
    return this;
  }

  /**
   * ロール（1:管理者、0:ユーザー）
   * @return role
  */
  
  @Schema(name = "role", example = "1", description = "ロール（1:管理者、0:ユーザー）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("role")
  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiAuthLoginGet200Response apiAuthLoginGet200Response = (ApiAuthLoginGet200Response) o;
    return Objects.equals(this.responseStatus, apiAuthLoginGet200Response.responseStatus) &&
        Objects.equals(this.userId, apiAuthLoginGet200Response.userId) &&
        Objects.equals(this.settingFlg, apiAuthLoginGet200Response.settingFlg) &&
        Objects.equals(this.role, apiAuthLoginGet200Response.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseStatus, userId, settingFlg, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiAuthLoginGet200Response {\n");
    sb.append("    responseStatus: ").append(toIndentedString(responseStatus)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    settingFlg: ").append(toIndentedString(settingFlg)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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

