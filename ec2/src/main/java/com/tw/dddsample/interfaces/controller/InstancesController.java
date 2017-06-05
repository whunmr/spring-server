package com.tw.dddsample.interfaces.controller;

import com.google.gson.GsonBuilder;
import com.tw.dddsample.application.InstanceService;
import com.tw.dddsample.domain.Instance;
import com.tw.dddsample.domain.InstanceRepository;
import io.swagger.api.InstancesApiDelegate;
import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse202;
import io.swagger.model.NewServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//TODO move to infrastructure
@Component
public class InstancesController implements InstancesApiDelegate {

    @Autowired
    private InstanceService instanceService;
    @Autowired
    private InstanceRepository instanceRepository;

//    @RequestMapping(path = "/instances", method = RequestMethod.POST)
//    @ResponseBody
//    public String createInstance(@RequestBody RequestParamWrapper requestParamWrapper) {
//        //TODO rename RequestParamWrapper
//        Instance instance = new InstanceAssembler(requestParamWrapper.get()).assembleInstance();
//        instanceService.createInstance(instance);
//        //TODO refactor to viewresolver
//        return new GsonBuilder().create().toJson(instance);
//    }
//
//    @RequestMapping(path = "/instances", method = RequestMethod.GET)
//    @ResponseBody
//    public String findInstances() {
//        return new GsonBuilder().create().toJson(instanceRepository.findAll());
//    }

    @Override
    public ResponseEntity<InlineResponse200> instancesGet(String contentType, String accept, String xRegion) {
        //TODO:
        return null;
    }


    @RequestMapping(path = "/instances/{instanceId}/action", method = RequestMethod.PUT)
    @ResponseBody
    public String operateInstances(@RequestParam String action, @PathVariable String instanceId) {
        Instance instance = instanceRepository.find(instanceId);
        Instance executedInstance = InstanceOperation.valueOf(action).execute(instanceService, instance);
        return new GsonBuilder().create().toJson(instance);
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

    @Override
    public ResponseEntity<InlineResponse202> instancesPost(String contentType, String accept, NewServiceRequest body) {
        //TODO:
        return null;
    }
}
