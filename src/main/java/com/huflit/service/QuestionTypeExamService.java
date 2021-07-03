package com.huflit.service;

import java.util.List;

import com.huflit.dto.QuestionTypeExamDto;

public interface QuestionTypeExamService {

	List<QuestionTypeExamDto> findAll();
	
	QuestionTypeExamDto findById(int id);
	
	void add(QuestionTypeExamDto dto);
	
	void edit(QuestionTypeExamDto dto);
	
	void delete(int id);
}
