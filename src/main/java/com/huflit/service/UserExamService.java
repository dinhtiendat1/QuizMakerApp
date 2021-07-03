package com.huflit.service;

import java.util.List;

import com.huflit.dto.UserExamDto;

public interface UserExamService {

	List<UserExamDto> findAll();
	
	UserExamDto findById(int id);
	
	void add(UserExamDto dto);
	
	void edit(UserExamDto dto);
	
	void delete(int id);
}
