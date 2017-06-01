package com.tw.dddsample.domain;

import java.util.List;

/**
 * Created by azhu on 27/05/2017.
 */
public interface InstanceRepository {
    public Instance save(Instance instance);

    public List<Instance> findAll();
}
