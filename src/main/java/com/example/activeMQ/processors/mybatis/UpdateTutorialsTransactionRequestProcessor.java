package com.example.activeMQ.processors.mybatis;

import com.example.activeMQ.entity.Tutorial;
import com.example.activeMQ.mapper.TutorialMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UpdateTutorialsTransactionRequestProcessor implements Processor {

    private final SqlSessionFactory sqlSessionFactory;

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("UpdateTutorialsTransactionRequestProcessor");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TutorialMapper tutorialMapper = sqlSession.getMapper(TutorialMapper.class);
        List<Tutorial> tutorials = new ArrayList<>();
        tutorials.add(Tutorial.builder()
                .id(4L)
                .description("updated transaction")
                .title("update transaction")
                .published(true)
                .build());
        int updated = tutorialMapper.updateTutorials(tutorials);

        exchange.getIn().setBody(updated);
    }
}
