package com.huflit.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.huflit.dto.GroupDto;
import com.huflit.dto.UserDetailsDto;
import com.huflit.dto.UserDto;
import com.huflit.entity.Group;
import com.huflit.entity.UserGroup;
import com.huflit.entity.UserGroupPK;
import com.huflit.repository.GroupRepository;
import com.huflit.repository.UserGroupRepository;
import com.huflit.service.GroupService;

@Service
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupRepository groupRepository;
	
	@Autowired
	private UserGroupRepository userGroupRepository;
	
	@Override
	public List<GroupDto> findAll() {
		List<GroupDto> dtos = new ArrayList<GroupDto>();
		
		for(Group entity : groupRepository.findAll()) {
			UserDto userDto  = new UserDto(entity.getUser().getId(), entity.getUser().getEmail(), entity.getUser().getFullname(), entity.getUser().getPassword(), entity.getUser().getAvatar(), entity.getUser().getPhone(), entity.getUser().getAddress(), entity.getUser().getRoleId());
			GroupDto dto = new GroupDto(entity.getId(), entity.getName(), entity.getDescription(), entity.getGroupCode(), userDto);
			dtos.add(dto);
		}
		return dtos;
	}
	
	@Override
	public List<GroupDto> findByName(String name) {
		List<GroupDto> dtos = new ArrayList<GroupDto>();
		
		for(Group entity : groupRepository.findByNameContaining(name)) {
			UserDto userDto  = new UserDto(entity.getUser().getId(), entity.getUser().getEmail(), entity.getUser().getFullname(), entity.getUser().getPassword(), entity.getUser().getAvatar(), entity.getUser().getPhone(), entity.getUser().getAddress(), entity.getUser().getRoleId());
			GroupDto dto = new GroupDto(entity.getId(), entity.getName(), entity.getDescription(), entity.getGroupCode(), userDto);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void update(GroupDto dto) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int userId = ((UserDetailsDto) principal).getId();
		
		Group entity = new Group(dto.getId(), dto.getName(), dto.getDescription(), userId, dto.getGroupCode());
		
		groupRepository.save(entity);
	}

	@Override
	public void add(GroupDto dto) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int userId = ((UserDetailsDto) principal).getId();
		
		Group entity = new Group(dto.getName(), dto.getDescription(), userId, dto.getGroupCode());
		
		int id = groupRepository.saveAndFlush(entity).getId();
		UserGroupPK pk = new UserGroupPK(userId, id);
		UserGroup userGroup = new UserGroup(pk);
		userGroupRepository.save(userGroup);
	}

	@Override
	public void delete(int id) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int userId = ((UserDetailsDto) principal).getId();
		
		userGroupRepository.deleteByUserIdAndGroupId(userId, id);
		
		groupRepository.deleteById(id);
		
	}

	@Override
	public GroupDto findById(int id) {
		Group entity = groupRepository.getById(id);
		UserDto userDto  = new UserDto(entity.getUser().getId(), entity.getUser().getEmail(), entity.getUser().getFullname(), entity.getUser().getPassword(), entity.getUser().getAvatar(), entity.getUser().getPhone(), entity.getUser().getAddress(), entity.getUser().getRoleId());
		return new GroupDto(entity.getId(), entity.getName(), entity.getDescription(), entity.getGroupCode(), userDto);
	}

	@Override
	public List<GroupDto> findAllOfMyGroup() {
		List<GroupDto> dtos = new ArrayList<GroupDto>();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int userId = ((UserDetailsDto) principal).getId();
		
		System.out.println(userId);
		
		for(Group entity : groupRepository.findAllOfMyGroup(userId)) {
			UserDto userDto  = new UserDto(entity.getUser().getId(), entity.getUser().getEmail(), entity.getUser().getFullname(), entity.getUser().getPassword(), entity.getUser().getAvatar(), entity.getUser().getPhone(), entity.getUser().getAddress(), entity.getUser().getRoleId());
			GroupDto dto = new GroupDto(entity.getId(), entity.getName(), entity.getDescription(), entity.getGroupCode(), userDto);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<GroupDto> findByNameOfMyGroup(String name) {
		List<GroupDto> dtos = new ArrayList<GroupDto>();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int userId = ((UserDetailsDto) principal).getId();
		
		for(Group entity : groupRepository.findByNameOfMyGroup(userId, name)) {
			UserDto userDto  = new UserDto(entity.getUser().getId(), entity.getUser().getEmail(), entity.getUser().getFullname(), entity.getUser().getPassword(), entity.getUser().getAvatar(), entity.getUser().getPhone(), entity.getUser().getAddress(), entity.getUser().getRoleId());
			GroupDto dto = new GroupDto(entity.getId(), entity.getName(), entity.getDescription(), entity.getGroupCode(), userDto);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void join(int id) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int userId = ((UserDetailsDto) principal).getId();
		
		UserGroupPK pk = new UserGroupPK(userId, id);
		UserGroup userGroup = new UserGroup(pk);
		userGroupRepository.save(userGroup);
		
	}

	@Override
	public void leave(int id) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int userId = ((UserDetailsDto) principal).getId();
		
		userGroupRepository.deleteByUserIdAndGroupId(userId, id);
		
	}

	

}
