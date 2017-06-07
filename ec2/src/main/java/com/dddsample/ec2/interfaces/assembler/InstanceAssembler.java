package com.dddsample.ec2.interfaces.assembler;

import com.dddsample.ec2.domain.instance.Instance;
import io.swagger.model.InstanceAttributes;
import io.swagger.model.InstanceCreateRequest;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by azhu on 27/05/2017.
 */
public class InstanceAssembler {

    public io.swagger.model.Instance toDTO(Instance operateInstances) {
        io.swagger.model.Instance instance = new io.swagger.model.Instance();
        instance.setId(operateInstances.getInstanceId());
        InstanceAttributes attributes = new InstanceAttributes();
        attributes.setFlavorId(operateInstances.getFlavorId());
        attributes.setRegionId(operateInstances.getAZ());
        Instance.VMStatus status = operateInstances.status();
        if (status != null) {
            attributes.setStatus(status.toString());
        }

        instance.setAttributes(attributes);
        return instance;
    }

    public List<io.swagger.model.Instance> toDTOs(List<Instance> allInstance) {
        LinkedList<io.swagger.model.Instance> instances = new LinkedList<>();
        for (Instance instance : allInstance) {
            instances.add(toDTO(instance));
        }
        return instances;
    }

    public Instance fromDTO(InstanceCreateRequest creationRequest) {
        Instance instance = new Instance(creationRequest.getData().getAttributes().getPlan().getFlavorId());
        instance.setAZ(creationRequest.getData().getAttributes().getPlan().getAz());
        return instance;
    }
}
