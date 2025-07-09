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
 * ApiTaxAccountantCommentRegistrationPostRequest
 */

@JsonTypeName("_api_taxAccountantComment_registration_post_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ApiTaxAccountantCommentRegistrationPostRequest {

  @Valid
  private List<@Valid TaxAccountantComment> taxAccountantComments = new ArrayList<>();

  public ApiTaxAccountantCommentRegistrationPostRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ApiTaxAccountantCommentRegistrationPostRequest(List<@Valid TaxAccountantComment> taxAccountantComments) {
    this.taxAccountantComments = taxAccountantComments;
  }

  public ApiTaxAccountantCommentRegistrationPostRequest taxAccountantComments(List<@Valid TaxAccountantComment> taxAccountantComments) {
    this.taxAccountantComments = taxAccountantComments;
    return this;
  }

  public ApiTaxAccountantCommentRegistrationPostRequest addTaxAccountantCommentsItem(TaxAccountantComment taxAccountantCommentsItem) {
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
  @NotNull @Valid 
  @Schema(name = "taxAccountantComments", requiredMode = Schema.RequiredMode.REQUIRED)
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
    ApiTaxAccountantCommentRegistrationPostRequest apiTaxAccountantCommentRegistrationPostRequest = (ApiTaxAccountantCommentRegistrationPostRequest) o;
    return Objects.equals(this.taxAccountantComments, apiTaxAccountantCommentRegistrationPostRequest.taxAccountantComments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taxAccountantComments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiTaxAccountantCommentRegistrationPostRequest {\n");
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

