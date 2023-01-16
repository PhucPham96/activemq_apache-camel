package com.example.activeMQ.configurations;

import lombok.RequiredArgsConstructor;
import org.apache.camel.component.sql.SqlComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class MSSQLConfig {

    private final DataSource dataSource;

    @Bean
    public SqlComponent sql() {
        SqlComponent sqlComponent = new SqlComponent();
        sqlComponent.setDataSource(dataSource);
        return sqlComponent;
    }
}
