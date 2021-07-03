package com.huflit.service;

import java.util.List;

import com.huflit.dto.QuestionDto;
import com.huflit.dto.QuestionPackageDto;

public interface QuestionService {

	List<QuestionDto> findAll();
	
	QuestionDto findById(int id);
	
	List<QuestionPackageDto> findByCategoryId(int id);
	
	List<QuestionPackageDto> findByQuestionTypeId(int id);
	
	void add(QuestionDto dto);
	
	void add(QuestionPackageDto dto);
	
	void edit(QuestionDto dto);
	
	void delete(int id);
}
