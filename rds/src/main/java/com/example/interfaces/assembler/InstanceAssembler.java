package com.example.interfaces.assembler;

import com.example.domain.Instance;
import io.swagger.model.DBInstance;

public class InstanceAssembler {
    public static DBInstance toDTO(Instance instance) {
        DBInstance dbInstance = new DBInstance().instanceId(instance.getInstanceId())
                .instanceClass(instance.getInstanceClass())
                .engine(instance.getEngine())
                .port(instance.getPort())
                .status(instance.getStatus());
        return dbInstance;
    }

}
