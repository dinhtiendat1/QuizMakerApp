package com.huflit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huflit.entity.UserExam;

@Repository
public interface UserExamRepository extends JpaRepository<UserExam, Integer> {

	
}
