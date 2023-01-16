package com.example.activeMQ.processors.mssql;

import com.example.activeMQ.model.Tutorial;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.sql.SqlConstants;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class MSSQLCreateProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("MSSQLCreateProcessor");
        Tutorial tutorial = new Tutorial();
        tutorial.setDescription("description camel 1");
        tutorial.setPublished(true);
        tutorial.setTitle("title camel 1");
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", tutorial.getId());
        map.put("description", tutorial.getDescription());
        map.put("published", tutorial.getPublished());
        map.put("title", tutorial.getTitle());
        exchange.getIn().setHeader(SqlConstants.SQL_RETRIEVE_GENERATED_KEYS, true);
        exchange.getIn().setHeader(SqlConstants.SQL_GENERATED_COLUMNS, new String[] {"id"});
        exchange.getIn().setBody(map);
    }
}
