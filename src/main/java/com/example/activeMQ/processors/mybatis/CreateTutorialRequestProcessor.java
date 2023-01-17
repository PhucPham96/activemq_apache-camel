package com.example.activeMQ.processors.mybatis;

import com.example.activeMQ.entity.Tutorial;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreateTutorialRequestProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("CreateTutorialRequestProcessor");
        Tutorial tutorial = new Tutorial();
        tutorial.setDescription("mybatis description 1");
        tutorial.setTitle("mybatis title 1");
        tutorial.setPublished(true);
        exchange.getIn().setBody(tutorial);
    }
}
