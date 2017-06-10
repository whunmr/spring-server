package com.dddsample.ec2.interfaces.assembler;

import com.dddsample.ec2.domain.instance.Instance;
import io.swagger.model.InstanceCreateRequest;
import io.swagger.model.InstanceListResponse;
import io.swagger.model.InstanceResponse;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by azhu on 27/05/2017.
 */
public class InstanceAssembler {

    public InstanceResponse toDTO(Instance instance) {
        return new InstanceResponse()
                .flavorId(instance.getFlavorId())
                .instanceId(instance.getInstanceId())
                .az(instance.getAZ())
                .status(instance.status().toString());
    }

    public InstanceListResponse toDTO(List<Instance> instanceList) {
        InstanceListResponse instancesResponses = new InstanceListResponse();
        for (Instance instance : instanceList) {
            instancesResponses.add(toDTO(instance));
        }
        return instancesResponses;
    }

    public Instance fromDTO(InstanceCreateRequest creationRequest) {
        Instance instance = new Instance(creationRequest.getFlavorId());
        instance.setAZ(creationRequest.getAz());
        return instance;
    }
}
