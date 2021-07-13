package com.huflit.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.huflit.dto.UserExamDto;
import com.huflit.service.UserExamService;

@Service
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class UserExamServiceImpl implements UserExamService{

	@Override
	public List<UserExamDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserExamDto findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(UserExamDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(UserExamDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
