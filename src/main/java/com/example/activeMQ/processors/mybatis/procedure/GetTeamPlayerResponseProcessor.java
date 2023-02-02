package com.example.activeMQ.processors.mybatis.procedure;

import com.example.activeMQ.entity.Team;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GetTeamPlayerResponseProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("GetTeamPlayerResponseProcessor");
        List<Team> teams = exchange.getIn().getBody(List.class);
        log.info("List: {}", new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(teams));
    }
}
