package com.example.activeMQ.configurations;

import com.atomikos.icatch.jta.UserTransactionManager;
import lombok.RequiredArgsConstructor;
import org.apache.camel.component.mybatis.MyBatisComponent;
import org.apache.camel.spring.spi.SpringTransactionPolicy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import javax.transaction.SystemException;

@Configuration
@RequiredArgsConstructor
@MapperScan("com.example.activeMQ.mapper")
public class MSSQLConfig {

    private final DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
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
