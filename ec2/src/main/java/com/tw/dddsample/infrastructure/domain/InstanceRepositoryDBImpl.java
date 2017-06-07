package com.tw.dddsample.infrastructure.domain;

import com.tw.dddsample.domain.instance.Instance;
import com.tw.dddsample.domain.instance.InstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
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
public class InstanceRepositoryDBImpl extends SimpleJpaRepository<Instance, String> implements InstanceRepository {

    public InstanceRepositoryDBImpl(@Autowired EntityManager em) {
        super(Instance.class, em);
    }

    @Override
    @Transactional
    public Instance save(Instance instance) {
        if (StringUtils.isEmpty(instance.getInstanceId())) {
            instance.setInstanceId(UUID.randomUUID().toString());
        }
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
