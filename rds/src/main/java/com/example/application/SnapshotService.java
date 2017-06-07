package com.example.application;

import com.example.domain.InstanceRepository;
import com.example.domain.Snapshot;
import com.example.domain.SnapshotRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SnapshotService {
    @Autowired
    private SnapshotRepository snapshotRepository;

    public Snapshot createSnapshotFor(String instanceId) {
        Snapshot snapshot = createSnapshotByEBS(instanceId);
        snapshotRepository.save(snapshot);

        return snapshot;
    }

    @NotNull
    private Snapshot createSnapshotByEBS(String instanceId) {
        //call ebs service to create snapshot
        return new Snapshot(UUID.randomUUID().toString(), instanceId, "FAKE_AZ");
    }
}
