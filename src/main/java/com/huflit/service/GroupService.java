package com.huflit.service;

import java.util.List;

import com.huflit.dto.GroupDto;

public interface GroupService {

	List<GroupDto> findAll();
	
	List<GroupDto> findAllOfMyGroup();
	
	void update(GroupDto dto);

	void add(GroupDto dto);

	void delete(int id);
	
	GroupDto findById(int id);
	
	List<GroupDto> findByName(String name);
	
	List<GroupDto> findByNameOfMyGroup(String name);
	
	void join(int id);
	
	void leave(int id);
}
