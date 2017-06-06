package com.example.e2e;

import com.example.Application;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static com.example.e2e.TestUtil.propertyValue;
import static io.restassured.RestAssured.given;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT, classes={Application.class})
public class InstancesApiTest {
    @Before
    public void setup() {
        RestAssured.baseURI  = propertyValue("server.host", "http://localhost");
        RestAssured.port     = propertyValue("server.port", 9000);
        RestAssured.basePath = propertyValue("server.base", "/");
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
