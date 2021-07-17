package com.huflit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huflit.entity.ExamQuestion;
import com.huflit.entity.Question;

@Repository
public interface ExamQuestionRepository extends JpaRepository<ExamQuestion, Integer>{

}
