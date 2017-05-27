package com.exmple.e2e;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.exmple.e2e.TestUtil.propertyValue;
import static io.restassured.RestAssured.given;

public class PetsApiTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI  = propertyValue("server.host", "http://localhost");
        RestAssured.port     = propertyValue("server.port", 9001);
        RestAssured.basePath = propertyValue("server.base", "/");
    }

    @Test
    public void test__pet_website__is_running_ok() {
        given()
                .when().get("/")
                .then().statusCode(200);
    }

    @Test
    public void test__getPets_api__can__return_default_pets() {
        given()
                .when().get("/pets")
                .then().statusCode(200);
    }

}
