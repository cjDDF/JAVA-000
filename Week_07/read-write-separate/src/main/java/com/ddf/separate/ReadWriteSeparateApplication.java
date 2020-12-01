package com.ddf.separate;

import com.ddf.separate.datasource.DynamicDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Import(DynamicDataSourceConfig.class)
public class ReadWriteSeparateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadWriteSeparateApplication.class, args);
	}

}
