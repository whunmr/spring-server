package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.AsynchronousnewinstanceresponseAttributes;
import io.swagger.model.Links;
import javax.validation.constraints.*;
/**
 * AsynchronousNewInstanceResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-05T13:54:25.717+08:00")

public class AsynchronousNewInstanceResponse   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("attributes")
  private AsynchronousnewinstanceresponseAttributes attributes = null;

  @JsonProperty("links")
  private Links links = null;

  public AsynchronousNewInstanceResponse id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AsynchronousNewInstanceResponse type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public AsynchronousNewInstanceResponse attributes(AsynchronousnewinstanceresponseAttributes attributes) {
    this.attributes = attributes;
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @ApiModelProperty(value = "")
  public AsynchronousnewinstanceresponseAttributes getAttributes() {
    return attributes;
  }

  public void setAttributes(AsynchronousnewinstanceresponseAttributes attributes) {
    this.attributes = attributes;
  }

  public AsynchronousNewInstanceResponse links(Links links) {
    this.links = links;
    return this;
  }

   /**
   * Get links
   * @return links
  **/
  @ApiModelProperty(value = "")
  public Links getLinks() {
    return links;
  }

  public void setLinks(Links links) {
    this.links = links;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AsynchronousNewInstanceResponse asynchronousNewInstanceResponse = (AsynchronousNewInstanceResponse) o;
    return Objects.equals(this.id, asynchronousNewInstanceResponse.id) &&
        Objects.equals(this.type, asynchronousNewInstanceResponse.type) &&
        Objects.equals(this.attributes, asynchronousNewInstanceResponse.attributes) &&
        Objects.equals(this.links, asynchronousNewInstanceResponse.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, attributes, links);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AsynchronousNewInstanceResponse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
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

