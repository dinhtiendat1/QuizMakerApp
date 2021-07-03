package com.huflit.service;

import java.util.List;

import com.huflit.dto.CategoryDto;

public interface CategoryService {

	List<CategoryDto> findAll();

	CategoryDto findById(int id);

	void update(int id, CategoryDto dto);

	void add(CategoryDto dto);

	void delete(int id);
}
