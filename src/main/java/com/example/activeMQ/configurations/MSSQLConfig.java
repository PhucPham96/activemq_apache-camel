package com.example.activeMQ.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"classpath:beans/beans-mssql.xml"})
@Configuration
public class MSSQLConfig {
}
