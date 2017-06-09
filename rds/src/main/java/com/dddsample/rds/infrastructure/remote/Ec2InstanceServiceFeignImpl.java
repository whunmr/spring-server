package com.dddsample.rds.infrastructure.remote;

import com.dddsample.rds.application.Ec2InstanceService;
import com.dddsample.rds.application.ec2.Ec2Instance;
import com.dddsample.rds.application.ec2.InstanceCreateRequest;
import com.dddsample.rds.application.ec2.InstanceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
public class Ec2InstanceServiceFeignImpl implements Ec2InstanceService {
    @Autowired
    Ec2Client ec2client;

    @Override
    public Ec2Instance createInstance(String instanceClass) {
        InstanceCreateRequest createRequest = InstanceCreateRequest.withFlavor(instanceClass);

        Ec2Instance ec2Instance = ec2client.createEc2Instance(createRequest).getData();

        return ec2Instance;
    }
}

@FeignClient("EC2")
interface Ec2Client {
    @RequestMapping(method = RequestMethod.POST, value = "/instances"
                   , consumes = "application/json", produces="application/json")
    InstanceResponse createEc2Instance(@RequestBody InstanceCreateRequest request);
}

