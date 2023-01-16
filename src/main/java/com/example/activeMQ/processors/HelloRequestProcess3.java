package com.example.activeMQ.processors;

import com.example.activeMQ.model.Tutorial;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HelloRequestProcess3 implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        List<Tutorial> tutorials = exchange.getIn().getBody(List.class);
        System.out.println("HelloRequestProcess3: " + tutorials.size());
    }
}
