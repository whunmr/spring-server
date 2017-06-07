package com.dddsample.ec2.domain.instance;

import java.util.List;

/**
 * Created by azhu on 27/05/2017.
 */
public interface InstanceRepository {
    public Instance save(Instance instance);

    public List<Instance> findAll();

    public Instance find(String instanceId);
}
