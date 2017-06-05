package com.tw.dddsample.domain;

import org.junit.Test;

import java.security.InvalidParameterException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by azhu on 25/05/2017.
 */
public class RegionTest {
    @Test(expected = InvalidParameterException.class)
    public void should_not_initialize_an_non_existed_region() {
        new Region("XA");
    }

    @Test
    public void should_initialize_an_existed_region() {
        Region sz = new Region("SZ");
        assertThat(sz.name(), is("SZ"));

    }

}