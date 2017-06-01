package com.tw.dddsample.interfaces.controller;

import com.tw.dddsample.domain.Instance;
import com.tw.dddsample.interfaces.controller.dto.CreateInstanceRequestData;

/**
 * Created by azhu on 27/05/2017.
 */
public class InstanceAssembler {
    private CreateInstanceRequestData createInstanceRequestData;

    public InstanceAssembler(CreateInstanceRequestData createInstanceRequestData) {
        this.createInstanceRequestData = createInstanceRequestData;
    }

    public Instance assembleInstance() {
        Instance instance = new Instance(createInstanceRequestData.getName(), createInstanceRequestData.getImageId(), createInstanceRequestData.getFlavorId());
        instance.setAZ(createInstanceRequestData.getAZ());
        return instance;
    }
}
