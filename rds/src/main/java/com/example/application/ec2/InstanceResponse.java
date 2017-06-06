package com.example.application.ec2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InstanceResponse   {
    public Ec2Instance getData() {
        return data;
    }

    @JsonProperty("data")
    public Ec2Instance data = null;
}

