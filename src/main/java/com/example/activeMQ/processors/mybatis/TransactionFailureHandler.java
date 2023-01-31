package com.example.activeMQ.processors.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TransactionFailureHandler implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("TransactionFailureHandler: ");
    }
}
