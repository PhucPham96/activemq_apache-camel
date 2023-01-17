package com.example.activeMQ.processors.mybatis;

import com.example.activeMQ.entity.Tutorial;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CreateTutorialsRequestProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("CreateTutorialsRequestProcessor");
        List<Tutorial> tutorials = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Tutorial tutorial = new Tutorial();
            tutorial.setDescription("mybatis description" + i);
            tutorial.setTitle("mybatis title " + i);
            tutorial.setPublished(true);
            tutorials.add(tutorial);
        }
        exchange.getIn().setBody(tutorials);
    }
}
