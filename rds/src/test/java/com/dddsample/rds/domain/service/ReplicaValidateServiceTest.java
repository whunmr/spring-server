package com.dddsample.rds.domain.service;

import com.dddsample.rds.domain.Instance;
import com.dddsample.rds.domain.InstanceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
@Transactional
public class ReplicaValidateServiceTest {

    @Autowired
    private ReplicaValidateService replicaValidateService;

    @Autowired
    private InstanceRepository instanceRepository;


    @Test
    public void validation_should_failed___if_sourceDB_can_NOT_found_in_database() throws Exception {
        assertEquals(false, replicaValidateService.validate("mybox", "SZ"));
    }

    @Test
    public void validation_should_failed___if_sourceDB_and_replica__are_in_same_az() throws Exception {
        given_has_db_instance_in_az("mybox", "SZ");

        assertEquals(false, replicaValidateService.validate("mybox", "SZ"));
    }


    @Test
    public void validation_should_pass__if_souceDB_and_replica__are_NOT_in_same_az() {
        given_has_db_instance_in_az("mybox", "SZ");

        assertEquals(true, replicaValidateService.validate("mybox", "NJ"));
    }


    private void given_has_db_instance_in_az(String istanceId, String az) {
        Instance souceDB = new Instance(istanceId, "foo", "m1.media", "mysql", 8000, az, null, "running");
        instanceRepository.save(souceDB);
    }
}