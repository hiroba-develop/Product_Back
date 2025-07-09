package com.example.Mietoru_Back.model;

import java.net.URI;
import java.util.Objects;
import com.example.Mietoru_Back.model.Profit;
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
 * ApiProfitUpdatePutRequest
 */

@JsonTypeName("_api_profit_update_put_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ApiProfitUpdatePutRequest {

  @Valid
  private List<@Valid Profit> profits = new ArrayList<>();

  public ApiProfitUpdatePutRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ApiProfitUpdatePutRequest(List<@Valid Profit> profits) {
    this.profits = profits;
  }

  public ApiProfitUpdatePutRequest profits(List<@Valid Profit> profits) {
    this.profits = profits;
    return this;
  }

  public ApiProfitUpdatePutRequest addProfitsItem(Profit profitsItem) {
    if (this.profits == null) {
      this.profits = new ArrayList<>();
    }
    this.profits.add(profitsItem);
    return this;
  }

  /**
   * Get profits
   * @return profits
  */
  @NotNull @Valid 
  @Schema(name = "profits", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("profits")
  public List<@Valid Profit> getProfits() {
    return profits;
  }

  public void setProfits(List<@Valid Profit> profits) {
    this.profits = profits;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiProfitUpdatePutRequest apiProfitUpdatePutRequest = (ApiProfitUpdatePutRequest) o;
    return Objects.equals(this.profits, apiProfitUpdatePutRequest.profits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(profits);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiProfitUpdatePutRequest {\n");
    sb.append("    profits: ").append(toIndentedString(profits)).append("\n");
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

