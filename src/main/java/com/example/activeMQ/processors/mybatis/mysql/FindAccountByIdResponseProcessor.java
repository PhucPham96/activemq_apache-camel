package com.example.activeMQ.processors.mybatis.mysql;

import com.example.activeMQ.entity.Account;
import com.example.activeMQ.entity.Tutorial;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FindAccountByIdResponseProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("FindAccountByIdResponseProcessor");
        Account account = exchange.getIn().getBody(Account.class);
        log.info("Account Response: {}", new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(account));
        exchange.getIn().setBody(account);
    }
}
