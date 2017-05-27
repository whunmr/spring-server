package com.exmple.e2e;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.swagger.model.Pet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.exmple.e2e.TestUtil.propertyValue;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PetsApiTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI  = propertyValue("server.host", "http://localhost");
        RestAssured.port     = propertyValue("server.port", 9001);
        RestAssured.basePath = propertyValue("server.base", "/");
    }

    @Test
    @Tag("happy_path")
    public void test__pet_website__is_running_ok() {
        given()
                .when().get("/")
                .then().statusCode(200);
    }

    @Test
    public void test__getPets_api__can__return_default_pets___by_direct_access_json_field() throws IOException {
        given()
                .when().get("/pets")
                .then().statusCode(200)
                       .body("[0].name", equalTo("foo"));
    }

    @Test
    public void test__getPets_api__can__return_default_pets___by_json_deserialization() throws IOException {
        String json = get("/pets").asString();

        ObjectMapper mapper = new ObjectMapper();
        Pet[] pets = mapper.readValue(json, Pet[].class);

        assertThat(pets.length, is(1));
        assertThat(pets[0].getName(), is("foo"));
    }

}
