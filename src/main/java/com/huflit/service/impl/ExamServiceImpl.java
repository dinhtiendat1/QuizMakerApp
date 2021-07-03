package com.huflit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.huflit.dto.ExamDto;
import com.huflit.entity.Exam;
import com.huflit.entity.UserExam;
import com.huflit.entity.UserExamPK;
import com.huflit.repository.ExamRepository;
import com.huflit.repository.UserExamRepository;
import com.huflit.service.ExamService;
import com.huflit.dto.UserDetailsDto;

@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamRepository examRepository;
	
	@Autowired
	private UserExamRepository userExamRepository;
	
	@Override
	public List<ExamDto> findAll() {
		
		List<ExamDto> dtos = new ArrayList<ExamDto>();
		
		for (Exam entity : examRepository.findAll()) {
			ExamDto dto = new ExamDto(entity.getId(), entity.getTitle(), entity.getTime(), entity.getCategoryId(), entity.getLastUpdate());
			dtos.add(dto);
		}
		
		return dtos;
	}

	@Override
	public ExamDto findById(int id) {
		Exam entity = examRepository.getById(id);
		
		return new ExamDto(entity.getId(), entity.getTitle(), entity.getTime(), entity.getCategoryId(), entity.getLastUpdate());
	}

	@Override
	public void add(ExamDto dto) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int userId = ((UserDetailsDto) principal).getId();

		Exam entity = new Exam(dto.getTitle(), dto.getTime(), dto.getCategoryId(), dto.getLastUpdate());
		
		int examId = examRepository.saveAndFlush(entity).getId();
		UserExamPK userExamPK = new UserExamPK(userId, examId, 0);
		UserExam userExam = new UserExam(userExamPK, 0);
		userExamRepository.save(userExam);
	}

	@Override
	public void edit(ExamDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
