package com.huflit.service.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.huflit.service.AuthService;
import com.huflit.dto.LoginDto;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public String login(LoginDto loginDto) {
		Authentication authentication = new UsernamePasswordAuthenticationToken(loginDto.getEmail(),
				loginDto.getPassword());
		authenticationManager.authenticate(authentication);

		// Tao token
		Date nowDate = new Date();
		String token = Jwts.builder().setSubject(loginDto.getEmail()).setIssuedAt(nowDate)
				.setExpiration(new Date(nowDate.getTime() + 864000000L))
				.signWith(SignatureAlgorithm.HS512, "datdinh").compact();

		return token;
	}
}
