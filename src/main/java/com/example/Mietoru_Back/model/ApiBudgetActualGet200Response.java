package com.example.Mietoru_Back.model;

import java.net.URI;
import java.util.Objects;
import com.example.Mietoru_Back.model.NetAsset;
import com.example.Mietoru_Back.model.Profit;
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
 * ApiBudgetActualGet200Response
 */

@JsonTypeName("_api_budgetActual_get_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ApiBudgetActualGet200Response {

  private Integer responseStatus;

  @Valid
  private List<@Valid Sale> sales;

  @Valid
  private List<@Valid Profit> profits;

  @Valid
  private List<@Valid NetAsset> netAssets;

  public ApiBudgetActualGet200Response responseStatus(Integer responseStatus) {
    this.responseStatus = responseStatus;
    return this;
  }

  /**
   * Get responseStatus
   * @return responseStatus
  */
  
  @Schema(name = "responseStatus", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("responseStatus")
  public Integer getResponseStatus() {
    return responseStatus;
  }

  public void setResponseStatus(Integer responseStatus) {
    this.responseStatus = responseStatus;
  }

  public ApiBudgetActualGet200Response sales(List<@Valid Sale> sales) {
    this.sales = sales;
    return this;
  }

  public ApiBudgetActualGet200Response addSalesItem(Sale salesItem) {
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

  public ApiBudgetActualGet200Response profits(List<@Valid Profit> profits) {
    this.profits = profits;
    return this;
  }

  public ApiBudgetActualGet200Response addProfitsItem(Profit profitsItem) {
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

  public ApiBudgetActualGet200Response netAssets(List<@Valid NetAsset> netAssets) {
    this.netAssets = netAssets;
    return this;
  }

  public ApiBudgetActualGet200Response addNetAssetsItem(NetAsset netAssetsItem) {
    if (this.netAssets == null) {
      this.netAssets = new ArrayList<>();
    }
    this.netAssets.add(netAssetsItem);
    return this;
  }

  /**
   * Get netAssets
   * @return netAssets
  */
  @Valid 
  @Schema(name = "netAssets", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("netAssets")
  public List<@Valid NetAsset> getNetAssets() {
    return netAssets;
  }

  public void setNetAssets(List<@Valid NetAsset> netAssets) {
    this.netAssets = netAssets;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiBudgetActualGet200Response apiBudgetActualGet200Response = (ApiBudgetActualGet200Response) o;
    return Objects.equals(this.responseStatus, apiBudgetActualGet200Response.responseStatus) &&
        Objects.equals(this.sales, apiBudgetActualGet200Response.sales) &&
        Objects.equals(this.profits, apiBudgetActualGet200Response.profits) &&
        Objects.equals(this.netAssets, apiBudgetActualGet200Response.netAssets);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseStatus, sales, profits, netAssets);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiBudgetActualGet200Response {\n");
    sb.append("    responseStatus: ").append(toIndentedString(responseStatus)).append("\n");
    sb.append("    sales: ").append(toIndentedString(sales)).append("\n");
    sb.append("    profits: ").append(toIndentedString(profits)).append("\n");
    sb.append("    netAssets: ").append(toIndentedString(netAssets)).append("\n");
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

