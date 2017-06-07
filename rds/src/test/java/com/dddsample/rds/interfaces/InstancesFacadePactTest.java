package com.dddsample.rds.interfaces;

import au.com.dius.pact.consumer.ConsumerPactBuilder;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.model.RequestResponsePact;
import io.swagger.model.CreateDBInstanceRequest;
import io.swagger.model.CreateDBInstanceResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.HttpMethod;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class InstancesFacadePactTest {

    @Autowired
    private InstancesFacade instancesFacade;

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
                                    .object("attributes")
                                        .stringValue("flavor_id", "c1.medium")
                                    .closeObject()
                                .closeObject().close();

    protected RequestResponsePact create_ec2_instance_when_rds_create_db_instance() {
        return ConsumerPactBuilder.consumer("RDS").hasPactWith("EC2")
                .uponReceiving("a request to create an ec2 instance")
                    .headers("Content-Type", "application/json")
                    .body(requestData)
                    .method(HttpMethod.POST)
                    .path("/instances")
                .willRespondWith()
                    .body(responseData)
                .toPact();
    }

    @Test
    public void should_create_an_mysql_db_instance_successfully() {
        PactTest.run(create_ec2_instance_when_rds_create_db_instance(), mockServer -> {

            CreateDBInstanceRequest createDBRequest = new CreateDBInstanceRequest()
                                                            .instanceId("my_rds_mysql_instance1")
                                                            .instanceClass("c1.medium")
                                                            .engine("MySQL");

            ResponseEntity<CreateDBInstanceResponse> response = instancesFacade.createInstance(createDBRequest);

            assertEquals(response.getStatusCode(), HttpStatus.OK);
            assertEquals(response.getBody().getInstance().getEngine(), "MySQL");
            assertEquals(response.getBody().getInstance().getInstanceClass(), "c1.medium");
            assertNotNull(response.getBody().getInstance().getInstanceId());
        });
    }
}