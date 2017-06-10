package com.dddsample.ec2.infrastructure.domain;

import com.dddsample.ec2.domain.flavor.Flavor;
import com.dddsample.ec2.domain.flavor.FlavorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by azhu on 29/05/2017.
 */
@Component
public class FlavorRepositoryImpl extends SimpleJpaRepository<Flavor, String> implements FlavorRepository {

    public FlavorRepositoryImpl(@Autowired EntityManager em) {
        super(Flavor.class, em);
    }

    @Override
    public Flavor findFlavor(String flavorId) {
        return new Flavor(flavorId, 1, 1024);
    }

    @Override
    public Flavor save(Flavor flavor) {
        return super.save(flavor);
    }


    @Override
    public List<Flavor> findAll() {
        return super.findAll();
    }
}
