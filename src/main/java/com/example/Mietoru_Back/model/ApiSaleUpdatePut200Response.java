package com.example.Mietoru_Back.model;

import java.net.URI;
import java.util.Objects;
import com.example.Mietoru_Back.model.Sale;
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
 * ApiSaleUpdatePut200Response
 */

@JsonTypeName("_api_sale_update_put_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ApiSaleUpdatePut200Response {

  private Integer responseStatus;

  @Valid
  private List<@Valid Sale> sales;

  public ApiSaleUpdatePut200Response responseStatus(Integer responseStatus) {
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

  public ApiSaleUpdatePut200Response sales(List<@Valid Sale> sales) {
    this.sales = sales;
    return this;
  }

  public ApiSaleUpdatePut200Response addSalesItem(Sale salesItem) {
    if (this.sales == null) {
      this.sales = new ArrayList<>();
    }
    this.sales.add(salesItem);
    return this;
  }

  /**
   * Get sales
   * @return sales
  */
  @Valid 
  @Schema(name = "sales", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sales")
  public List<@Valid Sale> getSales() {
    return sales;
  }

  public void setSales(List<@Valid Sale> sales) {
    this.sales = sales;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiSaleUpdatePut200Response apiSaleUpdatePut200Response = (ApiSaleUpdatePut200Response) o;
    return Objects.equals(this.responseStatus, apiSaleUpdatePut200Response.responseStatus) &&
        Objects.equals(this.sales, apiSaleUpdatePut200Response.sales);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseStatus, sales);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiSaleUpdatePut200Response {\n");
    sb.append("    responseStatus: ").append(toIndentedString(responseStatus)).append("\n");
    sb.append("    sales: ").append(toIndentedString(sales)).append("\n");
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

