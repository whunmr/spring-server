package com.example.application.ec2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ec2Instance {
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
        return attributes.status;
    }

    public String getFlavorId() {
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
