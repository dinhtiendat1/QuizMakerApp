package com.huflit.service;

import java.util.List;

import com.huflit.dto.QuestionTypeDto;

public interface QuestionTypeService {

	List<QuestionTypeDto> findAll();
	
	QuestionTypeDto findById(int id);
	
	void update(QuestionTypeDto dto);
	
	void add(QuestionTypeDto dto);
	
	void delete(int id);
}
