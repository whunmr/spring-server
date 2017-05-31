package com.example.integration;


import com.example.Swagger2SpringBoot;
import com.example.controller.PetsApiImpl;
import io.swagger.model.Pet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT, classes={Swagger2SpringBoot.class})
public class PetsApiIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void catalogLoads() {
        ResponseEntity<Pet[]> entity = testRestTemplate.getForEntity("/pets", Pet[].class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }
}
