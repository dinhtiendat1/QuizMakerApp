package com.huflit.service;

import java.util.List;

import com.huflit.dto.CategoryDto;

public interface CategoryService {

	List<CategoryDto> findAll();
	
	List<CategoryDto> findAllStatusFalse();

	CategoryDto findById(int id);
	
	CategoryDto findByIdAndStatusTrue(int id) throws Exception;

	void update(int id, CategoryDto dto);

	void add(CategoryDto dto);
	
	void addByUser(CategoryDto dto);

	void delete(int id);
	
	void approve(int id);
}
