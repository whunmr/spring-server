package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Instance {

    @Id
    private String instanceId = null;
    private String ec2InstanceId = null;
    private String instanceClass = null;
    private String engine = null;
    private Integer port = null;
    private String status = null;

    public Instance() {
    }

    public Instance(String instanceId, String ec2InstanceId, String instanceClass, String engine, Integer port, String status) {
        this.instanceId = instanceId;
        this.ec2InstanceId = ec2InstanceId;
        this.instanceClass = instanceClass;
        this.engine = engine;
        this.port = port;
        this.status = status;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public String getEc2InstanceId() {
        return ec2InstanceId;
    }

    public String getInstanceClass() {
        return instanceClass;
    }

    public String getEngine() {
        return engine;
    }

    public Integer getPort() {
        return port;
    }

    public String getStatus() {
        return status;
    }
}
