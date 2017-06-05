package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
/**
 * ErrorSource
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-05T13:54:25.717+08:00")

public class ErrorSource   {
  @JsonProperty("pointer")
  private String pointer = null;

  @JsonProperty("parameter")
  private String parameter = null;

  public ErrorSource pointer(String pointer) {
    this.pointer = pointer;
    return this;
  }

   /**
   * A JSON Pointer[RFC6901] to associated entity in the request document. [e.g. /data for data object, /data/attributes/title for specific attribute
   * @return pointer
  **/
  @ApiModelProperty(value = "A JSON Pointer[RFC6901] to associated entity in the request document. [e.g. /data for data object, /data/attributes/title for specific attribute")
  public String getPointer() {
    return pointer;
  }

  public void setPointer(String pointer) {
    this.pointer = pointer;
  }

  public ErrorSource parameter(String parameter) {
    this.parameter = parameter;
    return this;
  }

   /**
   * A string indicating which query parameter caused error
   * @return parameter
  **/
  @ApiModelProperty(value = "A string indicating which query parameter caused error")
  public String getParameter() {
    return parameter;
  }

  public void setParameter(String parameter) {
    this.parameter = parameter;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorSource errorSource = (ErrorSource) o;
    return Objects.equals(this.pointer, errorSource.pointer) &&
        Objects.equals(this.parameter, errorSource.parameter);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pointer, parameter);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorSource {\n");
    
    sb.append("    pointer: ").append(toIndentedString(pointer)).append("\n");
    sb.append("    parameter: ").append(toIndentedString(parameter)).append("\n");
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

