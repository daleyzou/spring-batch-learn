package com.daleyzou.file2db.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * DataSourceConfig
 * @description TODO
 * @author daleyzou
 * @date 2021年03月06日 2:42 下午
 */
@Configuration
public class DataSourceConfig {
    @Bean("dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource batchDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean("targetDataSource")
    @ConfigurationProperties(prefix = "spring.target-datasource")
    public DataSource targetDataSource(){
        return DataSourceBuilder.create().build();
    }
}
