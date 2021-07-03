package com.huflit.service;

import java.util.List;

import com.huflit.dto.AnswerDto;

public interface AnswerService {

	List<AnswerDto> findAll();
	
	AnswerDto findById(int id);
	
	void add(AnswerDto dto);
	
	void edit(AnswerDto dto);
	
	void delete(int id);
	
	List<AnswerDto> findByQuestionId(int id);
}
