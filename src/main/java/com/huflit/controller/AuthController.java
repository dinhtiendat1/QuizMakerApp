package com.huflit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huflit.dto.EditPasswordDto;
import com.huflit.dto.LoginDto;
import com.huflit.dto.LoginRtnDto;
import com.huflit.dto.RegisterDto;
import com.huflit.service.AuthService;
import com.huflit.service.UserService;
import com.huflit.dto.UserDto;
import com.huflit.dto.UserPackageDto;

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
	
	@PostMapping("/login")
	public Object post(@RequestBody LoginDto loginDto) {
		try {
			String token = authService.login(loginDto);
			UserPackageDto user = userService.findByEmail(loginDto.getEmail());
			
			LoginRtnDto rtnDto = new LoginRtnDto(token, user);
			return new ResponseEntity<Object>(rtnDto, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/register")
	public Object post(@RequestBody RegisterDto dto) {
		try {
			userService.add(dto);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/password")
	public Object post(@RequestBody EditPasswordDto dto) {
		try {
			userService.editPassword(dto);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{email}")
	public Object get(@PathVariable("email") String email) {
		try {
			System.out.println(email);
			int number = userService.countByEmail(email);
			return new ResponseEntity<Object>(number, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}
