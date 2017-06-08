package com.dddsample.rds.interfaces;

import com.dddsample.rds.application.InstanceService;
import com.dddsample.rds.application.SnapshotService;
import com.dddsample.rds.domain.Instance;
import com.dddsample.rds.domain.InstanceRepository;
import com.dddsample.rds.domain.Snapshot;
import com.dddsample.rds.interfaces.assembler.InstanceAssembler;
import com.dddsample.rds.interfaces.assembler.SnapshotAssembler;
import io.swagger.api.InstancesApiDelegate;
import io.swagger.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InstancesFacade implements InstancesApiDelegate {

    @Autowired
    private InstanceService instanceService;

    @Autowired
    private InstanceRepository instanceRepository;

    @Override
    public ResponseEntity<CreateDBInstanceResponse> createInstance(CreateDBInstanceRequest body) {
        Instance instance = instanceService.createInstance(body);
        if (instance == null) {
            return ResponseEntity.badRequest().body(null);
        }

        DBInstance dbInstance = InstanceAssembler.toDTO(instance);
        return ResponseEntity.ok(new CreateDBInstanceResponse().instance(dbInstance));
    }

    @Override
    public ResponseEntity<DBInstance> findInstance(String instanceId) {
        Instance instance = instanceRepository.find(instanceId);
        if (instance == null) {
            return new ResponseEntity<>((DBInstance) null, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(InstanceAssembler.toDTO(instance));
    }

    @Override
    public ResponseEntity<List<DBInstance>> findInstances() {
        List<Instance> allInstance = instanceRepository.findAll();
        return new ResponseEntity<>(InstanceAssembler.toDTOs(allInstance), HttpStatus.OK);
    }



    @Autowired
    private SnapshotService snapshotService;

    @Override
    public ResponseEntity<DBSnapshot> createSnapshot(String instanceId) {
        Snapshot snapshot = snapshotService.createSnapshotFor(instanceId);

        return new ResponseEntity<>(SnapshotAssembler.toDTO(snapshot), HttpStatus.OK);
    }

}
