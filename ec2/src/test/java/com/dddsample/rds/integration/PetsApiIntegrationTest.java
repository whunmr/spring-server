package com.dddsample.rds.integration;


import com.dddsample.ec2.Application;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT, classes={Application.class})
public class PetsApiIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

//    @Test
//    public void catalogLoads() {
//        ResponseEntity<Pet[]> entity = testRestTemplate.getForEntity("/pets", Pet[].class);
//        assertEquals(HttpStatus.OK, entity.getStatusCode());
//    }
}
