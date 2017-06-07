package com.dddsample.rds.infrastructure.domain;

import com.dddsample.rds.domain.Instance;
import com.dddsample.rds.domain.InstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Component("instanceRepository")
public class InstanceRepositoryDBImpl extends SimpleJpaRepository<Instance, String> implements InstanceRepository {
    public InstanceRepositoryDBImpl(@Autowired EntityManager em) {
        super(Instance.class, em);
    }

    @Override
    @Transactional
    public Instance save(Instance instance) {
        return super.save(instance);
    }

    @Override
    public List<Instance> findAll() {
        return super.findAll();
    }

    @Override
    public Instance find(String instanceId) {
        return super.findOne(instanceId);
    }
}
