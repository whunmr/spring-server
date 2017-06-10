package com.dddsample.ec2.application;

import com.dddsample.ec2.domain.flavor.Flavor;
import com.dddsample.ec2.domain.flavor.FlavorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Created by azhu on 10/06/2017.
 */
@Component
public class FlavorService {
    @Autowired
    private FlavorRepository flavorRepository;

    @Transactional
    public Flavor save(Flavor flavor) {
        return flavorRepository.save(flavor);
    }
}
