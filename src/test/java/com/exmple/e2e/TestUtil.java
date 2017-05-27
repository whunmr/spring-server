package com.exmple.e2e;

public class TestUtil {

    static String propertyOr(String propertyKey, String defaultValue) {
        return (System.getProperty(propertyKey) == null) ? defaultValue : System.getProperty(propertyKey);
    }

    static Integer propertyOr(String propertyKey, Integer defaultValue) {
        return (System.getProperty(propertyKey) == null) ? defaultValue : Integer.valueOf(System.getProperty(propertyKey));
    }

}
