package com.huflit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huflit.dto.LoginDto;
import com.huflit.dto.RegisterDto;
import com.huflit.service.AuthService;
import com.huflit.service.UserService;
import com.huflit.dto.UserDto;

@RestController
@RequestMapping("api/auth")
@CrossOrigin("*")
public class AuthController {

	private UserService userService;
	private AuthService authService;
	
	public AuthController(UserService userService, AuthService authService) {
		this.userService = userService;
		this.authService = authService;
	}
	
	@PostMapping("login")
	public Object post(@RequestBody LoginDto loginDto) {
		try {
			String token = authService.login(loginDto);
			return new ResponseEntity<Object>(token, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("register")
	public Object post(@RequestBody RegisterDto dto) {
		try {
			userService.add(dto);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}
