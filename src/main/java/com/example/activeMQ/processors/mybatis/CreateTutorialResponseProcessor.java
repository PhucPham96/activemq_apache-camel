package com.example.activeMQ.processors.mybatis;

import com.example.activeMQ.entity.Tutorial;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreateTutorialResponseProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Tutorial tutorial = exchange.getIn().getBody(Tutorial.class);
        log.info("CreateTutorialResponseProcessor: {}", tutorial.getId());
    }
}
