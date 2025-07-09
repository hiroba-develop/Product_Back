package com.example.Mietoru_Back.model;

import java.net.URI;
import java.util.Objects;
import com.example.Mietoru_Back.model.NetAsset;
import com.example.Mietoru_Back.model.Profit;
import com.example.Mietoru_Back.model.Sale;
import com.example.Mietoru_Back.model.Task;
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
 * ApiDashboardGet200Response
 */

@JsonTypeName("_api_dashboard_get_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ApiDashboardGet200Response {

  private Integer responseStatus;

  @Valid
  private List<@Valid Task> tasks;

  @Valid
  private List<@Valid Sale> sales;

  @Valid
  private List<@Valid Profit> profits;

  @Valid
  private List<@Valid NetAsset> netAssets;

  @Valid
  private List<@Valid TaxAccountantComment> taxAccountantComments;

  public ApiDashboardGet200Response responseStatus(Integer responseStatus) {
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

  public ApiDashboardGet200Response tasks(List<@Valid Task> tasks) {
    this.tasks = tasks;
    return this;
  }

  public ApiDashboardGet200Response addTasksItem(Task tasksItem) {
    if (this.tasks == null) {
      this.tasks = new ArrayList<>();
    }
    this.tasks.add(tasksItem);
    return this;
  }

  /**
   * Get tasks
   * @return tasks
  */
  @Valid 
  @Schema(name = "tasks", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tasks")
  public List<@Valid Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<@Valid Task> tasks) {
    this.tasks = tasks;
  }

  public ApiDashboardGet200Response sales(List<@Valid Sale> sales) {
    this.sales = sales;
    return this;
  }

  public ApiDashboardGet200Response addSalesItem(Sale salesItem) {
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

  public ApiDashboardGet200Response profits(List<@Valid Profit> profits) {
    this.profits = profits;
    return this;
  }

  public ApiDashboardGet200Response addProfitsItem(Profit profitsItem) {
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

  public ApiDashboardGet200Response netAssets(List<@Valid NetAsset> netAssets) {
    this.netAssets = netAssets;
    return this;
  }

  public ApiDashboardGet200Response addNetAssetsItem(NetAsset netAssetsItem) {
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

  public ApiDashboardGet200Response taxAccountantComments(List<@Valid TaxAccountantComment> taxAccountantComments) {
    this.taxAccountantComments = taxAccountantComments;
    return this;
  }

  public ApiDashboardGet200Response addTaxAccountantCommentsItem(TaxAccountantComment taxAccountantCommentsItem) {
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
    ApiDashboardGet200Response apiDashboardGet200Response = (ApiDashboardGet200Response) o;
    return Objects.equals(this.responseStatus, apiDashboardGet200Response.responseStatus) &&
        Objects.equals(this.tasks, apiDashboardGet200Response.tasks) &&
        Objects.equals(this.sales, apiDashboardGet200Response.sales) &&
        Objects.equals(this.profits, apiDashboardGet200Response.profits) &&
        Objects.equals(this.netAssets, apiDashboardGet200Response.netAssets) &&
        Objects.equals(this.taxAccountantComments, apiDashboardGet200Response.taxAccountantComments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseStatus, tasks, sales, profits, netAssets, taxAccountantComments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiDashboardGet200Response {\n");
    sb.append("    responseStatus: ").append(toIndentedString(responseStatus)).append("\n");
    sb.append("    tasks: ").append(toIndentedString(tasks)).append("\n");
    sb.append("    sales: ").append(toIndentedString(sales)).append("\n");
    sb.append("    profits: ").append(toIndentedString(profits)).append("\n");
    sb.append("    netAssets: ").append(toIndentedString(netAssets)).append("\n");
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

