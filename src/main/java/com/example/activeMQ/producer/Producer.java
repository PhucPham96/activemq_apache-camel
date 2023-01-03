package com.example.activeMQ.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Producer {

    private final JmsTemplate jmsTemplate;


    public void sendMessage(String message) {
        jmsTemplate.convertAndSend("phuc", message);
    }
}
