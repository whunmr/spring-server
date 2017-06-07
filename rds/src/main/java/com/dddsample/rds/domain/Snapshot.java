package com.dddsample.rds.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Snapshot {

    @Id
    private String snapshotId = null;
    private String instanceId = null;

    private String availableZone = null;

    public Snapshot() {
    }

    public Snapshot(String snapshotId, String instanceId, String availableZone) {
        this.snapshotId = snapshotId;
        this.instanceId = instanceId;
        this.availableZone = availableZone;
    }

    public String getSnapshotId() {
        return snapshotId;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public String getAvailableZone() {
        return availableZone;
    }
}
