package com.example.interfaces;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import io.swagger.model.CreateDBInstanceRequest;
import io.swagger.model.CreateDBInstanceResponse;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.HttpMethod;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by azhu on 06/06/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class InstancesFacadeTest {
    DslPart requestData = new PactDslJsonBody()
            .object("data")
                .object("attributes")
                    .stringValue("name", "create aa instance")
                    .object("plan")
                        .stringValue("image_id", "image____id__3")
                        .stringValue("flavor_id", "flavor_id1")
                        .stringValue("az", "SZ")
                    .closeObject()
                .closeObject()
            .closeObject()
            .close();

    DslPart responseData = new PactDslJsonBody().object("data")
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


    @Rule
    public PactProviderRuleMk2 rule = new PactProviderRuleMk2("EC2", "localhost",9002, this);

//    @Autowired
//    private EurekaDiscoveryClient client;

//    @Bean
//    public EurekaDiscoveryClient getClient() {
//        EurekaDiscoveryClient mock = mock(EurekaDiscoveryClient.class);
//        LinkedList<ServiceInstance> t = new LinkedList<>();
//        ServiceInstance serviceInstance = mock(ServiceInstance.class);
//        when(serviceInstance.getHost()).thenReturn("localhost");
//        when(serviceInstance.getPort()).thenReturn(9002);
//        when(serviceInstance.getServiceId()).thenReturn("EC2");
//        t.add(serviceInstance);
//        when(mock.getInstances("EC2")).thenReturn(t);
//        return mock;
//    }


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
                .body(requestData)
                .toPact();
    }

    @Test
    @PactVerification("EC2")
    public void should_create_an_mysql_db_instance_successfully() {
        ResponseEntity<CreateDBInstanceResponse> response = instancesFacade.createInstance(new CreateDBInstanceRequest().instanceClass("c1.medium").engine("MySQL"));
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getInstance().getEngine(), "MySQL");
        assertEquals(response.getBody().getInstance().getInstanceClass(), "c1.medium");
        assertNotNull(response.getBody().getInstance().getInstanceId());

    }

}