package com.huflit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.huflit.dto.ExamDto;

@Service
public interface ExamService {

	List<ExamDto> findAll();
	
	ExamDto findById(int id);
	
	void add(ExamDto dto);
	
	void edit(ExamDto dto);
	
	void delete(int id);
	
}
