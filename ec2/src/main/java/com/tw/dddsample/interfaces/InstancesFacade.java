package com.tw.dddsample.interfaces;

import com.tw.dddsample.application.InstanceService;
import com.tw.dddsample.domain.instance.Instance;
import com.tw.dddsample.domain.instance.InstanceRepository;
import com.tw.dddsample.interfaces.assembler.InstanceAssembler;
import io.swagger.api.InstancesApiDelegate;
import io.swagger.model.InstanceCreateRequest;
import io.swagger.model.InstanceList;
import io.swagger.model.InstanceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InstancesFacade implements InstancesApiDelegate {

    @Autowired
    private InstanceService instanceService;

    @Autowired
    private InstanceRepository instanceRepository;

    private InstanceAssembler instanceAssembler = new InstanceAssembler();


    @Override
    public ResponseEntity<InstanceList> findInstances(String region) {
        List<Instance> allInstance = instanceRepository.findAll();

        return new ResponseEntity<>(new InstanceList().data(instanceAssembler.toDTOs(allInstance)), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<InstanceResponse> createInstances(InstanceCreateRequest body) {

        Instance createdInstance = instanceService.createInstance(new InstanceAssembler().fromDTO(body));

        return new ResponseEntity<>(new InstanceResponse().data(instanceAssembler.toDTO(createdInstance)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<InstanceResponse> findInstance(String instanceId) {
        Instance instance = instanceRepository.find(instanceId);
        return new ResponseEntity<>(new InstanceResponse().data(instanceAssembler.toDTO(instance)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<InstanceResponse> operateInstance(String instanceId, String action) {
        Instance instance1 = instanceRepository.find(instanceId);
        Instance executedInstance = InstanceOperation.valueOf(action).execute(instanceService, instance1);

        io.swagger.model.Instance instance = instanceAssembler.toDTO(executedInstance);

        return new ResponseEntity<>(new InstanceResponse().data(instance), HttpStatus.OK);
    }

    private enum InstanceOperation {

        //TODO to delete it, since it won't open to end user
        Launch {
            @Override
            public Instance execute(InstanceService instanceService, Instance instance) {
                return instanceService.launch(instance);
            }
        },
        Reboot {
            @Override
            public Instance execute(InstanceService instanceService, Instance instance) {
                return instanceService.reboot(instance);
            }
        },
        Terminate {
            @Override
            public Instance execute(InstanceService instanceService, Instance instance) {
                return instanceService.terminate(instance);
            }
        };

        public abstract Instance execute(InstanceService instanceService, Instance instance);

    }
}
