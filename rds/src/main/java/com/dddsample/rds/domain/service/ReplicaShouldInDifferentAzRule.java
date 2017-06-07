package com.dddsample.rds.domain.service;


import org.springframework.stereotype.Component;

@Component
public class ReplicaShouldInDifferentAzRule {
    public static boolean validate(String azOfSourceDB, String azOfReplica) {
        return ! azOfSourceDB.equals(azOfReplica);
    }
}