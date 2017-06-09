package com.dddsample.rds.application.ec2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ec2Instance {
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("id")
    private String id = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("attributes")
    private InstanceAttributes attributes = null;

    public String getId() {
        return id;
    }

    public String getStatus() {
        if (attributes == null) {
            return null;
        }

        return attributes.status;
    }

    public String getFlavorId() {
        if (attributes == null) {
            return null;
        }

        return attributes.flavorId;
    }
}

class InstanceAttributes   {
    @JsonProperty("region_id")
    public String regionId = null;


    @JsonProperty("status")
    public String status = null;

    @JsonProperty("flavor_id")
    public String flavorId = null;
}
