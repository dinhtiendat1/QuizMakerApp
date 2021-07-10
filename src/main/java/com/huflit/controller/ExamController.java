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

import com.huflit.dto.ExamDto;
import com.huflit.dto.ExamPackageDto;
import com.huflit.dto.QuestionDto;
import com.huflit.dto.QuestionPackageDto;
import com.huflit.dto.RoleDto;
import com.huflit.service.ExamService;
import com.huflit.service.QuestionService;

@RestController
@Scope("prototype")
@RequestMapping("api/exams")
public class ExamController {

	@Autowired
	private ExamService examService;
	
	@GetMapping("")
	public Object get() {
		try {
			return new ResponseEntity<Object>(examService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("")
	public Object post(@RequestBody ExamDto body) {
		try {
			examService.add(body);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/package")
	public Object postPkg(@RequestBody ExamPackageDto body) {
		try {
//			examService.add(body);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{id}")
	public Object get(@PathVariable("id") int id) {
		try {
			ExamDto dto = examService.findById(id);
			return new ResponseEntity<Object>(dto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
//	
//	@PutMapping("/{id}")
//	public Object put(@PathVariable("id") int id, @RequestBody RoleDto dto) {
//		try {
//			roleService.update(id, dto);
//			return new ResponseEntity<Object>(HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
//	}
//	
//	@DeleteMapping("/{id}")
//	public Object delete(@PathVariable("id") int id) {
//		try {
//			roleService.delete(id);
//			return new ResponseEntity<Object>(HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
//	}
}
