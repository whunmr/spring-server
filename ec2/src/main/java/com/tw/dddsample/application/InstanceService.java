package com.tw.dddsample.application;

import com.tw.dddsample.domain.flavor.FlavorRepository;
import com.tw.dddsample.domain.instance.Instance;
import com.tw.dddsample.domain.instance.InstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by azhu on 26/05/2017.
 */
@Component
public class InstanceService {

    @Autowired
    private InstanceRepository instanceRepository;

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
