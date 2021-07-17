package com.huflit.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.huflit.dto.QuestionTypeDto;
import com.huflit.dto.QuestionTypeExamDto;
import com.huflit.entity.ExamQuestion;
import com.huflit.entity.ExamQuestionPK;
import com.huflit.entity.QuestionType;
import com.huflit.entity.QuestionTypeExam;
import com.huflit.entity.QuestionTypeExamPK;
import com.huflit.repository.ExamQuestionRepository;
import com.huflit.repository.QuestionRepository;
import com.huflit.repository.QuestionTypeExamRepository;
import com.huflit.service.QuestionTypeExamService;
import com.huflit.service.QuestionTypeService;

@Service
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class QuestionTypeExamServiceImpl implements QuestionTypeExamService{

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private QuestionTypeExamRepository questionTypeExamRepository;
	
	@Autowired
	private ExamQuestionRepository examQuestionRepository;
	
//	@Override
//	public List<QuestionTypeExamDto> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public QuestionTypeExamDto findById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void add(QuestionTypeExamDto dto) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void edit(QuestionTypeExamDto dto) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void delete(int id) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void addQuestion(List<QuestionTypeExamDto> dtos) {
		
		QuestionTypeExamPK questionTypeExamPK = null;
		QuestionTypeExam questionTypeExam = null;
		ExamQuestionPK examQuestionPK = null;
		ExamQuestion examQuestion = null;
		
		for(QuestionTypeExamDto dto : dtos) {
			questionTypeExamPK = new QuestionTypeExamPK(dto.getQuestionTypeId(), dto.getExamId());
			questionTypeExam = new QuestionTypeExam(questionTypeExamPK, dto.getNumber());
			
			questionTypeExamRepository.save(questionTypeExam);
			
			System.out.println(questionRepository.findRandom(dto.getQuestionTypeId(), dto.getNumber()));
			System.out.println();
			for(int id : questionRepository.findRandom(dto.getQuestionTypeId(), dto.getNumber())) {
				examQuestionPK = new ExamQuestionPK(dto.getExamId(), id);
				examQuestion = new ExamQuestion(examQuestionPK);
				
				examQuestionRepository.save(examQuestion);
			}
		}
		
	}

}
