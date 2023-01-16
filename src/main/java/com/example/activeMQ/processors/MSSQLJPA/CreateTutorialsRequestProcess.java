package com.example.activeMQ.processors.MSSQLJPA;

import com.example.activeMQ.model.Tutorial;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class CreateTutorialsRequestProcess implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("CreateTutorialsRequestProcess: ");
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("description", "desJPA");
        map.put("published", true);
        map.put("title", "titleJPA");
        exchange.getIn().setBody(map);
    }
}
