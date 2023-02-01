package com.example.activeMQ.processors.mybatis.procedure;

import com.example.activeMQ.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GetPersonAddressResponseProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("GetPersonAddressResponseProcessor");
        List<Object> persons = exchange.getIn().getBody(List.class);
        log.info("List size: {}", persons.size());
    }
}
