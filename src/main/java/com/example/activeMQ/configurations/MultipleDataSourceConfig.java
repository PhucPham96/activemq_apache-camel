package com.example.activeMQ.configurations;

import com.example.activeMQ.utils.PasswordEncoder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Base64;

@Configuration
public class MultipleDataSourceConfig {

    @Bean(name = "mssqlDataSourceProperties")
    @ConfigurationProperties("spring.datasource.mssql")
    public DataSourceProperties mssqlDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "mssqlDataSource")
    public DataSource mssqlDataSource() {
        return mssqlDataSourceProperties()
                .initializeDataSourceBuilder()
                .password(PasswordEncoder.decode(mssqlDataSourceProperties().getPassword()))
                .build();
    }

    @Bean(name = "mssqlDataSourceProperties2")
    @ConfigurationProperties("spring.datasource.mssql2")
    public DataSourceProperties mssqlDataSourceProperties2() {
        return new DataSourceProperties();
    }

    @Bean(name = "mssqlDataSource2")
    public DataSource mssqlDataSource2() {
        return mssqlDataSourceProperties2()
                .initializeDataSourceBuilder()
                .password(PasswordEncoder.decode(mssqlDataSourceProperties2()
                        .getPassword())).build();
    }

    @Bean(name = "mySQLDataSourceProperties")
    @ConfigurationProperties("spring.datasource.mysql")
    public DataSourceProperties mySQLDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "mySQLDataSource")
    public DataSource mySQLDataSource() {
        return mySQLDataSourceProperties()
                .initializeDataSourceBuilder()
                .password(PasswordEncoder.decode(mySQLDataSourceProperties().getPassword()))
                .build();
    }
}