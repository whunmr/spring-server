package com.dddsample.rds.application;

import com.dddsample.rds.application.ec2.Ec2Instance;
import com.dddsample.rds.domain.service.ReplicaValidateService;
import com.dddsample.rds.domain.Instance;
import com.dddsample.rds.domain.InstanceRepository;
import com.dddsample.rds.interfaces.assembler.InstanceAssembler;
import io.swagger.model.CreateDBInstanceRequest;
import io.swagger.model.CreateDBInstanceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InstanceService {

    @Autowired
    private Ec2InstanceService ec2InstanceService;

    @Autowired
    private InstanceRepository instanceRepository;

    @Autowired
    private ReplicaValidateService replicaValidateService;


    public Instance createInstance(CreateDBInstanceRequest req) {

        boolean isCreatingReplicaInstance = req.getSourceDBId() != null;
        if (isCreatingReplicaInstance) {
            if (! replicaValidateService.validate(req.getSourceDBId(), req.getAvailableZone())) {
                return null;
            }
        }

        Ec2Instance ec2Instance = ec2InstanceService.createInstance(req.getInstanceClass());

        //call db installation and setup routine
        Instance instance = new Instance( req.getInstanceId()
                                        , ec2Instance.getId()
                                        , req.getInstanceClass()
                                        , req.getEngine()
                                        , req.getPort()
                                        , req.getAvailableZone()
                                        , req.getSourceDBId()
                                        , ec2Instance.getStatus());
        instanceRepository.save(instance);

        return instance;
    }


}
