package com.huflit.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huflit.dto.CategoryDto;
import com.huflit.dto.QuestionTypeDto;
import com.huflit.service.QuestionTypeService;
import com.huflit.service.impl.QuestionTypeServiceImpl;

@RestController
@Scope("prototype")
@RequestMapping("api/admin/question-types")
public class AdminQuestionTypeController {

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
	
	@PostMapping("")
	public Object post(@RequestBody QuestionTypeDto body) {
		try {
			questionTypeService.add(body);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{id}")
	public Object get(@PathVariable("id") int id) {
		try {
			QuestionTypeDto dto = questionTypeService.findById(id);
			return new ResponseEntity<Object>(dto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/{id}")
	public Object put(@PathVariable("id") int id, @RequestBody QuestionTypeDto dto) {
		try {
			questionTypeService.update(dto);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{id}")
	public Object delete(@PathVariable("id") int id) {
		try {
			questionTypeService.delete(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/approve/{id}")
	public Object put(@PathVariable("id") int id) {
		try {
			questionTypeService.approve(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

}
