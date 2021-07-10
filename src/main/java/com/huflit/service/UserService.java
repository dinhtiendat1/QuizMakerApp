package com.huflit.service;

import java.util.List;

import com.huflit.dto.RegisterDto;
import com.huflit.dto.UserDto;

public interface UserService {

	List<UserDto> findAll();

	UserDto findById(int id);

	void update(int id, UserDto dto);

	void add(RegisterDto dto) throws Exception;
	
	void addAdmin(RegisterDto dto);

	void delete(int id);
}
