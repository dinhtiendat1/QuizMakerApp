package com.huflit.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.huflit.dto.EditPasswordDto;
import com.huflit.dto.RegisterDto;
import com.huflit.dto.UpdateUserDto;
import com.huflit.dto.UserDetailsDto;
import com.huflit.dto.UserDto;
import com.huflit.dto.UserPackageDto;
import com.huflit.entity.Role;
import com.huflit.entity.User;
import com.huflit.repository.RoleRepository;
import com.huflit.repository.UserRepository;
import com.huflit.service.UserService;

@Service
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	
	@Override
	public List<UserDto> findAll() {
		
		List<UserDto> dtos = new ArrayList<UserDto>();
		
		for (User entity : userRepository.findAll()) {
			UserDto dto = new UserDto(entity.getId(), entity.getEmail(),  entity.getFullname(), entity.getPassword(), entity.getAvatar(), entity.getPhone(), entity.getAddress(),  entity.getRoleId());
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
	public UserPackageDto findByEmail(String email) {
		User entity = userRepository.findByEmail(email);
		UserPackageDto pkgDto = new UserPackageDto(entity.getId(), entity.getEmail(), entity.getFullname(), entity.getPassword(), entity.getAvatar(), entity.getPhone(), entity.getAddress(), entity.getRole());
//		UserDto dto = new UserDto(entity.getId(), entity.getEmail(),  entity.getFullname(), entity.getPassword(), entity.getAvatar(), entity.getPhone(), entity.getAddress(),  entity.getId());
		return pkgDto;
	}

	@Override
	public void update(UpdateUserDto dto) {
		User entity = userRepository.getById(dto.getId());
		
		entity.setAddress(dto.getAddress());
		entity.setAvatar(dto.getAddress());
		entity.setFullname(dto.getFullname());
		entity.setPhone(dto.getPhone());
		
		userRepository.save(entity);
	}

	@Override
	public void add(RegisterDto dto) throws Exception {
//		if(dto.getEmail() == "" || dto.getEmail() == null || dto.getPassword() == "" || dto.getPassword() == null || dto.getFullname() == "" || dto.getFullname() == null) {
//			throw new Exception();
//		}
		if(userRepository.findByEmail(dto.getEmail()) == null) {
			String hashed = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
			User entity = new User(dto.getEmail(), dto.getFullname(), hashed, "defaultavatar", dto.getPhone(), false, 3);
			System.out.println("service //------------");
			System.out.println(entity.getRoleId());
			System.out.println(entity.getId());
			System.out.println(entity.getEmail());
			System.out.println("end service //--------");
			userRepository.save(entity);
		} else {
			throw new Exception();
		}
	}
	
	@Override
	public void addAdmin(RegisterDto dto) {
		if(userRepository.findByEmail(dto.getEmail()) == null) {
			String hashed = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
			User entity = new User(dto.getEmail(), dto.getFullname(), hashed, "defaultavatar", dto.getPhone(), false, 1);
			
			userRepository.save(entity);
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countByEmail(String email) {

		return userRepository.countByEmail(email);
	}

	@Override
	public void editPassword(EditPasswordDto dto) {
		User entity = userRepository.findByEmail(dto.getEmail());
		String hashed = BCrypt.hashpw(dto.getNewPassword(), BCrypt.gensalt());
		entity.setPassword(hashed);
		
		userRepository.save(entity);
	}

	@Override
	public void updatePremium() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int userId = ((UserDetailsDto) principal).getId();
		
		User entity = userRepository.getById(userId);
		
		entity.setPremium(true);
		
		userRepository.save(entity);
		
	}

	@Override
	public void createMockData() {
		
		Role roleEntity = null;		
		roleEntity = new Role("ROLE_ADMIN", "Admin");
		roleRepository.save(roleEntity);
		roleEntity = new Role("ROLE_MOD", "Moderator");
		roleRepository.save(roleEntity);
		roleEntity = new Role("ROLE_USER", "User");
		roleRepository.save(roleEntity);
		
		User userEntity = null;
		for (int i = 0; i < 50; i++) {
			userEntity = new User("ocean" + i + "@gmail.com", "Tao Manh Duc" + 1, "$2a$10$R4po7Pk0dJ1sheCgyEsUWOIeG6ivPk3eScKgJaAaRcipgkDMcohtO", "defaultavatar", "090987123", "Nguy???n V??n Qu?? " + i, 3);
		}
	}
 
	
}
