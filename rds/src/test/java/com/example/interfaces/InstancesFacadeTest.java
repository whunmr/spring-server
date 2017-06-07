package com.example.interfaces;

import au.com.dius.pact.consumer.*;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.MockProviderConfig;
import au.com.dius.pact.model.PactSpecVersion;
import au.com.dius.pact.model.RequestResponsePact;
import io.swagger.model.CreateDBInstanceRequest;
import io.swagger.model.CreateDBInstanceResponse;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.HttpMethod;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static au.com.dius.pact.consumer.ConsumerPactRunnerKt.runConsumerTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by azhu on 06/06/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class InstancesFacadeTest {
//    DslPart requestData = new PactDslJsonBody()
//            .object("data")
//                .object("attributes")
//                    .stringValue("name", "create aa instance")
//                    .object("plan")
//                        .stringValue("image_id", "image____id__3")
//                        .stringValue("flavor_id", "c1.medium")
//                        .stringValue("az", "SZ")
//                    .closeObject()
//                .closeObject()
//            .closeObject()
//            .close();

    DslPart requestData = new PactDslJsonBody()
            .object("data")
                .object("attributes")
                    .object("plan")
                        .stringValue("flavor_id", "c1.medium")
                    .closeObject()
                .closeObject()
            .closeObject()
            .close();

    DslPart responseData = new PactDslJsonBody().object("data")
                                    .stringValue("id", "fake_ec2_instance_uuid")
                                    .stringMatcher("id", "[0-9a-zA-Z\\-]+")
                                    .stringValue("type", "c1.medium")
                                    .object("attributes")
                                        .stringType("name")
                                        .stringType("alias")
                                        .stringType("image_id")
                                        .stringType("region_id")
                                        .stringType("status")
                                        .stringType("flavor_id")
                                    .closeObject()
                                .closeObject().close();


//    @Rule
//    public PactProviderRuleMk2 rule = new PactProviderRuleMk2("EC2", "localhost",9002, this);

    @Autowired
    private InstancesFacade instancesFacade;

    @Pact(provider = "EC2", consumer = "RDS")
    protected RequestResponsePact create_ec2_instance_when_rds_create_db_instance(PactDslWithProvider builder) {

        return builder.uponReceiving("a request to create an ec2 instance")
                .headers("Content-Type", "application/json")
                .body(requestData)
                .method(HttpMethod.POST)
                .path("/instances")
                .willRespondWith()
                .body(responseData)
                .toPact();
    }


    public void should_create_an_mysql_db_instance_successfully() {
        ResponseEntity<CreateDBInstanceResponse> response = instancesFacade.createInstance(new CreateDBInstanceRequest().instanceId("my_rds_mysql_instance1").instanceClass("c1.medium").engine("MySQL"));
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getInstance().getEngine(), "MySQL");
        assertEquals(response.getBody().getInstance().getInstanceClass(), "c1.medium");
        assertNotNull(response.getBody().getInstance().getInstanceId());
    }

    @Test
    public void testPact() {
        PactDslWithProvider pactDslWithProvider = ConsumerPactBuilder.consumer("RDS").hasPactWith("EC2");

        RequestResponsePact pact = create_ec2_instance_when_rds_create_db_instance(pactDslWithProvider);

        MockProviderConfig config = MockProviderConfig.createDefault("localhost", PactSpecVersion.V2);
        config.setPort(9002);
        PactVerificationResult result = runConsumerTest(pact, config, mockServer -> {
            should_create_an_mysql_db_instance_successfully();
        });

        if (result instanceof PactVerificationResult.Error) {
            throw new RuntimeException(((PactVerificationResult.Error)result).getError());
        }

        assertEquals(PactVerificationResult.Ok.INSTANCE, result);
    }


}