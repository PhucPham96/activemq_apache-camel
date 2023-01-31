//package com.example.activeMQ.configurations;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.activemq.pool.PooledConnectionFactory;
//import org.apache.activemq.pool.PooledConnectionFactoryBean;
//import org.apache.camel.component.activemq.ActiveMQComponent;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.annotation.EnableJms;
//import org.springframework.jms.connection.CachingConnectionFactory;
//import org.springframework.jms.connection.JmsTransactionManager;
//import org.springframework.jms.core.JmsTemplate;
//
//@Configuration
////@EnableJms
//public class ActiveMQConfig {
//
//
//    @Bean
//    public ActiveMQConnectionFactory activeMQConnectionFactory() {
//        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
//        activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
//        activeMQConnectionFactory.setUseAsyncSend(true);
//        activeMQConnectionFactory.setTrustAllPackages(true);
//        return activeMQConnectionFactory;
//    }
//
//    @Bean
//    public JmsTemplate jmsTemplate() {
//        JmsTemplate jmsTemplate = new JmsTemplate(new CachingConnectionFactory(activeMQConnectionFactory()));
//        jmsTemplate.setDeliveryPersistent(false);
//        return jmsTemplate;
//    }
//
//    @Bean
//    public PooledConnectionFactory pooledConnectionFactory() {
//        PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
//        pooledConnectionFactory.setConnectionFactory(activeMQConnectionFactory());
//        pooledConnectionFactory.setMaxConnections(8);
//        return pooledConnectionFactory;
//    }
//
//    @Bean
//    public JmsTransactionManager jmsTransactionManager() {
//        JmsTransactionManager jmsTransactionManager = new JmsTransactionManager();
//        jmsTransactionManager.setConnectionFactory(pooledConnectionFactory());
//        return jmsTransactionManager;
//    }
//
//    @Bean
//    public ActiveMQComponent activeMQComponent() {
//        ActiveMQComponent activeMQComponent = new ActiveMQComponent();
//        activeMQComponent.setConnectionFactory(pooledConnectionFactory());
//        activeMQComponent.setTransacted(true);
//        activeMQComponent.setTransactionManager(jmsTransactionManager());
//        return activeMQComponent;
//    }
//}
