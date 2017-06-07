package com.dddsample.rds.domain;

import java.util.List;

public interface InstanceRepository {

    Instance save(Instance instance);

    List<Instance> findAll();

    Instance find(String instanceId);
}
