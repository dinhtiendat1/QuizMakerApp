package com.huflit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.huflit.entity.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer>{
	
	@Query("SELECT e "
			+ "FROM Exam e "
			+ "JOIN GroupExam ge "
			+ "ON e.id = ge.id.examId "
//			+ "INNER JOIN Group g "
//			+ "ON g.id = ge.id.groupId " 
			+ "AND ge.id.groupId = :groupId ")
	List<Exam> findByGroupId(@Param("groupId") int groupId);
}
