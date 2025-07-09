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
 * ApiSaleUpdatePutRequest
 */

@JsonTypeName("_api_sale_update_put_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ApiSaleUpdatePutRequest {

  @Valid
  private List<@Valid Sale> sales = new ArrayList<>();

  public ApiSaleUpdatePutRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ApiSaleUpdatePutRequest(List<@Valid Sale> sales) {
    this.sales = sales;
  }

  public ApiSaleUpdatePutRequest sales(List<@Valid Sale> sales) {
    this.sales = sales;
    return this;
  }

  public ApiSaleUpdatePutRequest addSalesItem(Sale salesItem) {
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
  @NotNull @Valid 
  @Schema(name = "sales", requiredMode = Schema.RequiredMode.REQUIRED)
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
    ApiSaleUpdatePutRequest apiSaleUpdatePutRequest = (ApiSaleUpdatePutRequest) o;
    return Objects.equals(this.sales, apiSaleUpdatePutRequest.sales);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sales);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiSaleUpdatePutRequest {\n");
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

