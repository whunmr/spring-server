package com.dddsample.ec2.domain.instance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by azhu on 25/05/2017.
 */
@Entity
public class Instance {

    public String getInstanceId() {
        return instanceId;
    }

    @Id
    private String instanceId;

    private String flavorId;
    private String az;

    @Column(name = "STATUS")
    private Status status = Status.Created;

    public enum Status {
        Created {
            @Override
            public boolean moveTo(Status nextStatus) {
                if (nextStatus == Status.Pending) {
                    return true;
                }
                return false;
            }
        },
        Pending {
            @Override
            public boolean moveTo(Status nextStatus) {
                if (nextStatus == Status.Running) {
                    return true;
                }
                return false;

            }
        },
        Running {
            @Override
            public boolean moveTo(Status nextStatus) {
                if (nextStatus == Status.Rebooting) {
                    return true;
                }
                if (nextStatus == Status.ShuttingDown) {
                    return true;
                }
                return false;
            }
        },
        ShuttingDown {
            @Override
            public boolean moveTo(Status nextStatus) {
                if (nextStatus == Status.Terminated) {
                    return true;
                }
                return false;
            }
        },
        Rebooting {
            @Override
            public boolean moveTo(Status nextStatus) {
                if (nextStatus == Status.Running) {
                    return true;
                }
                return false;
            }
        },
        Terminated {
            @Override
            public boolean moveTo(Status nextStatus) {
                return false;
            }
        };

        public abstract boolean moveTo(Status nextStatus);
    }

    public Instance() {
    }

    public Instance(String flavorId) {
        this.flavorId = flavorId;
    }

    public Status status() {
        return status;
    }

    public boolean launch() {
        return moveStatusTo(Status.Pending);
    }

    public boolean reboot() {
        return moveStatusTo(Status.Rebooting);
    }

    public boolean terminate() {
        return moveStatusTo(Status.ShuttingDown);
    }

    public boolean moveStatusTo(Status status) {
        if (this.status.moveTo(status)) {
            this.status = status;
            return true;
        }
        return false;
    }

    public void setAZ(String AZ) {
        this.az = AZ;
    }

    public String getAZ() {
        return az;
    }

    public String getFlavorId() {
        return flavorId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

}
