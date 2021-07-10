package com.huflit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.huflit.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	List<Category> findByStatusTrue();
	
	List<Category> findByStatusFalse();
	
	@Query("SELECT c FROM Category c "
			+ "WHERE c.id = :id "
			+ "AND c.status = TRUE ")
	Category findByIdAndStatusTrue(@Param("id") Integer id);
	

//	Category findByIdAndStatusTrue(Integer id);
}
