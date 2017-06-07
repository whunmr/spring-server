package com.dddsample.ec2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

/**
 * Created by azhu on 30/05/2017.
 */
@Configuration
@PropertySource("classpath:db-config.properties")
public class Configurations {
    @Bean
    public DataSource dataSource() {

        // Create an in-memory H2 relational database containing some demo
        // accounts.
        DataSource dataSource = (new EmbeddedDatabaseBuilder()).addScript("classpath:db/schema.sql").build();


        return dataSource;
    }
}
