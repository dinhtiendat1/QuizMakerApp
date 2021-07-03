package com.huflit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huflit.entity.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer>{
	

}
