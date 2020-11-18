package com.ddf.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.List;

@EnableConfigurationProperties(Klass.class)
@ConfigurationProperties(prefix = "klass")
@Data
public class Klass {

    List<Student> students;

    public void dong() {
        System.out.println(this.getStudents());
    }

}
