package com.dddsample.rds.application.ec2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InstanceCreateRequest   {
    @JsonProperty("data")
    public InstanceCreateRequestData data = null;

    public static InstanceCreateRequest withFlavor(String flavorId) {
        InstanceCreateRequest instanceCreateRequest = new InstanceCreateRequest();
        instanceCreateRequest.data = new InstanceCreateRequestData();
        instanceCreateRequest.data.attributes = new InstanceCreateRequestDataAttributes();
        instanceCreateRequest.data.attributes.plan = new InstanceCreateRequestDataAttributesPlan();
        instanceCreateRequest.data.attributes.plan.flavorId = flavorId;

        return instanceCreateRequest;
    }
}

class InstanceCreateRequestData   {
    @JsonProperty("attributes")
    public InstanceCreateRequestDataAttributes attributes = null;
}

class InstanceCreateRequestDataAttributes   {
    @JsonProperty("plan")
    public InstanceCreateRequestDataAttributesPlan plan = null;
}

class InstanceCreateRequestDataAttributesPlan   {
    @JsonProperty("flavor_id")
    public String flavorId = null;
}

