package com.example.activeMQ.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;


@Service
public class HelloRequestProcess2 implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("HelloRequestProcess2");
    }
}
