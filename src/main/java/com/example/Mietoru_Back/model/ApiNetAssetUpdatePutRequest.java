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
 * ApiNetAssetUpdatePutRequest
 */

@JsonTypeName("_api_netAsset_update_put_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ApiNetAssetUpdatePutRequest {

  @Valid
  private List<@Valid NetAsset> netAssets = new ArrayList<>();

  public ApiNetAssetUpdatePutRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ApiNetAssetUpdatePutRequest(List<@Valid NetAsset> netAssets) {
    this.netAssets = netAssets;
  }

  public ApiNetAssetUpdatePutRequest netAssets(List<@Valid NetAsset> netAssets) {
    this.netAssets = netAssets;
    return this;
  }

  public ApiNetAssetUpdatePutRequest addNetAssetsItem(NetAsset netAssetsItem) {
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
  @NotNull @Valid 
  @Schema(name = "netAssets", requiredMode = Schema.RequiredMode.REQUIRED)
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
    ApiNetAssetUpdatePutRequest apiNetAssetUpdatePutRequest = (ApiNetAssetUpdatePutRequest) o;
    return Objects.equals(this.netAssets, apiNetAssetUpdatePutRequest.netAssets);
  }

  @Override
  public int hashCode() {
    return Objects.hash(netAssets);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiNetAssetUpdatePutRequest {\n");
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

