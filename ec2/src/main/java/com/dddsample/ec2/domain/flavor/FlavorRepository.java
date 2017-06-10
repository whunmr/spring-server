package com.dddsample.ec2.domain.flavor;

import java.util.List;

/**
 * Created by azhu on 27/05/2017.
 */
public interface FlavorRepository {

    public Flavor findFlavor(String flavorId);

    public Flavor save(Flavor flavor);

    public List<Flavor> findAll();
}
