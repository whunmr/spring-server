package com.tw.dddsample.domain.flavor;

/**
 * Created by azhu on 27/05/2017.
 */
public interface FlavorRepository {

    public Flavor findFlavor(String flavorId);

    public Flavor save(Flavor flavor);
}
