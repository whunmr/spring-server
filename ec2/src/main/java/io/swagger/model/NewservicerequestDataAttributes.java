package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.NewservicerequestDataAttributesPlan;
import javax.validation.constraints.*;
/**
 * NewservicerequestDataAttributes
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-05T13:54:25.717+08:00")

public class NewservicerequestDataAttributes   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("plan")
  private NewservicerequestDataAttributesPlan plan = null;

  public NewservicerequestDataAttributes name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public NewservicerequestDataAttributes plan(NewservicerequestDataAttributesPlan plan) {
    this.plan = plan;
    return this;
  }

   /**
   * Get plan
   * @return plan
  **/
  @ApiModelProperty(value = "")
  public NewservicerequestDataAttributesPlan getPlan() {
    return plan;
  }

  public void setPlan(NewservicerequestDataAttributesPlan plan) {
    this.plan = plan;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewservicerequestDataAttributes newservicerequestDataAttributes = (NewservicerequestDataAttributes) o;
    return Objects.equals(this.name, newservicerequestDataAttributes.name) &&
        Objects.equals(this.plan, newservicerequestDataAttributes.plan);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, plan);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewservicerequestDataAttributes {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    plan: ").append(toIndentedString(plan)).append("\n");
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

