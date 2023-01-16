package com.example.activeMQ.repository;

import com.example.activeMQ.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.NamedQuery;
import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}
