package com.example.e2e;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static io.restassured.RestAssured.given;
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
}
