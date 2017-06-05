package com.tw.dddsample.interfaces.controller.assembler;

import com.tw.dddsample.domain.Instance;
import io.swagger.model.InstanceAttributes;
import io.swagger.model.NewServiceRequest;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by azhu on 27/05/2017.
 */
public class InstanceAssembler {

    public Instance fromDTO(NewServiceRequest body) {

        Instance instance = new Instance(body.getData().getAttributes().getName(), body.getData().getAttributes().getPlan().getImageId(), body.getData().getAttributes().getPlan().getFlavorId());
        instance.setAZ(body.getData().getAttributes().getPlan().getAz());
        return instance;
    }

    public io.swagger.model.Instance toDTO(Instance operateInstances) {
        io.swagger.model.Instance instance = new io.swagger.model.Instance();
        instance.setId(operateInstances.getInstanceId());
        InstanceAttributes attributes = new InstanceAttributes();
        attributes.setFlavorId(operateInstances.getFlavorId());
        attributes.setRegionId(operateInstances.getAZ());
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
}
