package com.example.activeMQ.mapper;

import com.example.activeMQ.entity.Tutorial;
import org.apache.camel.component.mybatis.StatementType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TutorialMapper {

    int insertTutorial(Tutorial tutorial);

    int insertTutorialWithId(Tutorial tutorial);

    List<Tutorial> findAllTutorials();

    Tutorial findById(Long id);

    int insertTutorials(@Param("list") List<Tutorial> tutorials);

    int updateTutorials(@Param("list") List<Tutorial> tutorials);

    int deleteTutorials(@Param("list") List<Tutorial> tutorials);
}
