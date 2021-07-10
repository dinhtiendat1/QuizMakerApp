package com.huflit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.huflit.dto.QuestionPackageDto;
import com.huflit.entity.Answer;
import com.huflit.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{

	@Query("SELECT q FROM Question q "
			+ "INNER JOIN QuestionType qt ON q.questionTypeId = qt.id "
			+ "INNER JOIN Category c ON qt.categoryId = c.id "
			+ "AND c.id = :categoryId ")
	List<Question> findByCategoryId(@Param("categoryId") Integer categoryId);
	
	@Query("SELECT q FROM Question q "
			+ "INNER JOIN QuestionType qt ON q.questionTypeId = qt.id "
			+ "WHERE qt.id = :questionTypeId ")
	List<Question> findByQuestionTypeId(@Param("questionTypeId") Integer questionTypeId);
	
	List<Question> findByStatusTrue();
}
