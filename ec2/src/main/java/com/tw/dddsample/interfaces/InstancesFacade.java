package com.tw.dddsample.interfaces;

import com.tw.dddsample.application.InstanceService;
import com.tw.dddsample.domain.Instance;
import com.tw.dddsample.domain.InstanceRepository;
import com.tw.dddsample.interfaces.assembler.InstanceAssembler;
import io.swagger.api.InstancesApiDelegate;
import io.swagger.model.*;
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
    public ResponseEntity<InlineResponse202> instancesPost(String contentType, String accept, NewServiceRequest body) {
        Instance createdInstance = instanceService.createInstance(new InstanceAssembler().fromDTO(body));

        io.swagger.model.Instance instance = instanceAssembler.toDTO(createdInstance);
        InlineResponse202 response = new InlineResponse202()
                .data(new AsynchronousNewInstanceResponse()
                        .id(instance.getId())
                        .attributes(new AsynchronousnewinstanceresponseAttributes()
                                .addResultsItem(new AsynchronousnewinstanceresponseAttributesResults()
                                        .instanceId(instance.getId())
                                )
                        )
                );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<InlineResponse200> instancesGet(String contentType, String accept, String xRegion) {
        List<Instance> allInstance = instanceRepository.findAll();

        return new ResponseEntity<>(new InlineResponse200().data(instanceAssembler.toDTOs(allInstance)), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<InlineResponse200> instancesInstanceIdActionPut(String instanceId, String contentType, String accept, String action) {
        Instance instance1 = instanceRepository.find(instanceId);
        Instance executedInstance = InstanceOperation.valueOf(action).execute(instanceService, instance1);

        io.swagger.model.Instance instance = instanceAssembler.toDTO(executedInstance);
        InlineResponse200 response200 = new InlineResponse200();
        response200.addDataItem(instance);

        return new ResponseEntity<>(response200, HttpStatus.OK);
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
