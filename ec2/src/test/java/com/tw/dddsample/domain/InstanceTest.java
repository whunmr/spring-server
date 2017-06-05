package com.tw.dddsample.domain;


import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by azhu on 25/05/2017.
 */
public class InstanceTest {


    @Test
    public void should_start_instance_after_it_is_created() {
        Instance instance = createAnInstance();

        assertTrue(instance.start());
    }

    @Test
    public void should_not_retire_instance_when_is_running() {
        Instance instance = createAnInstance();
        instance.start();

        assertFalse("Should stop instance before retire", instance.retire());
    }

    @Test
    public void should_retire_instance_when_is_not_running() {
        Instance instance = createAnInstance();

        assertTrue("Should retire instance for unused instance", instance.retire());
    }

    @Test
    public void should_not_start_instance_after_retire() {
        Instance instance = createAnInstance();
        instance.retire();


        assertThat(instance.start(), is(false));
    }

    private Instance createAnInstance() {
        return new Instance();
    }


}