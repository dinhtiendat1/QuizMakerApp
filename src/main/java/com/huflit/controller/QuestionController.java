package com.huflit.controller;

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

import com.huflit.dto.QuestionDto;
import com.huflit.dto.QuestionPackageDto;
import com.huflit.dto.RoleDto;
import com.huflit.service.QuestionService;

@RestController
@Scope("prototype")
@RequestMapping("api/questions")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@GetMapping("")
	public Object get() {
		try {
			
			List<QuestionDto> dtos = questionService.findAll();
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("")
	public Object post(@RequestBody QuestionDto body) {
		try {
			questionService.add(body);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/package")
	public Object post(@RequestBody QuestionPackageDto body) {
		try {
			questionService.add(body);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{id}")
	public Object get(@PathVariable("id") int id) {
		try {
			QuestionDto dto = questionService.findById(id);
			return new ResponseEntity<Object>(dto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("")
	public Object put(@RequestBody QuestionDto dto) {
		try {
			questionService.edit(dto);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{id}")
	public Object delete(@PathVariable("id") int id) {
		try {
			questionService.delete(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("categoryId/{id}")
	public Object getByCategoryId(@PathVariable("id") int id) {
		try {
			List<QuestionPackageDto> dtos = questionService.findByCategoryId(id);
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("questionTypeId/{id}")
	public Object getByQuestionTypeId(@PathVariable("id") int id) {
		try {
			List<QuestionPackageDto> dtos = questionService.findByQuestionTypeId(id);
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
}
