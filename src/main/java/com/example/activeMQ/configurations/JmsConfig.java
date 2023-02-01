//package com.example.activeMQ.configurations;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.camel.component.activemq.ActiveMQComponent;
//import org.apache.camel.spring.spi.SpringTransactionPolicy;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.connection.JmsTransactionManager;
//
//import javax.jms.ConnectionFactory;
//
//@Configuration
//public class JmsConfig {
//
//    @Bean
//    public ConnectionFactory jmsConnectionFactory() {
//        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
//        factory.setBrokerURL("tcp://localhost:61616");
//        return factory;
//    }
//
//    @Bean
//    public JmsTransactionManager jmsTransactionManager() {
//        return new JmsTransactionManager(jmsConnectionFactory());
//    }
//
//    @Bean
//    public ActiveMQComponent activeMQComponent() {
//        ActiveMQComponent activeMQComponent = new ActiveMQComponent();
//        activeMQComponent.setTransacted(true);
//        activeMQComponent.setTransactionManager(jmsTransactionManager());
//        activeMQComponent.setConnectionFactory(jmsConnectionFactory());
//        return activeMQComponent;
//    }
//
//    @Bean
//    public SpringTransactionPolicy txRequired2() {
//        SpringTransactionPolicy springTransactionPolicy = new SpringTransactionPolicy();
//        springTransactionPolicy.setTransactionManager(jmsTransactionManager());
//        springTransactionPolicy.setPropagationBehaviorName("PROPAGATION_REQUIRED");
//        return springTransactionPolicy;
//    }
//}
