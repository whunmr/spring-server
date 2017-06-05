package com.tw.dddsample.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Created by azhu on 25/05/2017.
 */
@Entity
public class Instance {
    public static final String DEFAULT_REGION = "SZ";
    public String getInstanceId() {
        return instanceId;
    }

    @Id
    private String instanceId;

    private String name;
    private String imageId;
    private String flavorId;
    @Transient
    private Region region;
    private String az;

    private VMStatus  vmStatus;

    enum VMStatus {Pending, Running, ShuttingDown, Rebooting, Terminated}

    public Instance() {
        region = new Region(DEFAULT_REGION);
    }

    public Instance(String name, String imageId, String flavorId) {
        this.name = name;
        this.imageId = imageId;
        this.flavorId = flavorId;
    }

    public VMStatus status() {
        return vmStatus;
    }

    public boolean launch() {
        if (vmStatus == null) {
            vmStatus = VMStatus.Pending;
            return true;
        }
        return false;
    }

    //TODO how notify resource context to retire instance physically
    public boolean syncStatus(VMStatus vmStatus) {
        if (vmStatus == VMStatus.Running) {
            if (this.vmStatus == VMStatus.Pending) {
                this.vmStatus = VMStatus.Running;
                return true;
            } else if (this.vmStatus == VMStatus.Rebooting) {
                this.vmStatus = VMStatus.Running;
                return true;
            }else {
                return false;
            }
        }

        if (vmStatus == VMStatus.Terminated) {
            if (this.vmStatus == VMStatus.ShuttingDown) {
                this.vmStatus = VMStatus.Terminated;
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    public boolean reboot() {
        if (this.vmStatus == VMStatus.Running) {
            vmStatus = VMStatus.Rebooting;
            return true;
        }
        return false;
    }

    public boolean terminate() {
        if (vmStatus == VMStatus.Running) {
            vmStatus = VMStatus.ShuttingDown;
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
