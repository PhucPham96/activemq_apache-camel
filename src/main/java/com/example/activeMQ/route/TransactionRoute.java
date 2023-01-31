package com.example.activeMQ.route;

import com.example.activeMQ.processors.mybatis.UpdateTutorialsTransactionRequestProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class TransactionRoute extends RouteBuilder {

    final UpdateTutorialsTransactionRequestProcessor updateTutorialsTransactionRequestProcessor;

    @Override
    public void configure() throws Exception {
        log.info("TransactionRoute");
        from("activemq:queue:MybatisTransactionalCodeRequest")
                .transacted("txRequired")
                .process("updateTutorialsTransactionRequestProcessor")
                .to("activemq:queue:MybatisTransactionalCodeResponse")
                .process("queryTutorialsTransactionFailureRequestProcessor");
    }
}
