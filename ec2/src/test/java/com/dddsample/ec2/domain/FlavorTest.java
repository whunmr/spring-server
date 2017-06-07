package com.dddsample.ec2.domain;

import com.dddsample.ec2.domain.flavor.Flavor;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by azhu on 07/06/2017.
 */
public class FlavorTest {

    @Test
    public void should_recognize_flavor_mode_correctly() {
        Flavor flavor = new Flavor("m3.medium", 1, 3.75f);
        assertThat(flavor.getMode(), is(Flavor.Mode.General));
    }

    @Test
    public void should_recognize_flavor_mode_correctly_for_compute_optimized() {
        assertThat(Flavor.Mode.create("c3"), is(Flavor.Mode.Compute));
    }

    @Test
    public void should_recognize_flavor_mode_correctly_for_memory_optimized() {
        assertThat(Flavor.Mode.create("r3"), is(Flavor.Mode.Memory));
    }

    @Test
    public void should_create_a_valid_flavor_successfully_for_general_purpose_when_its_proportion_is_8v30() {
        new Flavor("m3.medium", 1, 3.75f);
    }

    @Test(expected = InvalidParameterException.class)
    public void should_not_create_a_valid_flavor_for_general_purpose_when_its_proportion_is_not_8v30() {
        new Flavor("m3.medium", 3, 3.75f);
    }

    @Test
    public void should_create_a_valid_flavor_for_compute_optimized_when_its_proportion_is_8v15() {
        new Flavor("c3.xlarge", 4, 7.5f);
    }

    @Test(expected = InvalidParameterException.class)
    public void should_not_create_a_valid_flavor_for_compute_optimized_when_its_proportion_is_not_8v15() {
        new Flavor("c3.xlarge", 5, 7.5f);
    }

    @Test
    public void should_create_a_valid_flavor_for_memory_optimized_when_its_proportion_is_8v61() {
        new Flavor("r3.2xlarge", 8 , 61f);
    }

    @Test(expected = InvalidParameterException.class)
    public void should_not_create_a_valid_flavor_for_memory_optimized_when_its_proportion_is_not_8v61() {
        new Flavor("r3.2xlarge", 8 , 60f);
    }

}