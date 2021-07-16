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

import com.huflit.dto.GroupDto;
import com.huflit.dto.GroupMessageDto;
import com.huflit.dto.GroupMessagePackageDto;
import com.huflit.service.GroupMessageService;

@RestController
@Scope("prototype")
@RequestMapping("api/groupMessages")
public class GroupMessageController {

	@Autowired
	private GroupMessageService groupMessageService;
	
	@GetMapping("/{id}")
	public Object get(@PathVariable("id") int groupId) {
		try {
			List<GroupMessageDto> dtos = groupMessageService.findAllOfGroup(groupId);
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("")
	public Object post(@RequestBody GroupMessageDto body) {
		String message;
		try {
			groupMessageService.add(body);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		return new ResponseEntity<Object>(message ,HttpStatus.BAD_REQUEST);
	}
	
}
