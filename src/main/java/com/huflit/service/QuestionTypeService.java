package com.huflit.service;

import java.util.List;

import com.huflit.dto.QuestionTypeDto;

public interface QuestionTypeService {

	List<QuestionTypeDto> findAll();
	
	List<QuestionTypeDto> findAllStatusFalse();
	
	QuestionTypeDto findById(int id);
	
	QuestionTypeDto findByIdAndStatusTrue(int id) throws Exception;
	
	void update(QuestionTypeDto dto);
	
	void add(QuestionTypeDto dto);
	
	void addByUser(QuestionTypeDto dto);
	
	void delete(int id);
	
	void approve(int id);
}
