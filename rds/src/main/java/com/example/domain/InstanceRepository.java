package com.example.domain;

import java.util.List;

public interface InstanceRepository {

    public Instance save(Instance instance);

    public List<Instance> findAll();

    public Instance find(String instanceId);
}
