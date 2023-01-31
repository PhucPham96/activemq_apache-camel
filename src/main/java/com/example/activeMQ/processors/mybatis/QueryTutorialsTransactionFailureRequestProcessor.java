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
public class QueryTutorialsTransactionFailureRequestProcessor implements Processor {

    private final SqlSessionFactory sqlSessionFactory;

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("QueryTutorialsTransactionFailureRequestProcessor");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TutorialMapper tutorialMapper = sqlSession.getMapper(TutorialMapper.class);
        int inserted = tutorialMapper.insertTutorial(Tutorial.builder().description("test01").published(false).title("title01").build());
        int a = 1 / 0;

        exchange.getIn().setBody(inserted);
    }
}
