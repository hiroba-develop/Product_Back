package com.example.Mietoru_Back.model;

import java.net.URI;
import java.util.Objects;
import com.example.Mietoru_Back.model.TaxAccountantComment;
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
 * ApiTaxAccountantCommentRegistrationPost200Response
 */

@JsonTypeName("_api_taxAccountantComment_registration_post_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ApiTaxAccountantCommentRegistrationPost200Response {

  private Integer responseStatus;

  @Valid
  private List<@Valid TaxAccountantComment> taxAccountantComments;

  public ApiTaxAccountantCommentRegistrationPost200Response responseStatus(Integer responseStatus) {
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

  public ApiTaxAccountantCommentRegistrationPost200Response taxAccountantComments(List<@Valid TaxAccountantComment> taxAccountantComments) {
    this.taxAccountantComments = taxAccountantComments;
    return this;
  }

  public ApiTaxAccountantCommentRegistrationPost200Response addTaxAccountantCommentsItem(TaxAccountantComment taxAccountantCommentsItem) {
    if (this.taxAccountantComments == null) {
      this.taxAccountantComments = new ArrayList<>();
    }
    this.taxAccountantComments.add(taxAccountantCommentsItem);
    return this;
  }

  /**
   * Get taxAccountantComments
   * @return taxAccountantComments
  */
  @Valid 
  @Schema(name = "taxAccountantComments", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("taxAccountantComments")
  public List<@Valid TaxAccountantComment> getTaxAccountantComments() {
    return taxAccountantComments;
  }

  public void setTaxAccountantComments(List<@Valid TaxAccountantComment> taxAccountantComments) {
    this.taxAccountantComments = taxAccountantComments;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiTaxAccountantCommentRegistrationPost200Response apiTaxAccountantCommentRegistrationPost200Response = (ApiTaxAccountantCommentRegistrationPost200Response) o;
    return Objects.equals(this.responseStatus, apiTaxAccountantCommentRegistrationPost200Response.responseStatus) &&
        Objects.equals(this.taxAccountantComments, apiTaxAccountantCommentRegistrationPost200Response.taxAccountantComments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseStatus, taxAccountantComments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiTaxAccountantCommentRegistrationPost200Response {\n");
    sb.append("    responseStatus: ").append(toIndentedString(responseStatus)).append("\n");
    sb.append("    taxAccountantComments: ").append(toIndentedString(taxAccountantComments)).append("\n");
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

