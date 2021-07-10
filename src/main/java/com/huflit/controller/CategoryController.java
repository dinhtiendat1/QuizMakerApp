package com.huflit.controller;

import java.util.List;

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
import com.huflit.service.CategoryService;

@RestController
@Scope("prototype")
@RequestMapping("api/categories")
public class CategoryController {

	private CategoryService categoryService;
	
	CategoryController(CategoryService categoryService){
		this.categoryService = categoryService;
	}
	
	@GetMapping("")
	public Object get() {
		try {
			List<CategoryDto> dtos = categoryService.findAll();
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/false")
	public Object getAllStatusFalse() {
		try {
			List<CategoryDto> dtos = categoryService.findAllStatusFalse();
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("")
	public Object post(@RequestBody CategoryDto body) {
		String message;
		try {
			categoryService.addByUser(body);
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
			CategoryDto dto = categoryService.findByIdAndStatusTrue(id);
			return new ResponseEntity<Object>(dto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
}
