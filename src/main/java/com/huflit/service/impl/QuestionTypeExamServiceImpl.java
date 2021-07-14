package com.huflit.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.huflit.dto.QuestionTypeDto;
import com.huflit.dto.QuestionTypeExamDto;
import com.huflit.service.QuestionTypeExamService;
import com.huflit.service.QuestionTypeService;

@Service
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class QuestionTypeExamServiceImpl implements QuestionTypeExamService{

	@Override
	public List<QuestionTypeExamDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionTypeExamDto findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(QuestionTypeExamDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(QuestionTypeExamDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}



}
