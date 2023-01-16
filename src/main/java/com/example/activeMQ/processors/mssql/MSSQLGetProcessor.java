package com.example.activeMQ.processors.mssql;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

@Service
public class MSSQLGetProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("MSSQLGetProcessor: " + exchange.getIn().getBody());
    }
}
