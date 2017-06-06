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
 * InstanceCreateRequestDataAttributesPlan
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-06T11:44:45.355+08:00")

public class InstanceCreateRequestDataAttributesPlan   {
    @JsonProperty("alias")
    private String alias = null;

    @JsonProperty("flavor_id")
    private String flavorId = null;

    @JsonProperty("image_id")
    private String imageId = null;

    @JsonProperty("az")
    private String az = null;

    public InstanceCreateRequestDataAttributesPlan alias(String alias) {
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

    public InstanceCreateRequestDataAttributesPlan flavorId(String flavorId) {
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

    public InstanceCreateRequestDataAttributesPlan imageId(String imageId) {
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

    public InstanceCreateRequestDataAttributesPlan az(String az) {
        this.az = az;
        return this;
    }

    /**
     * Get az
     * @return az
     **/
    @ApiModelProperty(value = "")
    public String getAz() {
        return az;
    }

    public void setAz(String az) {
        this.az = az;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InstanceCreateRequestDataAttributesPlan instanceCreateRequestDataAttributesPlan = (InstanceCreateRequestDataAttributesPlan) o;
        return Objects.equals(this.alias, instanceCreateRequestDataAttributesPlan.alias) &&
                Objects.equals(this.flavorId, instanceCreateRequestDataAttributesPlan.flavorId) &&
                Objects.equals(this.imageId, instanceCreateRequestDataAttributesPlan.imageId) &&
                Objects.equals(this.az, instanceCreateRequestDataAttributesPlan.az);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alias, flavorId, imageId, az);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InstanceCreateRequestDataAttributesPlan {\n");

        sb.append("    alias: ").append(toIndentedString(alias)).append("\n");
        sb.append("    flavorId: ").append(toIndentedString(flavorId)).append("\n");
        sb.append("    imageId: ").append(toIndentedString(imageId)).append("\n");
        sb.append("    az: ").append(toIndentedString(az)).append("\n");
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

