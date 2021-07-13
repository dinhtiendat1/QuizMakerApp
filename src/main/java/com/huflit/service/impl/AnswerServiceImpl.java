package com.huflit.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.huflit.dto.AnswerDto;
import com.huflit.entity.Answer;
import com.huflit.repository.AnswerRepository;
import com.huflit.service.AnswerService;

@Service
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class AnswerServiceImpl implements AnswerService{

	@Autowired
	private AnswerRepository answerRepository;
	
	@Override
	public List<AnswerDto> findAll() {
		
		List<AnswerDto> dtos = new ArrayList<AnswerDto>();
		
		for(Answer entity : answerRepository.findAll()) {
			AnswerDto dto = new AnswerDto(entity.getId(), entity.getContent(), entity.getQuestionId(), entity.isTrue());
			
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public AnswerDto findById(int id) {
		
		Answer entity = answerRepository.getById(id);
		
		return new AnswerDto(entity.getId(), entity.getContent(), entity.getQuestionId(), entity.isTrue());
	}

	@Override
	public void add(AnswerDto dto) {
		Answer entity = new Answer(dto.getContent(), dto.isTrue(), dto.getQuestionId());
		
		answerRepository.save(entity);
		
	}

	@Override
	public void edit(AnswerDto dto) {
		Answer entity = new Answer(dto.getId(), dto.getContent(), dto.isTrue(), dto.getQuestionId());
		
		answerRepository.save(entity);
		
	}

	@Override
	public void delete(int id) {
		
		answerRepository.deleteById(id);
		
	}

	@Override
	public List<AnswerDto> findByQuestionId(int id) {
		List<AnswerDto> dtos = new ArrayList<AnswerDto>();
		
		for(Answer entity : answerRepository.findByQuestionId(id)) {
			AnswerDto dto = new AnswerDto(entity.getId(), entity.getContent(), entity.getQuestionId(), entity.isTrue());
			dtos.add(dto);
		}
		return dtos;
	}
}
