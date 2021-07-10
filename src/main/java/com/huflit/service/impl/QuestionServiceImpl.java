package com.huflit.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.huflit.dto.AnswerDto;
import com.huflit.dto.QuestionDto;
import com.huflit.dto.QuestionPackageDto;
import com.huflit.entity.Answer;
import com.huflit.entity.Question;
import com.huflit.repository.AnswerRepository;
import com.huflit.repository.QuestionRepository;
import com.huflit.service.QuestionService;

@Service
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Override
	public void add(QuestionPackageDto pkgDto) {
		Question entity = new Question(pkgDto.getContent(), pkgDto.getQuestionTypeId(), false);
		int number = questionRepository.saveAndFlush(entity).getId();
		
		for(AnswerDto aliasDto : pkgDto.getAnswers()) {
			Answer answer = new Answer(aliasDto.getId(), aliasDto.getContent(), aliasDto.isTrue(), number);
			answerRepository.save(answer);
		}
	}
	
	@Override
	public List<QuestionDto> findAll() {
		
		List<QuestionDto> dtos = new ArrayList<QuestionDto>();
		
		for(Question entity : questionRepository.findByStatusTrue()) {
			QuestionDto dto = new QuestionDto(entity.getId(), entity.getContent(), entity.getQuestionTypeId());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public QuestionDto findById(int id) {
		
		Question entity = questionRepository.getById(id);
			
		return new QuestionDto(entity.getId(), entity.getContent(), entity.getQuestionTypeId());
	}
	
	
	@Override
	public void add(QuestionDto dto) {
		Question entity = new Question(dto.getContent(), dto.getQuestionTypeId());
		questionRepository.save(entity);
	}

	@Override
	public void edit(QuestionDto dto) {
		Question entity = new Question(dto.getId(), dto.getContent(), dto.getQuestionTypeId());
		questionRepository.save(entity);
	}

	@Override
	public void delete(int id) {
		questionRepository.deleteById(id);
	}

	@Override
	public List<QuestionPackageDto> findByCategoryId(int id) {
		
		List<QuestionPackageDto> pkgDtos = new ArrayList<QuestionPackageDto>();
		
		for(Question entity : questionRepository.findByCategoryId(id)) {
			QuestionPackageDto pkgDto = new QuestionPackageDto();
			pkgDto.setId(entity.getId());
			pkgDto.setContent(entity.getContent());
//			pkgDto.setExamId(entity.getExamId());
			pkgDto.setQuestionTypeId(entity.getQuestionTypeId());
			
			List<AnswerDto> dtos = new ArrayList<AnswerDto>();
			
			for(Answer a : answerRepository.findByQuestionId(pkgDto.getId())) {
				
				AnswerDto dto = new AnswerDto(a.getId(),a.getContent(), a.getQuestionId(), a.isTrue());
				dtos.add(dto);
			}
			pkgDto.setAnswers(dtos);
			pkgDtos.add(pkgDto);
		}
		return pkgDtos;
	}

	@Override
	public List<QuestionPackageDto> findByQuestionTypeId(int id) {
		List<QuestionPackageDto> pkgDtos = new ArrayList<QuestionPackageDto>();
		
		for(Question entity : questionRepository.findByQuestionTypeId(id)) {
			QuestionPackageDto pkgDto = new QuestionPackageDto();
			pkgDto.setId(entity.getId());
			pkgDto.setContent(entity.getContent());
//			pkgDto.setExamId(entity.getExamId());
			pkgDto.setQuestionTypeId(entity.getQuestionTypeId());
			
			List<AnswerDto> dtos = new ArrayList<AnswerDto>();
			
			for(Answer a : answerRepository.findByQuestionId(pkgDto.getId())) {
				
				AnswerDto dto = new AnswerDto(a.getId(),a.getContent(), a.getQuestionId(), a.isTrue());
				dtos.add(dto);
			}
			pkgDto.setAnswers(dtos);
			pkgDtos.add(pkgDto);
		}
		return pkgDtos;
	}

}
