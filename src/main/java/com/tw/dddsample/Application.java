package com.tw.dddsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by azhu on 27/05/2017.
 */
@EnableAutoConfiguration
@EnableSwagger2
@ComponentScan(basePackages = {"com.tw.dddsample", "io.swagger", "com.example"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
