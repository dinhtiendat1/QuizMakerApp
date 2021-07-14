package com.huflit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.huflit.entity.Category;
import com.huflit.entity.QuestionType;

@Repository
public interface QuestionTypeRepository extends JpaRepository<QuestionType, Integer> {

	List<QuestionType> findByStatusTrue();
	
	List<QuestionType> findByStatusFalse();
	
	@Query("SELECT c FROM QuestionType c "
			+ "WHERE c.id = :id "
			+ "AND c.status = TRUE ")
	QuestionType findByIdAndStatusTrue(@Param("id") Integer id);
	
}
