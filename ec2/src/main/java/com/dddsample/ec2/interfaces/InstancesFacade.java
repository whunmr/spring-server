package com.dddsample.ec2.interfaces;

import com.dddsample.ec2.application.InstanceService;
import com.dddsample.ec2.domain.instance.Instance;
import com.dddsample.ec2.domain.instance.InstanceRepository;
import com.dddsample.ec2.interfaces.assembler.InstanceAssembler;
import io.swagger.api.InstancesApiDelegate;
import io.swagger.model.InstanceCreateRequest;
import io.swagger.model.InstanceListResponse;
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
    public ResponseEntity<InstanceResponse> createInstances(InstanceCreateRequest body) {
        Instance createdInstance = instanceService.createInstance(new InstanceAssembler().fromDTO(body));

        return new ResponseEntity<>(instanceAssembler.toDTO(createdInstance), HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<InstanceResponse> findInstance(String instanceId) {
        return ResponseEntity.ok(instanceAssembler.toDTO(instanceRepository.find(instanceId)));
    }

    @Override
    public ResponseEntity<InstanceListResponse> findInstances(String flavor) {
        //TODO: implement find by paramenters, not findAll
        List<Instance> instanceList = instanceRepository.findAll();
        return ResponseEntity.ok(instanceAssembler.toDTO(instanceList));
    }

    @Override
    public ResponseEntity<InstanceResponse> operateInstance(String instanceId, String action) {
                Instance instance1 = instanceRepository.find(instanceId);
        Instance executedInstance = InstanceOperation.valueOf(action).execute(instanceService, instance1);

        return ResponseEntity.ok(instanceAssembler.toDTO(executedInstance));
    }

    private enum InstanceOperation {

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
