package com.huflit.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.huflit.dto.QuestionTypeDto;
import com.huflit.entity.QuestionType;
import com.huflit.repository.QuestionTypeRepository;
import com.huflit.service.QuestionTypeService;

@Service
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class QuestionTypeServiceImpl implements QuestionTypeService {

	@Autowired
	private QuestionTypeRepository questionTypeRepository;
	
	@Override
	public List<QuestionTypeDto> findAll() {
		List<QuestionTypeDto> dtos = new ArrayList<QuestionTypeDto>();
		
		for (QuestionType entity : questionTypeRepository.findByStatusTrue()) {
			
			dtos.add(new QuestionTypeDto(entity.getId(), entity.getName(), entity.getIcon(), entity.getCategoryId()));
		}
		
		return dtos;
	}

	@Override
	public QuestionTypeDto findById(int id) {
		
		QuestionType entity = questionTypeRepository.getById(id);
		
		return new QuestionTypeDto(entity.getId(), entity.getName(), entity.getIcon(), entity.getCategoryId());
	}

	@Override
	public void update(QuestionTypeDto dto) {
		
		if(questionTypeRepository.existsById(dto.getId())) {
			
			QuestionType entity = new QuestionType(dto.getId(), dto.getName(), dto.getIcon(), dto.getCategoryId());
			
			questionTypeRepository.save(entity);
		}

	}

	@Override
	public void add(QuestionTypeDto dto) {

		QuestionType entity = new QuestionType(dto.getName(), dto.getIcon(), dto.getCategoryId(), true);
		
		questionTypeRepository.save(entity);
		
	}

	@Override
	public void delete(int id) {

		questionTypeRepository.deleteById(id);
		
	}

	@Override
	public List<QuestionTypeDto> findAllStatusFalse() {
		List<QuestionTypeDto> dtos = new ArrayList<QuestionTypeDto>();
		
		for (QuestionType entity : questionTypeRepository.findByStatusFalse()) {
			
			dtos.add(new QuestionTypeDto(entity.getId(), entity.getName(), entity.getIcon(), entity.getCategoryId()));
		}
		
		return dtos;
	}

	@Override
	public QuestionTypeDto findByIdAndStatusTrue(int id) throws Exception {
		QuestionType entity = questionTypeRepository.findByIdAndStatusTrue(id);
		
		return new QuestionTypeDto(entity.getId(), entity.getName(), entity.getIcon(), entity.getCategoryId());
	}

	@Override
	public void addByUser(QuestionTypeDto dto) {

		QuestionType entity = new QuestionType(dto.getName(), dto.getIcon(), dto.getCategoryId(), false);
		
		questionTypeRepository.save(entity);
		
	}

	@Override
	public void approve(int id) {
		QuestionType entity = questionTypeRepository.getById(id);
		
		entity.setStatus(true);
		
		questionTypeRepository.save(entity);
		
	}

}
