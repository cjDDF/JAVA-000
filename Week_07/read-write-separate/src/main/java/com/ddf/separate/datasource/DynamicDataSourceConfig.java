package com.ddf.separate.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置多数据源
 * @author xiaohe
 * @version V1.0.0
 */
@Configuration
public class DynamicDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.master")
    public DataSource masterDaraSource(){

        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.slave1")
    public DataSource slave1DaraSource(){

        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.slave2")
    public DataSource slave2DaraSource(){

        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource masterDaraSource, DataSource slave1DaraSource,DataSource slave2DaraSource) {
        Map<Object, Object> targetDataSources = new HashMap<>(5);
        targetDataSources.put(DataSourceNames.MASTER, masterDaraSource);
        targetDataSources.put(DataSourceNames.SLAVE+1, slave1DaraSource);
        targetDataSources.put(DataSourceNames.SLAVE+2, slave2DaraSource);

        return new DynamicDataSource(masterDaraSource, targetDataSources);
    }

}

