package com.dddsample.rds.interfaces.assembler;

import com.dddsample.rds.domain.Instance;
import io.swagger.model.DBInstance;

import java.util.LinkedList;
import java.util.List;

public class InstanceAssembler {
    public static DBInstance toDTO(Instance instance) {
        DBInstance dbInstance = new DBInstance().instanceId(instance.getInstanceId())
                .instanceClass(instance.getInstanceClass())
                .engine(instance.getEngine())
                .port(instance.getPort())
                .availableZone(instance.getAvailableZone())
                .status(instance.getStatus())
                .ec2InstanceId(instance.getEc2InstanceId());
        return dbInstance;
    }

    public static List<DBInstance> toDTOs(List<Instance> allInstance) {
        LinkedList<DBInstance> instances = new LinkedList<>();
        for (Instance instance : allInstance) {
            instances.add(InstanceAssembler.toDTO(instance));
        }

        return instances;
    }
}
