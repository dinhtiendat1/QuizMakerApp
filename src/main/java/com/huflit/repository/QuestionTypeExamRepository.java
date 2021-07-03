package com.huflit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huflit.entity.QuestionTypeExam;

@Repository
public interface QuestionTypeExamRepository extends JpaRepository<QuestionTypeExam, Integer> {

}
