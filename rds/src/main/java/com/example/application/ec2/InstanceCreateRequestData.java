package com.example.application.ec2;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
/**
 * InstanceCreateRequestData
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-06T11:44:45.355+08:00")

public class InstanceCreateRequestData   {
    @JsonProperty("type")
    private String type = null;

    @JsonProperty("id")
    private String id = null;

    @JsonProperty("attributes")
    private InstanceCreateRequestDataAttributes attributes = null;

    public InstanceCreateRequestData type(String type) {
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

    public InstanceCreateRequestData id(String id) {
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

    public InstanceCreateRequestData attributes(InstanceCreateRequestDataAttributes attributes) {
        this.attributes = attributes;
        return this;
    }

    /**
     * Get attributes
     * @return attributes
     **/
    @ApiModelProperty(value = "")
    public InstanceCreateRequestDataAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(InstanceCreateRequestDataAttributes attributes) {
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
        InstanceCreateRequestData instanceCreateRequestData = (InstanceCreateRequestData) o;
        return Objects.equals(this.type, instanceCreateRequestData.type) &&
                Objects.equals(this.id, instanceCreateRequestData.id) &&
                Objects.equals(this.attributes, instanceCreateRequestData.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, attributes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InstanceCreateRequestData {\n");

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

