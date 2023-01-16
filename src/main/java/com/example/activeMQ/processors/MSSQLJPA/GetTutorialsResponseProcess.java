package com.example.activeMQ.processors.MSSQLJPA;

import com.example.activeMQ.model.Tutorial;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTutorialsResponseProcess implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        List<Tutorial> tutorials = exchange.getIn().getBody(List.class);
        System.out.println("GetTutorialsResponseProcess: " + tutorials.size());
    }
}
