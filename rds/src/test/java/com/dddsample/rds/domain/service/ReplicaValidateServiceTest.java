package com.dddsample.rds.domain.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
@Transactional
public class ReplicaValidateServiceTest {

    @Autowired
    private ReplicaValidateService replicaValidateService;



    @Test
    public void validation_should_failed___if_sourceDB_can_NOT_found_in_database() throws Exception {
        assertEquals(false, replicaValidateService.validate("mybox", "SZ"));
    }

}