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
 * ApiProfitUpdatePut200Response
 */

@JsonTypeName("_api_profit_update_put_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ApiProfitUpdatePut200Response {

  private Integer responseStatus;

  @Valid
  private List<@Valid Profit> profits;

  public ApiProfitUpdatePut200Response responseStatus(Integer responseStatus) {
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

  public ApiProfitUpdatePut200Response profits(List<@Valid Profit> profits) {
    this.profits = profits;
    return this;
  }

  public ApiProfitUpdatePut200Response addProfitsItem(Profit profitsItem) {
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
  @Valid 
  @Schema(name = "profits", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    ApiProfitUpdatePut200Response apiProfitUpdatePut200Response = (ApiProfitUpdatePut200Response) o;
    return Objects.equals(this.responseStatus, apiProfitUpdatePut200Response.responseStatus) &&
        Objects.equals(this.profits, apiProfitUpdatePut200Response.profits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseStatus, profits);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiProfitUpdatePut200Response {\n");
    sb.append("    responseStatus: ").append(toIndentedString(responseStatus)).append("\n");
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

