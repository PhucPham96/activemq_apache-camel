package com.example.activeMQ.configurations;

import lombok.RequiredArgsConstructor;
import org.apache.camel.component.mybatis.MyBatisComponent;
import org.apache.camel.spring.spi.SpringTransactionPolicy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
@MapperScan("com.example.activeMQ.mapper")
public class MSSQLConfig {

    private final DataSource dataSource;

    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        return sqlSessionFactory.getObject();
    }

    @Bean
    public MyBatisComponent myBatisComponent() throws Exception {
        MyBatisComponent myBatisComponent = new MyBatisComponent();
        myBatisComponent.setSqlSessionFactory(sqlSessionFactory());
        return myBatisComponent;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    public SpringTransactionPolicy springTransactionPolicy() {
        SpringTransactionPolicy springTransactionPolicy = new SpringTransactionPolicy();
        springTransactionPolicy.setTransactionManager(dataSourceTransactionManager());
        springTransactionPolicy.setPropagationBehaviorName("PROPAGATION_REQUIRED");
        return springTransactionPolicy;
    }
}
