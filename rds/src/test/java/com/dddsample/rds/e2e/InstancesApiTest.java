package com.dddsample.rds.e2e;

import io.restassured.RestAssured;
import io.swagger.model.DBInstance;
import net.sf.json.JSON;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
public class InstancesApiTest {

    @LocalServerPort
    private int port;

    @Before
    public void setup() {
        RestAssured.baseURI  = "http://localhost";
        RestAssured.port     = port;
        RestAssured.basePath = "/";
    }

    @Test
    public void test__pet_website__is_running_ok() {
        given()
                .when().get("/")
                .then().statusCode(200);
    }

    @Test
    public void test__getPets_api__can__return_default_pets___by_direct_access_json_field() throws IOException {
        given()
                .when().get("/instances")
                .then().statusCode(200);
    }

    // run specific test:>> mvn -Dtest=*InstancesApiTest* clean test
    @Test
    public void should_able_to__create_instance_by_post() throws IOException {
        JSONObject request = new JSONObject()
            .put("instanceId","mybox")
            .put("engine","mysql")
            .put("instanceClass","t1.micro")
            .put("port","9999")
            .put("availableZone","sz");


        given()
            .contentType("application/json")
            .body(request.toString())
        .when()
            .post("/instances")
        .then()
            .body("instance.ec2InstanceId", is(notNullValue()));
    }

}
