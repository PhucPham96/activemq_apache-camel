//package com.example.activeMQ.configurations;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.annotation.EnableJms;
//import org.springframework.jms.connection.CachingConnectionFactory;
//import org.springframework.jms.core.JmsTemplate;
//
//@Configuration
//@EnableJms
//public class ActiveMQConfig {
//
//    @Value(value = "${spring.activemq.broker-url}")
//    String brokerUrl;
//
//    @Bean
//    public ActiveMQConnectionFactory activeMQConnectionFactory() {
//        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
//        activeMQConnectionFactory.setBrokerURL(brokerUrl);
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
//}
