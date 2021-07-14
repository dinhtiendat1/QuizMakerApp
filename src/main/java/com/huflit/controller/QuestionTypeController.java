package com.huflit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huflit.dto.CategoryDto;
import com.huflit.dto.QuestionTypeDto;
import com.huflit.service.CategoryService;
import com.huflit.service.QuestionTypeService;

@RestController
@Scope("prototype")
@RequestMapping("api/questionTypes")
public class QuestionTypeController {

	@Autowired
	private QuestionTypeService questionTypeService;
	
	@GetMapping("")
	public Object get() {
		try {
			List<QuestionTypeDto> dtos = questionTypeService.findAll();
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/false")
	public Object getAllStatusFalse() {
		try {
			List<QuestionTypeDto> dtos = questionTypeService.findAllStatusFalse();
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("")
	public Object post(@RequestBody QuestionTypeDto body) {
		String message;
		try {
			questionTypeService.addByUser(body);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		return new ResponseEntity<Object>(message ,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{id}")
	public Object get(@PathVariable("id") int id) {
		try {
			QuestionTypeDto dto = questionTypeService.findByIdAndStatusTrue(id);
			return new ResponseEntity<Object>(dto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}
