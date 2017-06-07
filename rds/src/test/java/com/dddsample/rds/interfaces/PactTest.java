package com.dddsample.rds.interfaces;

import au.com.dius.pact.consumer.PactTestRun;
import au.com.dius.pact.consumer.PactVerificationResult;
import au.com.dius.pact.model.MockProviderConfig;
import au.com.dius.pact.model.PactSpecVersion;
import au.com.dius.pact.model.RequestResponsePact;

import static au.com.dius.pact.consumer.ConsumerPactRunnerKt.runConsumerTest;
import static org.junit.Assert.assertEquals;

public class PactTest {
    public static void run(RequestResponsePact pact, PactTestRun pactTestRun) {
        MockProviderConfig config = MockProviderConfig.createDefault("localhost", PactSpecVersion.V2);
        config.setPort(9002);
        PactVerificationResult result = runConsumerTest(pact, config, pactTestRun);

        if (result instanceof PactVerificationResult.Error) {
            throw new RuntimeException(((PactVerificationResult.Error)result).getError());
        }

        assertEquals(PactVerificationResult.Ok.INSTANCE, result);
    }
}
