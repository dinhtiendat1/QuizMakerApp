package com.huflit.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.huflit.dto.GroupMessageDto;
import com.huflit.dto.GroupMessagePackageDto;
import com.huflit.dto.UserDetailsDto;
import com.huflit.entity.GroupMessage;
import com.huflit.repository.GroupMessageRepository;
import com.huflit.service.GroupMessageService;

@Service
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class GroupMessageServiceImpl implements GroupMessageService{

	@Autowired
	private GroupMessageRepository groupMessageRepository;
	
	@Override
	public List<GroupMessageDto> findAllOfGroup(int groupId) {
		List<GroupMessageDto> dtos = new ArrayList<GroupMessageDto>();
		GroupMessageDto dto = null;
		
		for(GroupMessage entity : groupMessageRepository.findByGroupId(groupId)) {
			dto = new GroupMessageDto(entity.getId(), entity.getContent(), entity.getUserId(), entity.getGroupId(), entity.getDate());
			dtos.add(dto);
		}
		
		return dtos;
	}

	@Override
	public void add(GroupMessageDto dto) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
		String strDate = formatter.format(date);
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int userId = ((UserDetailsDto) principal).getId();
		
		GroupMessage entity = new GroupMessage(dto.getContent(), strDate, dto.getGroupId(), userId);
		
		groupMessageRepository.save(entity);
		
	}

}
