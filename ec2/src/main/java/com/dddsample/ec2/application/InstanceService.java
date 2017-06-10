package com.dddsample.ec2.application;

import com.dddsample.ec2.domain.instance.Instance;
import com.dddsample.ec2.domain.instance.InstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by azhu on 26/05/2017.
 */
@Component
public class InstanceService {

    @Autowired
    private InstanceRepository instanceRepository;

    @Transactional
    public Instance createInstance(Instance instance) {
        return instanceRepository.save(instance);
    }

    public Instance launch(Instance instance) {
        instance.launch();
        return instanceRepository.save(instance);
    }

    public Instance reboot(Instance instance) {
        instance.reboot();
        return instanceRepository.save(instance);
    }

    public Instance terminate(Instance instance) {
        instance.terminate();
        return instanceRepository.save(instance);
    }
}
