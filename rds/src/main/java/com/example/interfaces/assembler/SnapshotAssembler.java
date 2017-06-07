package com.example.interfaces.assembler;

import com.example.domain.Snapshot;
import io.swagger.model.DBSnapshot;

public class SnapshotAssembler {
    public static DBSnapshot toDTO(Snapshot snapshot) {
        return new DBSnapshot().snapshotId(snapshot.getSnapshotId())
                               .instanceId(snapshot.getInstanceId());
    }
}
