package com.huflit.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.huflit.dto.QuestionTypeDto;
import com.huflit.service.QuestionTypeService;

@Service
@Scope("prototype")
public class QuestionTypeExamServiceImpl implements QuestionTypeService{

	@Override
	public List<QuestionTypeDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionTypeDto findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(QuestionTypeDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(QuestionTypeDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
