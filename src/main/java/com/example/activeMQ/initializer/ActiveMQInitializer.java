package com.example.activeMQ.initializer;

import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@Component
@ImportResource("classpath:beans/beans-activemq.xml")
public class ActiveMQInitializer {
}
