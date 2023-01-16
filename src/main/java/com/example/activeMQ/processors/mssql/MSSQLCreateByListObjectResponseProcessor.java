package com.example.activeMQ.processors.mssql;

import lombok.RequiredArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MSSQLCreateByListObjectResponseProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        List<Object> objects = exchange.getIn().getBody(List.class);
        System.out.println("MSSQLCreateByListObjectResponseProcessor:" + objects.size());

    }
}
