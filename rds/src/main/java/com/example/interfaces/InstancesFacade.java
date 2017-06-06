package com.example.interfaces;

import com.example.application.InstanceService;
import io.swagger.api.InstancesApiDelegate;
import io.swagger.model.CreateDBInstanceRequest;
import io.swagger.model.CreateDBInstanceResponse;
import io.swagger.model.DBInstance;
import io.swagger.model.FindDBInstancesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InstancesFacade implements InstancesApiDelegate {

    @Autowired
    private InstanceService instanceService;

    @Override
    public ResponseEntity<CreateDBInstanceResponse> createInstance(CreateDBInstanceRequest body) {
        //TODO: 增加对参数的校验
        return ResponseEntity.ok(instanceService.createInstance(body));
    }

    @Override
    public ResponseEntity<List<DBInstance>> findInstances(FindDBInstancesRequest body) {
        return null;
    }


}
