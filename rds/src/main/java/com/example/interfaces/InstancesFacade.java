package com.example.interfaces;

import com.example.application.InstanceService;
import com.example.application.SnapshotService;
import com.example.domain.Instance;
import com.example.domain.InstanceRepository;
import com.example.domain.Snapshot;
import com.example.interfaces.assembler.InstanceAssembler;
import com.example.interfaces.assembler.SnapshotAssembler;
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

    @Autowired
    private SnapshotService snapshotService;

    @Override
    public ResponseEntity<CreateDBInstanceResponse> createInstance(CreateDBInstanceRequest body) {
        return ResponseEntity.ok(instanceService.createInstance(body));
    }

    @Override
    public ResponseEntity<DBSnapshot> createSnapshot(String instanceId) {
        Snapshot snapshot = snapshotService.createSnapshotFor(instanceId);

        return new ResponseEntity<>(SnapshotAssembler.toDTO(snapshot), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DBInstance> findInstance(String instanceId) {
        Instance instance = instanceRepository.find(instanceId);
        if (instance == null) {
            return new ResponseEntity<>((DBInstance) null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(InstanceAssembler.toDTO(instance), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DBInstance>> findInstances() {
        List<Instance> allInstance = instanceRepository.findAll();
        return new ResponseEntity<>(InstanceAssembler.toDTOs(allInstance), HttpStatus.OK);
    }

}
