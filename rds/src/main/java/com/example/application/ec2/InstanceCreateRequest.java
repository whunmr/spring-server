package com.example.application.ec2;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
/**
 * InstanceCreateRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-06T11:44:45.355+08:00")

public class InstanceCreateRequest   {
    @JsonProperty("data")
    private InstanceCreateRequestData data = null;

    public InstanceCreateRequest data(InstanceCreateRequestData data) {
        this.data = data;
        return this;
    }

    /**
     * Get data
     * @return data
     **/
    @ApiModelProperty(value = "")
    public InstanceCreateRequestData getData() {
        return data;
    }

    public void setData(InstanceCreateRequestData data) {
        this.data = data;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InstanceCreateRequest instanceCreateRequest = (InstanceCreateRequest) o;
        return Objects.equals(this.data, instanceCreateRequest.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InstanceCreateRequest {\n");

        sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

