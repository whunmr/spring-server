package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.NewservicerequestDataAttributes;
import javax.validation.constraints.*;
/**
 * NewservicerequestData
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-05T13:54:25.717+08:00")

public class NewservicerequestData   {
  @JsonProperty("type")
  private String type = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("attributes")
  private NewservicerequestDataAttributes attributes = null;

  public NewservicerequestData type(String type) {
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

  public NewservicerequestData id(String id) {
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

  public NewservicerequestData attributes(NewservicerequestDataAttributes attributes) {
    this.attributes = attributes;
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @ApiModelProperty(value = "")
  public NewservicerequestDataAttributes getAttributes() {
    return attributes;
  }

  public void setAttributes(NewservicerequestDataAttributes attributes) {
    this.attributes = attributes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewservicerequestData newservicerequestData = (NewservicerequestData) o;
    return Objects.equals(this.type, newservicerequestData.type) &&
        Objects.equals(this.id, newservicerequestData.id) &&
        Objects.equals(this.attributes, newservicerequestData.attributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, id, attributes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewservicerequestData {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
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

