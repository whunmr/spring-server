package com.dddsample.rds.interfaces.filter;

import io.swagger.api.ApiOriginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
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

