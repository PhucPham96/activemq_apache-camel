package com.example.activeMQ.configurations;

import lombok.RequiredArgsConstructor;
import org.apache.camel.component.mybatis.MyBatisComponent;
import org.apache.camel.spring.spi.SpringTransactionPolicy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
@MapperScan("com.example.activeMQ.mapper")
public class MybatisConfig {

    @Autowired
    @Qualifier("mssqlDataSource")
    private DataSource dataSource;

    @Autowired
    @Qualifier("mssqlDataSource2")
    private DataSource dataSource2;

    @Autowired
    @Qualifier("mySQLDataSource")
    private DataSource mySQlDataSource;

    private final ApplicationContext applicationContext;

    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:SqlMapConfig.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "sqlSessionFactory2")
    public SqlSessionFactory sqlSessionFactory2() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource2);
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:SqlMapConfig.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "mySQLSessionFactory")
    public SqlSessionFactory mySQLSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mySQlDataSource);
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:SqlMapConfig.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "myBatis")
    public MyBatisComponent myBatisComponent() throws Exception {
        MyBatisComponent myBatisComponent = new MyBatisComponent();
        myBatisComponent.setSqlSessionFactory(sqlSessionFactory());
        return myBatisComponent;
    }

    @Bean(name = "myBatis2")
    public MyBatisComponent myBatisComponent2() throws Exception {
        MyBatisComponent myBatisComponent = new MyBatisComponent();
        myBatisComponent.setSqlSessionFactory(sqlSessionFactory2());
        return myBatisComponent;
    }

    @Bean(name = "myBatisMySQL")
    public MyBatisComponent myBatisMySQLComponent() throws Exception {
        MyBatisComponent myBatisComponent = new MyBatisComponent();
        myBatisComponent.setSqlSessionFactory(mySQLSessionFactory());
        return myBatisComponent;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

//    @Bean
//    public UserTransactionManager atomikosTransactionManager()
//            throws SystemException {
//        UserTransactionManager userTransactionManager =
//                new UserTransactionManager();
//        userTransactionManager.setTransactionTimeout(600000);
//        return userTransactionManager;
//    }
//
//    @Bean
//    public PlatformTransactionManager jtaTransactionManager(UserTransactionManager atomikosTransactionManager) {
//        JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
//        jtaTransactionManager.setTransactionManager(atomikosTransactionManager);
//        jtaTransactionManager.setUserTransaction(atomikosTransactionManager);
//        return jtaTransactionManager;
//    }

    @Bean
    public SpringTransactionPolicy txRequired() {
        SpringTransactionPolicy springTransactionPolicy = new SpringTransactionPolicy();
        springTransactionPolicy.setTransactionManager(dataSourceTransactionManager());
        springTransactionPolicy.setPropagationBehaviorName("PROPAGATION_REQUIRED");
        return springTransactionPolicy;
    }

    @Bean
    public SpringTransactionPolicy txRequiresNew() {
        SpringTransactionPolicy springTransactionPolicy = new SpringTransactionPolicy();
        springTransactionPolicy.setTransactionManager(dataSourceTransactionManager());
        springTransactionPolicy.setPropagationBehaviorName("PROPAGATION_REQUIRES_NEW");
        return springTransactionPolicy;
    }

    @Bean
    public SpringTransactionPolicy txMandatory() {
        SpringTransactionPolicy springTransactionPolicy = new SpringTransactionPolicy();
        springTransactionPolicy.setTransactionManager(dataSourceTransactionManager());
        springTransactionPolicy.setPropagationBehaviorName("PROPAGATION_REQUIRES_MANDATORY");
        return springTransactionPolicy;
    }
}
