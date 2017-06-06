package com.example.infrastructure.remote;

import com.example.application.Ec2InstanceService;
import com.example.application.ec2.Ec2Instance;
import com.example.application.ec2.InstanceCreateRequest;
import com.example.application.ec2.InstanceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URL;
import java.util.List;

@Component
public class Ec2InstanceServiceImpl implements Ec2InstanceService {

    @Autowired
    private RestTemplate restTemplate;


    @Value("${server.ec2.host}")
    private String ec2Host;

    public Ec2Instance createInstance(String instanceClass) {
        InstanceCreateRequest createRequest = InstanceCreateRequest.withFlavor(instanceClass);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<InstanceCreateRequest> request = new HttpEntity<InstanceCreateRequest>(createRequest, headers);


        ResponseEntity<InstanceResponse> rsp = restTemplate.postForEntity("http://"+ec2Host+"/instances", request, InstanceResponse.class);

        return rsp.getBody().getData();
    }
}
