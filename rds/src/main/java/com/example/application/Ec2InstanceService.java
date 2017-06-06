package com.example.application;

import com.example.application.ec2.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class Ec2InstanceService {

    @Autowired
    private RestTemplate restTemplate;

    public Ec2Instance createInstance(String instanceClass) {
        InstanceCreateRequest createRequest = new InstanceCreateRequest()
                .data(new InstanceCreateRequestData()
                .attributes(new InstanceCreateRequestDataAttributes()
                        .plan(new InstanceCreateRequestDataAttributesPlan()
                                .flavorId(instanceClass))));

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type", "application/json");

        HttpEntity<InstanceCreateRequest> request = new HttpEntity<InstanceCreateRequest>(createRequest, headers);

        ResponseEntity<InstanceResponse> ec2Instance = restTemplate.postForEntity("http://ec2/instances", request, InstanceResponse.class);

        return ec2Instance.getBody().getData();
    }

}
