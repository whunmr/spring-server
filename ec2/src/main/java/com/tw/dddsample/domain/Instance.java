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
    private InstanceStatus status = InstanceStatus.Accepted;

    /*
    Instance status of AWS
    instance-state-code - The code for the instance state, as a 16-bit unsigned integer. The high byte is an opaque internal value and should be ignored. The low byte is set based on the state represented.
                          The valid values are 0 (pending), 16 (running), 32 (shutting-down), 48 (terminated), 64 (stopping), and 80 (stopped).
    instance-state-name - The state of the instance (pending | running | shutting-down | terminated | stopping | stopped ).
    instance-status.reachability - Filters on instance status where the name is reachability (passed | failed | initializing | insufficient-data ).
    instance-status.status - The status of the instance (ok | impaired | initializing | insufficient-data | not-applicable ).
    system-status.reachability - Filters on system status where the name is reachability (passed | failed | initializing | insufficient-data ).
    system-status.status - The system status of the instance (ok | impaired | initializing | insufficient-data | not-applicable ).
    */

    /*
    ============  =================================================================
    VM State      Commands
    ============  =================================================================
    Paused        unpause
    Suspended     resume
    Active        suspend, pause, rescue, rebuild, delete, backup, stop, reboot
    Shutoff       suspend, pause, rescue, rebuild, delete, backup, start, stop, reboot
    Rescued       unrescue, pause
    Stopped       rescue, delete, start
    Error         delete
    Building      delete
    Rescued       delete, stop, reboot
    ============  =================================================================
    */

    enum InstanceStatus {Building, Accepted, Created, Running, Pause, Stopped, Deleting, Retired}
    enum VMStatus {Building, Active, Stopped, ShutOff, Error}

    public Instance() {
        region = new Region(DEFAULT_REGION);
    }

    public Instance(String regionName) {
        region = new Region(regionName);
    }

    public Instance(String name, String imageId, String flavorId) {
        this.name = name;
        this.imageId = imageId;
        this.flavorId = flavorId;
    }

    public String region() {
        return region.name();
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

    public boolean start() {
        this.status = InstanceStatus.Running;
        return true;
    }

    //TODO how notify resource context to retire instance physically
    public boolean retire() {
        if (status != InstanceStatus.Running) {
            return true;

        }
        return false;
    }
}
