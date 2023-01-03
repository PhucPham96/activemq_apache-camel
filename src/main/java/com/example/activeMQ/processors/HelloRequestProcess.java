package com.example.activeMQ.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

@Service
public class HelloRequestProcess implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Hello Request Process");
        exchange.getIn().setBody("Phuc To Set Body");
    }
}
