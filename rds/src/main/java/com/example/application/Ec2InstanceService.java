package com.example.application;

import com.example.application.ec2.Ec2Instance;

public interface Ec2InstanceService {
    Ec2Instance createInstance(String instanceClass);
}
