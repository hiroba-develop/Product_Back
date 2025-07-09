package com.example.Mietoru_Back.model;

import java.net.URI;
import java.util.Objects;
import com.example.Mietoru_Back.model.NetAsset;
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
 * ApiNetAssetUpdatePut200Response
 */

@JsonTypeName("_api_netAsset_update_put_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ApiNetAssetUpdatePut200Response {

  private Integer responseStatus;

  @Valid
  private List<@Valid NetAsset> netAssets;

  public ApiNetAssetUpdatePut200Response responseStatus(Integer responseStatus) {
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

  public ApiNetAssetUpdatePut200Response netAssets(List<@Valid NetAsset> netAssets) {
    this.netAssets = netAssets;
    return this;
  }

  public ApiNetAssetUpdatePut200Response addNetAssetsItem(NetAsset netAssetsItem) {
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
    ApiNetAssetUpdatePut200Response apiNetAssetUpdatePut200Response = (ApiNetAssetUpdatePut200Response) o;
    return Objects.equals(this.responseStatus, apiNetAssetUpdatePut200Response.responseStatus) &&
        Objects.equals(this.netAssets, apiNetAssetUpdatePut200Response.netAssets);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseStatus, netAssets);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiNetAssetUpdatePut200Response {\n");
    sb.append("    responseStatus: ").append(toIndentedString(responseStatus)).append("\n");
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

