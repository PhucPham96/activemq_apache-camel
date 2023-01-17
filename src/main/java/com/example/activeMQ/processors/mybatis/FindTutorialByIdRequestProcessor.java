package com.example.activeMQ.processors.mybatis;

import com.example.activeMQ.entity.Tutorial;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FindTutorialByIdRequestProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("FindTutorialByIdRequestProcessor");
        exchange.getIn().setBody(Tutorial.builder().id(1L).build());
    }
}
