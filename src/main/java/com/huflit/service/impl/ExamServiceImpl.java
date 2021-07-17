package com.huflit.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.huflit.dto.CategoryDto;
import com.huflit.dto.ExamDto;
import com.huflit.dto.ExamPackageDto;
import com.huflit.dto.QuestionPackageDto;
import com.huflit.entity.Exam;
import com.huflit.entity.UserExam;
import com.huflit.entity.UserExamPK;
import com.huflit.repository.ExamRepository;
import com.huflit.repository.UserExamRepository;
import com.huflit.service.ExamService;
import com.huflit.dto.UserDetailsDto;

@Service
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamRepository examRepository;
	
	@Autowired
	private UserExamRepository userExamRepository;
	
	@Override
	public List<ExamDto> findAll() {
		
		List<ExamDto> dtos = new ArrayList<ExamDto>();
		ExamDto dto = null;
		CategoryDto cateDto = null;
		
		for (Exam entity : examRepository.findAll()) {
			cateDto = new CategoryDto(entity.getCategoryId(), entity.getCategory().getName(), entity.getCategory().getIcon());
			dto = new ExamDto(entity.getId(), entity.getTitle(), entity.getTime(), cateDto, entity.getLastUpdate(), entity.getCreateDate());

			dtos.add(dto);
		}
		
		return dtos;
	}

	@Override
	public ExamDto findById(int id) {
		Exam entity = examRepository.getById(id);
		ExamDto dto = null;
		CategoryDto cateDto = null;
		cateDto = new CategoryDto(entity.getCategoryId(), entity.getCategory().getName(), entity.getCategory().getIcon());
		dto = new ExamDto(entity.getId(), entity.getTitle(), entity.getTime(), cateDto, entity.getLastUpdate(), entity.getCreateDate());
		return dto;
	}

	@Override
	public void add(ExamDto dto) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int userId = ((UserDetailsDto) principal).getId();
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
		String strDate = formatter.format(date);
		System.out.println(strDate);
		Exam entity = new Exam(dto.getTitle(), dto.getTime(), dto.getCategory().getId(), strDate, strDate);
		
		int examId = examRepository.saveAndFlush(entity).getId();
		UserExamPK userExamPK = new UserExamPK(userId, examId, 0);
		UserExam userExam = new UserExam(userExamPK, 0);
		userExamRepository.save(userExam);
	}
	
	@Override
	public void add(ExamPackageDto dto) {
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		int userId = ((UserDetailsDto) principal).getId();
//		Date date = new Date();
//		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
//		String strDate = formatter.format(date);
//		System.out.println(strDate);
//		Exam entity = new Exam(dto.getTitle(), dto.getTime(), dto.getCategory().getId(), strDate, strDate);
//		
//		int examId = examRepository.saveAndFlush(entity).getId();
//		UserExamPK userExamPK = new UserExamPK(userId, examId, 0);
//		UserExam userExam = new UserExam(userExamPK, 0);
//		userExamRepository.save(userExam);
//		
//		for(QuestionPackageDto)
	}

	@Override
	public void edit(ExamDto dto) {
		// TODO Auto-generated method stub     
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ExamDto> findByGroupId(int groupId) {
		List<ExamDto> dtos = new ArrayList<ExamDto>();
		ExamDto dto = null;
		CategoryDto cateDto = null;
		System.out.println(examRepository.findByGroupId(groupId));
		for(Exam entity : examRepository.findByGroupId(groupId)) {
			System.out.println(entity.getId());
			cateDto = new CategoryDto(entity.getCategoryId(), entity.getCategory().getName(), entity.getCategory().getIcon());
			dto = new ExamDto(entity.getId(), entity.getTitle(), entity.getTime(), cateDto, entity.getLastUpdate(), entity.getCreateDate());
			
			dtos.add(dto);
		}
		
		return dtos;
	}

}
