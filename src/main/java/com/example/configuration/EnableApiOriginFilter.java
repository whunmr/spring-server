package com.example.configuration;

import io.swagger.api.ApiOriginFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnableApiOriginFilter {
    @Bean
    public FilterRegistrationBean dawsonApiFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ApiOriginFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }
}
