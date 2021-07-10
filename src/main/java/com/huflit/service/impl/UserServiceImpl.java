package com.huflit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.huflit.dto.RegisterDto;
import com.huflit.dto.UserDto;
import com.huflit.entity.User;
import com.huflit.repository.UserRepository;
import com.huflit.service.UserService;

@Service
@Scope("prototype")
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}
	
	@Override
	public List<UserDto> findAll() {
		
		List<UserDto> dtos = new ArrayList<UserDto>();
		
		for (User entity : userRepository.findAll()) {
			UserDto dto = new UserDto(entity.getId(), entity.getEmail(),  entity.getFullname(), entity.getPassword(), entity.getAvatar(), entity.getPhone(), entity.getAddress(),  entity.getId());
			dtos.add(dto);
		}
		
		return dtos;
	}

	@Override
	public UserDto findById(int id) {
		User entity = userRepository.getById(id);
		UserDto dto = new UserDto(entity.getId(), entity.getEmail(),  entity.getFullname(), entity.getPassword(), entity.getAvatar(), entity.getPhone(), entity.getAddress(),  entity.getId());
		return dto;
	}

	@Override
	public void update(int id, UserDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(RegisterDto dto) throws Exception {
		if(dto.getEmail() == "" || dto.getEmail() == null || dto.getPassword() == "" || dto.getPassword() == null || dto.getFullname() == "" || dto.getFullname() == null) {
			throw new Exception();
		}
		if(userRepository.findByEmail(dto.getEmail()) == null) {
			String hashed = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
			User entity = new User(dto.getEmail(), dto.getFullname(), hashed, "defaultavatar", dto.getPhone(), 3);
			
			userRepository.save(entity);
		} else {
			throw new Exception();
		}
	}
	
	@Override
	public void addAdmin(RegisterDto dto) {
		if(userRepository.findByEmail(dto.getEmail()) == null) {
			String hashed = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
			User entity = new User(dto.getEmail(), dto.getFullname(), hashed, "defaultavatar", dto.getPhone(), 1);
			
			userRepository.save(entity);
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
 
	
}
