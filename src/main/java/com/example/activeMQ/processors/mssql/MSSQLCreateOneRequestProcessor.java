package com.example.activeMQ.processors.mssql;

import lombok.RequiredArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MSSQLCreateOneRequestProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("MSSQLCreateOneRequestProcessor");
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("description", "description " + UUID.randomUUID());
        map.put("published", true);
        map.put("title", "title " + UUID.randomUUID());
        exchange.getIn().setBody(map);
    }
}
