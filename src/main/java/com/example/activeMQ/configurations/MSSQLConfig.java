package com.example.activeMQ.configurations;

import lombok.RequiredArgsConstructor;
import org.apache.camel.component.jpa.JpaComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.transaction.TransactionManager;

//@ImportResource({"classpath:beans/beans-mssql.xml"})
@Configuration
@RequiredArgsConstructor
public class MSSQLConfig {

    private final EntityManagerFactory entityManagerFactory;
    private final PlatformTransactionManager transactionManager;

    @Bean
    public JpaComponent jpa() {
        JpaComponent jpaComponent = new JpaComponent();
        jpaComponent.setEntityManagerFactory(entityManagerFactory);
        jpaComponent.setTransactionManager(transactionManager);
        return jpaComponent;
    }

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em
//                = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource());
//        em.setPackagesToScan(new String[] { "com.baeldung.persistence.model" });
//
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        em.setJpaProperties(additionalProperties());
//
//        return em;
//    }
}
