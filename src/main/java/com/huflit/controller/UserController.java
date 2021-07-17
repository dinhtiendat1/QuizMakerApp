package com.huflit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huflit.dto.QuestionDto;
import com.huflit.dto.RoleDto;
import com.huflit.dto.UpdateUserDto;
import com.huflit.service.QuestionService;
import com.huflit.service.UserService;

@RestController
@Scope("prototype")
@RequestMapping("api/users")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PutMapping("")
	public Object put(@RequestBody UpdateUserDto dto) {
		try {
			userService.update(dto);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
}
