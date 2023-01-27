package com.example.activeMQ.processors.mybatis;

import com.example.activeMQ.entity.Tutorial;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class UpdateTutorialsRequestProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("UpdateTutorialsRequestProcessor");
        String idStrings = exchange.getIn().getBody(String.class);
        String[] idStringArrays = idStrings.split(",");
        int idsLength = idStringArrays.length;
        List<Tutorial> tutorials = new ArrayList<>();
        for (int i = 0; i < idsLength; i++) {
            Tutorial tutorial = new Tutorial();
            tutorial.setId(Long.valueOf(idStringArrays[i].trim()));
            tutorial.setPublished(true);
            tutorial.setDescription("updated from UpdateTutorialsRequestProcessor");
            tutorial.setTitle("updated from UpdateTutorialsRequestProcessor");
            tutorials.add(tutorial);
        }
        exchange.getIn().setBody(tutorials);
    }
}
