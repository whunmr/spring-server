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
 * InstanceCreateRequestDataAttributes
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-06T11:44:45.355+08:00")

public class InstanceCreateRequestDataAttributes   {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("plan")
    private InstanceCreateRequestDataAttributesPlan plan = null;

    public InstanceCreateRequestDataAttributes name(String name) {
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

    public InstanceCreateRequestDataAttributes plan(InstanceCreateRequestDataAttributesPlan plan) {
        this.plan = plan;
        return this;
    }

    /**
     * Get plan
     * @return plan
     **/
    @ApiModelProperty(value = "")
    public InstanceCreateRequestDataAttributesPlan getPlan() {
        return plan;
    }

    public void setPlan(InstanceCreateRequestDataAttributesPlan plan) {
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
        InstanceCreateRequestDataAttributes instanceCreateRequestDataAttributes = (InstanceCreateRequestDataAttributes) o;
        return Objects.equals(this.name, instanceCreateRequestDataAttributes.name) &&
                Objects.equals(this.plan, instanceCreateRequestDataAttributes.plan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, plan);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InstanceCreateRequestDataAttributes {\n");

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

