package com.datasource.operations.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class MultipleDBConfig {

    @Primary
    @Bean(name = "mysql")
    @ConfigurationProperties(prefix = "spring.mysql")
    public DataSource mysql() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "postgres")
    @ConfigurationProperties(prefix = "spring.postgres")
    public DataSource postgres() {
        return DataSourceBuilder.create().build();
    }



}
