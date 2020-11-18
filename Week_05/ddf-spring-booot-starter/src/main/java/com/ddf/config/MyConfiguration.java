package com.ddf.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ddf
 */
@Configuration
@ConditionalOnClass
public class MyConfiguration {

    static {
        System.out.println("MyAutoConfiguration init....");
    }

    @Bean
    public School school() {
        return new School();
    }

}
