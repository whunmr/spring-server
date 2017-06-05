package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
/**
 * InstanceAttributes
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-05T13:54:25.717+08:00")

public class InstanceAttributes   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("alias")
  private String alias = null;

  @JsonProperty("image_id")
  private String imageId = null;

  @JsonProperty("region_id")
  private String regionId = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("flavor_id")
  private String flavorId = null;

  public InstanceAttributes name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public InstanceAttributes alias(String alias) {
    this.alias = alias;
    return this;
  }

   /**
   * Get alias
   * @return alias
  **/
  @ApiModelProperty(value = "")
  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public InstanceAttributes imageId(String imageId) {
    this.imageId = imageId;
    return this;
  }

   /**
   * Get imageId
   * @return imageId
  **/
  @ApiModelProperty(value = "")
  public String getImageId() {
    return imageId;
  }

  public void setImageId(String imageId) {
    this.imageId = imageId;
  }

  public InstanceAttributes regionId(String regionId) {
    this.regionId = regionId;
    return this;
  }

   /**
   * Get regionId
   * @return regionId
  **/
  @ApiModelProperty(value = "")
  public String getRegionId() {
    return regionId;
  }

  public void setRegionId(String regionId) {
    this.regionId = regionId;
  }

  public InstanceAttributes status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public InstanceAttributes flavorId(String flavorId) {
    this.flavorId = flavorId;
    return this;
  }

   /**
   * Get flavorId
   * @return flavorId
  **/
  @ApiModelProperty(value = "")
  public String getFlavorId() {
    return flavorId;
  }

  public void setFlavorId(String flavorId) {
    this.flavorId = flavorId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstanceAttributes instanceAttributes = (InstanceAttributes) o;
    return Objects.equals(this.name, instanceAttributes.name) &&
        Objects.equals(this.alias, instanceAttributes.alias) &&
        Objects.equals(this.imageId, instanceAttributes.imageId) &&
        Objects.equals(this.regionId, instanceAttributes.regionId) &&
        Objects.equals(this.status, instanceAttributes.status) &&
        Objects.equals(this.flavorId, instanceAttributes.flavorId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, alias, imageId, regionId, status, flavorId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InstanceAttributes {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    alias: ").append(toIndentedString(alias)).append("\n");
    sb.append("    imageId: ").append(toIndentedString(imageId)).append("\n");
    sb.append("    regionId: ").append(toIndentedString(regionId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    flavorId: ").append(toIndentedString(flavorId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

