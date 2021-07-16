package com.huflit.service;

import java.util.List;

import com.huflit.dto.GroupMessageDto;
import com.huflit.dto.GroupMessagePackageDto;
import com.huflit.entity.GroupMessage;

public interface GroupMessageService {

	List<GroupMessageDto> findAllOfGroup(int groupId);
	
	void add(GroupMessageDto entity);
}
