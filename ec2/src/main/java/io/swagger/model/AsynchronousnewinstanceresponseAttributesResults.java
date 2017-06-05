package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
/**
 * AsynchronousnewinstanceresponseAttributesResults
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-05T13:54:25.717+08:00")

public class AsynchronousnewinstanceresponseAttributesResults   {
  @JsonProperty("job_id")
  private String jobId = null;

  @JsonProperty("instance_id")
  private String instanceId = null;

  public AsynchronousnewinstanceresponseAttributesResults jobId(String jobId) {
    this.jobId = jobId;
    return this;
  }

   /**
   * Get jobId
   * @return jobId
  **/
  @ApiModelProperty(value = "")
  public String getJobId() {
    return jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

  public AsynchronousnewinstanceresponseAttributesResults instanceId(String instanceId) {
    this.instanceId = instanceId;
    return this;
  }

   /**
   * Get instanceId
   * @return instanceId
  **/
  @ApiModelProperty(value = "")
  public String getInstanceId() {
    return instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AsynchronousnewinstanceresponseAttributesResults asynchronousnewinstanceresponseAttributesResults = (AsynchronousnewinstanceresponseAttributesResults) o;
    return Objects.equals(this.jobId, asynchronousnewinstanceresponseAttributesResults.jobId) &&
        Objects.equals(this.instanceId, asynchronousnewinstanceresponseAttributesResults.instanceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobId, instanceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AsynchronousnewinstanceresponseAttributesResults {\n");
    
    sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
    sb.append("    instanceId: ").append(toIndentedString(instanceId)).append("\n");
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

