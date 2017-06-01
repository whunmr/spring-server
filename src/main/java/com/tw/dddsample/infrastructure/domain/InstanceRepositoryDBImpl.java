package com.tw.dddsample.infrastructure.domain;

import com.tw.dddsample.domain.Instance;
import com.tw.dddsample.domain.InstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

/**
 * Created by azhu on 30/05/2017.
 */
@Component("instanceRepository")
public class InstanceRepositoryDBImpl extends SimpleJpaRepository<Instance, String> implements Repository<Instance, String>, InstanceRepository {

    public InstanceRepositoryDBImpl(@Autowired EntityManager em) {
        super(Instance.class, em);
    }

    @Override
    @Transactional
    public Instance save(Instance instance) {
        if (StringUtils.isEmpty(instance.getInstanceId())) {
            //TODO: move UUID.random to domain ?
            instance.setInstanceId(UUID.randomUUID().toString());
        }
        return super.save(instance);
    }

    @Override
    public List<Instance> findAll() {
        return super.findAll();
    }

}
