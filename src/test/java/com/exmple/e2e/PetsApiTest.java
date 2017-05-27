package com.exmple.e2e;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PetsApiTest {
    @Test
    public void test__website__is_running_ok() {
        given().when().get("http://localhost:9001").then().statusCode(200);
    }
}
