package com.dddsample.rds.infrastructure.remote;

import com.dddsample.rds.application.ec2.Ec2Instance;
import com.dddsample.rds.application.ec2.InstanceCreateRequest;
import com.dddsample.rds.application.Ec2InstanceService;
import com.dddsample.rds.application.ec2.InstanceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class Ec2InstanceServiceImpl implements Ec2InstanceService {
    @Autowired
    private RestTemplate restTemplate;

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public Ec2Instance createInstance(String instanceClass) {
        InstanceCreateRequest createRequest = InstanceCreateRequest.withFlavor(instanceClass);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<InstanceCreateRequest> request
                = new HttpEntity<InstanceCreateRequest>(createRequest, headers);

        ResponseEntity<InstanceResponse> rsp = restTemplate
                .postForEntity("http://EC2/instances", request, InstanceResponse.class);

        return rsp.getBody().getData();
    }
}
