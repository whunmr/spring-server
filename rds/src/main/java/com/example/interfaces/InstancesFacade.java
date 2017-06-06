package com.example.interfaces;

import io.swagger.api.InstancesApiDelegate;
import io.swagger.model.CreateDBInstanceRequest;
import io.swagger.model.CreateDBInstanceResponse;
import io.swagger.model.DBInstance;
import io.swagger.model.FindDBInstancesRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InstancesFacade implements InstancesApiDelegate {
    @Override
    public ResponseEntity<CreateDBInstanceResponse> addInstance(CreateDBInstanceRequest body) {
        return null;
    }

    @Override
    public ResponseEntity<List<DBInstance>> findInstances(FindDBInstancesRequest body) {
        return null;
    }
}
