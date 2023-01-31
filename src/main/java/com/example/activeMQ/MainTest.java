package com.example.activeMQ;

import com.example.activeMQ.entity.Tutorial;
import com.example.activeMQ.mapper.TutorialMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Transactional
public class MainTest {

    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        TutorialMapper tutorialMapper = sqlSession.getMapper(TutorialMapper.class);

        try {
            int inserted = tutorialMapper.insertTutorial(Tutorial.builder().description("test01").published(false).title("title01").build());
            int inserted2 = tutorialMapper.insertTutorials(List.of(Tutorial.builder().id(1L).description("test01").published(false).title("title01").build()));
            System.out.println("Insert: " + inserted);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        }

        sqlSession.close();
    }
}