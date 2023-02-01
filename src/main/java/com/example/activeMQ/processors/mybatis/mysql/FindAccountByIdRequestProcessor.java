package com.example.activeMQ.processors.mybatis.mysql;

import com.example.activeMQ.entity.Account;
import com.example.activeMQ.entity.Tutorial;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FindAccountByIdRequestProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("FindAccountByIdRequestProcessor");
        Long id = exchange.getIn().getBody(Long.class);
        exchange.getIn().setBody(Account.builder().id(id).build());
    }
}
