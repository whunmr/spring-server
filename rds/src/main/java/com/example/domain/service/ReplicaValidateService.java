package com.example.domain.service;

import com.example.domain.Instance;
import com.example.domain.InstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReplicaValidateService {

    @Autowired
    private InstanceRepository instanceRepository;

    @Autowired
    private ReplicaShouldInDifferentAzRule replicaShouldInDifferentAzRule;

    public boolean validate(String sourceDBId, String azOfReplica) {
        Instance sourceDB = instanceRepository.find(sourceDBId);
        if (sourceDB == null) {
            return false;
        }

        return replicaShouldInDifferentAzRule.validate(sourceDB.getAvailableZone(), azOfReplica);
    }
}

