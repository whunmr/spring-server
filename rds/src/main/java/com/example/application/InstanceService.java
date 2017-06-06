package com.example.application;

import com.example.application.ec2.Ec2Instance;
import io.swagger.model.CreateDBInstanceRequest;
import io.swagger.model.CreateDBInstanceResponse;
import io.swagger.model.DBInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InstanceService {

    @Autowired
    Ec2InstanceService ec2InstanceService;

    public CreateDBInstanceResponse createInstance(CreateDBInstanceRequest request) {

        Ec2Instance instance = ec2InstanceService.createInstance(request.getInstanceClass());

        CreateDBInstanceResponse rsp = new CreateDBInstanceResponse();

        DBInstance dbInstance = new DBInstance().instanceId(instance.getId())
                                                .instanceClass(instance.getFlavorId())
                                                .engine(request.getEngine())
                                                .port(request.getPort() == 0 ? 3261 : request.getPort())
                                                .status(instance.getStatus());

        rsp.setInstance(dbInstance);
        return rsp;
    }
}
