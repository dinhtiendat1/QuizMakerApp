package com.huflit.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.huflit.dto.UserDetailsDto;
import com.huflit.entity.User;
import com.huflit.repository.RoleRepository;
import com.huflit.repository.UserRepository;

@Service
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;

	UserDetailsServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(email);
		
		if (user == null) {
			throw new UsernameNotFoundException("Email không tồn tại");
		}

		String roleName = roleRepository.getById(user.getRoleId()).getName();
		List<GrantedAuthority> authotiries = new ArrayList<GrantedAuthority>();
		authotiries.add(new SimpleGrantedAuthority(roleName));
		UserDetails userDetails = new UserDetailsDto( user.getId(), 
														user.getRoleId(), 
														user.getEmail(),
														user.getPassword(), 
														authotiries);
		return userDetails;
	}

}
