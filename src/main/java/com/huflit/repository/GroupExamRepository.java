package com.huflit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huflit.entity.GroupExam;
import com.huflit.entity.GroupMessage;

@Repository
public interface GroupExamRepository extends JpaRepository<GroupExam, Integer>{

}
