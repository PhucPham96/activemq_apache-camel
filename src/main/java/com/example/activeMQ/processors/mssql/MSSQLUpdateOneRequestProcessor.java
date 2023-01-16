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
public class MSSQLUpdateOneRequestProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("MSSQLUpdateOneRequestProcessor");
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", 1);
        map.put("description", "description updated" + UUID.randomUUID());
        map.put("published", false);
        map.put("title", "title  updated" + UUID.randomUUID());
        exchange.getIn().setBody(map);
    }
}
