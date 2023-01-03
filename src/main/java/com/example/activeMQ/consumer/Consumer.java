package com.example.activeMQ.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "phuc")
    public void listenerMessage(String message) {
        System.out.println("Nhận message: "+ message);
    }

}
