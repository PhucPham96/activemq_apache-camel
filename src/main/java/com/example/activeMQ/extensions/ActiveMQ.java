package com.example.activeMQ.extensions;

import lombok.Setter;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;

import javax.jms.ConnectionFactory;

@EnableJms
@Setter
public class ActiveMQ extends Connections {

//    @Value(value = "${spring.activemq.broker-url}")
    private String host;

    @Override
    protected ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(host);
        activeMQConnectionFactory.setUseAsyncSend(true);
        activeMQConnectionFactory.setTrustAllPackages(true);
        activeMQConnectionFactory.setDispatchAsync(false);
        activeMQConnectionFactory.setOptimizeAcknowledge(true);
        activeMQConnectionFactory.setAlwaysSessionAsync(true);

        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setTargetConnectionFactory(activeMQConnectionFactory);
        cachingConnectionFactory.setSessionCacheSize(500);
        cachingConnectionFactory.setReconnectOnException(true);

        return cachingConnectionFactory;
    }
}
