package com.example.activeMQ.processors.mybatis.mysql;

import com.example.activeMQ.entity.Account;
import com.example.activeMQ.entity.Tutorial;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GetAllAccountResponseProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("GetAllAccountResponseProcessor");
        List<Account> accounts = exchange.getIn().getBody(List.class);
        log.info("List size: {}", accounts.size());
    }
}
