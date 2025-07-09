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
 * ApiAuthRegistrationPostRequest
 */

@JsonTypeName("_api_auth_registration_post_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ApiAuthRegistrationPostRequest {

  private String email;

  private String passwordHash;

  private String googleId;

  public ApiAuthRegistrationPostRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ApiAuthRegistrationPostRequest(String email) {
    this.email = email;
  }

  public ApiAuthRegistrationPostRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * メールアドレス
   * @return email
  */
  @NotNull @jakarta.validation.constraints.Email 
  @Schema(name = "email", description = "メールアドレス", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ApiAuthRegistrationPostRequest passwordHash(String passwordHash) {
    this.passwordHash = passwordHash;
    return this;
  }

  /**
   * パスワードハッシュ（ローカル登録時のみ）
   * @return passwordHash
  */
  
  @Schema(name = "passwordHash", description = "パスワードハッシュ（ローカル登録時のみ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("passwordHash")
  public String getPasswordHash() {
    return passwordHash;
  }

  public void setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
  }

  public ApiAuthRegistrationPostRequest googleId(String googleId) {
    this.googleId = googleId;
    return this;
  }

  /**
   * Google ID（Google SSO登録時のみ）
   * @return googleId
  */
  
  @Schema(name = "googleId", description = "Google ID（Google SSO登録時のみ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("googleId")
  public String getGoogleId() {
    return googleId;
  }

  public void setGoogleId(String googleId) {
    this.googleId = googleId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiAuthRegistrationPostRequest apiAuthRegistrationPostRequest = (ApiAuthRegistrationPostRequest) o;
    return Objects.equals(this.email, apiAuthRegistrationPostRequest.email) &&
        Objects.equals(this.passwordHash, apiAuthRegistrationPostRequest.passwordHash) &&
        Objects.equals(this.googleId, apiAuthRegistrationPostRequest.googleId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, passwordHash, googleId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiAuthRegistrationPostRequest {\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    passwordHash: ").append(toIndentedString(passwordHash)).append("\n");
    sb.append("    googleId: ").append(toIndentedString(googleId)).append("\n");
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

