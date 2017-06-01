package com.tw.dddsample.infrastructure.domain;

import com.tw.dddsample.domain.Flavor;
import com.tw.dddsample.domain.FlavorRepository;
import org.springframework.stereotype.Component;

/**
 * Created by azhu on 29/05/2017.
 */
@Component
public class FlavorRepositoryImpl implements FlavorRepository {
    @Override
    public Flavor findFlavor(String flavorId) {
        return new Flavor(flavorId, "tiny", 1, 1024);
    }
}
