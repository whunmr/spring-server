package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.AsynchronousnewinstanceresponseAttributesResults;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
/**
 * AsynchronousnewinstanceresponseAttributes
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-05T13:54:25.717+08:00")

public class AsynchronousnewinstanceresponseAttributes   {
  @JsonProperty("result")
  private String result = null;

  @JsonProperty("result_code")
  private Integer resultCode = null;

  @JsonProperty("result_description")
  private String resultDescription = null;

  @JsonProperty("results")
  private List<AsynchronousnewinstanceresponseAttributesResults> results = new ArrayList<AsynchronousnewinstanceresponseAttributesResults>();

  public AsynchronousnewinstanceresponseAttributes result(String result) {
    this.result = result;
    return this;
  }

   /**
   * Get result
   * @return result
  **/
  @ApiModelProperty(value = "")
  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public AsynchronousnewinstanceresponseAttributes resultCode(Integer resultCode) {
    this.resultCode = resultCode;
    return this;
  }

   /**
   * Get resultCode
   * @return resultCode
  **/
  @ApiModelProperty(value = "")
  public Integer getResultCode() {
    return resultCode;
  }

  public void setResultCode(Integer resultCode) {
    this.resultCode = resultCode;
  }

  public AsynchronousnewinstanceresponseAttributes resultDescription(String resultDescription) {
    this.resultDescription = resultDescription;
    return this;
  }

   /**
   * Get resultDescription
   * @return resultDescription
  **/
  @ApiModelProperty(value = "")
  public String getResultDescription() {
    return resultDescription;
  }

  public void setResultDescription(String resultDescription) {
    this.resultDescription = resultDescription;
  }

  public AsynchronousnewinstanceresponseAttributes results(List<AsynchronousnewinstanceresponseAttributesResults> results) {
    this.results = results;
    return this;
  }

  public AsynchronousnewinstanceresponseAttributes addResultsItem(AsynchronousnewinstanceresponseAttributesResults resultsItem) {
    this.results.add(resultsItem);
    return this;
  }

   /**
   * Get results
   * @return results
  **/
  @ApiModelProperty(value = "")
  public List<AsynchronousnewinstanceresponseAttributesResults> getResults() {
    return results;
  }

  public void setResults(List<AsynchronousnewinstanceresponseAttributesResults> results) {
    this.results = results;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AsynchronousnewinstanceresponseAttributes asynchronousnewinstanceresponseAttributes = (AsynchronousnewinstanceresponseAttributes) o;
    return Objects.equals(this.result, asynchronousnewinstanceresponseAttributes.result) &&
        Objects.equals(this.resultCode, asynchronousnewinstanceresponseAttributes.resultCode) &&
        Objects.equals(this.resultDescription, asynchronousnewinstanceresponseAttributes.resultDescription) &&
        Objects.equals(this.results, asynchronousnewinstanceresponseAttributes.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, resultCode, resultDescription, results);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AsynchronousnewinstanceresponseAttributes {\n");
    
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
    sb.append("    resultDescription: ").append(toIndentedString(resultDescription)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
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

