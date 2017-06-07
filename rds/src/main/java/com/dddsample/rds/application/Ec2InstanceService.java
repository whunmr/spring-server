package com.dddsample.rds.application;

import com.dddsample.rds.application.ec2.Ec2Instance;

public interface Ec2InstanceService {
    Ec2Instance createInstance(String instanceClass);
}
