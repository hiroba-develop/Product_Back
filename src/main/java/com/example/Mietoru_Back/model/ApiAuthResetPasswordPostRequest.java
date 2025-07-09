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
 * ApiAuthResetPasswordPostRequest
 */

@JsonTypeName("_api_auth_resetPassword_post_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ApiAuthResetPasswordPostRequest {

  private String token;

  private String newPasswordHash;

  public ApiAuthResetPasswordPostRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ApiAuthResetPasswordPostRequest(String token, String newPasswordHash) {
    this.token = token;
    this.newPasswordHash = newPasswordHash;
  }

  public ApiAuthResetPasswordPostRequest token(String token) {
    this.token = token;
    return this;
  }

  /**
   * トークン
   * @return token
  */
  @NotNull 
  @Schema(name = "token", description = "トークン", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("token")
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public ApiAuthResetPasswordPostRequest newPasswordHash(String newPasswordHash) {
    this.newPasswordHash = newPasswordHash;
    return this;
  }

  /**
   * 新しいパスワードハッシュ
   * @return newPasswordHash
  */
  @NotNull 
  @Schema(name = "newPasswordHash", description = "新しいパスワードハッシュ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("newPasswordHash")
  public String getNewPasswordHash() {
    return newPasswordHash;
  }

  public void setNewPasswordHash(String newPasswordHash) {
    this.newPasswordHash = newPasswordHash;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiAuthResetPasswordPostRequest apiAuthResetPasswordPostRequest = (ApiAuthResetPasswordPostRequest) o;
    return Objects.equals(this.token, apiAuthResetPasswordPostRequest.token) &&
        Objects.equals(this.newPasswordHash, apiAuthResetPasswordPostRequest.newPasswordHash);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, newPasswordHash);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiAuthResetPasswordPostRequest {\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    newPasswordHash: ").append(toIndentedString(newPasswordHash)).append("\n");
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

