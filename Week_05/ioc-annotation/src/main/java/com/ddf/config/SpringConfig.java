package com.ddf.config;

import com.ddf.bean.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.ddf.component")
public class SpringConfig {

    @Bean
    public TestBean testBean() {
        return new TestBean();
    }
}
