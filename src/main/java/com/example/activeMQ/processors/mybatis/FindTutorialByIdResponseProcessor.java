package com.example.activeMQ.processors.mybatis;

import com.example.activeMQ.entity.Tutorial;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FindTutorialByIdResponseProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("FindTutorialByIdResponseProcessor");
        Tutorial tutorial = exchange.getIn().getBody(Tutorial.class);
        log.info("Tutorial Response: {}", new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(tutorial));
    }
}
