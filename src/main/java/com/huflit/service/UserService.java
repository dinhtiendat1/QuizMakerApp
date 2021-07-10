package com.huflit.service;

import java.util.List;

import com.huflit.dto.EditPasswordDto;
import com.huflit.dto.RegisterDto;
import com.huflit.dto.UserDto;
import com.huflit.dto.UserPackageDto;

public interface UserService {

	List<UserDto> findAll();

	UserDto findById(int id);
	
	UserPackageDto findByEmail(String email);

	void update(int id, UserDto dto);

	void add(RegisterDto dto) throws Exception;
	
	void addAdmin(RegisterDto dto);

	void delete(int id);
	
	int countByEmail(String email);
	
	void editPassword(EditPasswordDto dto);
}
