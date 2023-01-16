package com.example.activeMQ.processors.mssql;

import lombok.RequiredArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MSSQLCreateByListObjectRequestProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("MSSQLCreateByListObjectRequestProcessor");
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("description", "description " + UUID.randomUUID());
            map.put("published", true);
            map.put("title", "title " + UUID.randomUUID());
            mapList.add(map);
        }
        exchange.getIn().setBody(mapList);
    }
}
