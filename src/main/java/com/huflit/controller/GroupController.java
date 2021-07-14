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

import com.huflit.dto.GroupDto;
import com.huflit.service.GroupService;

@RestController
@Scope("prototype")
@RequestMapping("api/groups")
public class GroupController {
	
	@Autowired
	private GroupService groupService;

	@GetMapping("")
	public Object get() {
		try {
			List<GroupDto> dtos = groupService.findAll();
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/name/{name}")
	public Object findByName(@PathVariable("name") String name) {
		try {
			List<GroupDto> dtos = groupService.findByName(name);
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/id/{id}")
	public Object get(@PathVariable("id") int id) {
		try {
			GroupDto dto = groupService.findById(id);
			return new ResponseEntity<Object>(dto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/myGroup")
	public Object getAllOfMyGroup() {
		try {
			List<GroupDto> dtos = groupService.findAllOfMyGroup();
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/myGroup/{name}")
	public Object findByNameOfMyGroup(@PathVariable("name") String name) {
		try {
			List<GroupDto> dtos = groupService.findByNameOfMyGroup(name);
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("")
	public Object post(@RequestBody GroupDto body) {
		String message;
		try {
			groupService.add(body);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		return new ResponseEntity<Object>(message ,HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("")
	public Object put(@RequestBody GroupDto body) {
		String message;
		try {
			groupService.add(body);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		return new ResponseEntity<Object>(message ,HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/join/{groupId}")
	public Object join(@PathVariable("groupId") int id) {
		String message;
		try {
			groupService.join(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		return new ResponseEntity<Object>(message ,HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/leave/{groupId}")
	public Object leave(@PathVariable("groupId") int id) {
		String message;
		try {
			groupService.leave(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		return new ResponseEntity<Object>(message ,HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{id}")
	public Object delete(@PathVariable("id") int id) {
		try {
			groupService.delete(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}
