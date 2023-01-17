package com.example.activeMQ.processors.mybatis;

import com.example.activeMQ.entity.Tutorial;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class UpdateTutorialsRequestProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("UpdateTutorialsRequestProcessor");
        List<Tutorial> tutorials = new ArrayList<>();
        for (long i = 0; i < 3; i++) {
            Tutorial tutorial = new Tutorial();
            tutorial.setId(i);
            tutorial.setPublished(true);
            tutorial.setDescription("updated from UpdateTutorialsRequestProcessor");
            tutorial.setTitle("updated from UpdateTutorialsRequestProcessor");
            tutorials.add(tutorial);
        }
        exchange.getIn().setBody(tutorials);
    }
}
