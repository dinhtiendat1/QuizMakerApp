package com.huflit.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
