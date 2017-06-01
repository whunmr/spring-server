package com.example.e2e;

public class TestUtil {

    static String propertyValue(String propertyKey, String defaultValue) {
        return (System.getProperty(propertyKey) == null) ? defaultValue : System.getProperty(propertyKey);
    }

    static Integer propertyValue(String propertyKey, Integer defaultValue) {
        return (System.getProperty(propertyKey) == null) ? defaultValue : Integer.valueOf(System.getProperty(propertyKey));
    }

}
