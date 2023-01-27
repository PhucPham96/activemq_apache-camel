package com.example.activeMQ.processors.mybatis;

import com.example.activeMQ.entity.Tutorial;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DeleteTutorialsRequestProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String idDeletedStrings = exchange.getIn().getBody(String.class);
        log.info("DeleteTutorialsRequestProcessor");
        String[] idDeletedStringArrays = idDeletedStrings.split(",");
        int idsLength = idDeletedStringArrays.length;
        List<Tutorial> tutorials = new ArrayList<>();
        for (int i = 0; i < idsLength; i++) {
            Tutorial tutorial = new Tutorial();
            tutorial.setId(Long.valueOf(idDeletedStringArrays[i].trim()));
            tutorials.add(tutorial);
        }
        exchange.getIn().setBody(tutorials);
    }
}
