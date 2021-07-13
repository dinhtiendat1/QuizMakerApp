package com.huflit.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.huflit.dto.RoleDto;
import com.huflit.repository.RoleRepository;
import com.huflit.service.RoleService;
import com.huflit.entity.Role;

@Service
@Scope("prototype")
@Transactional(rollbackOn = Exception.class)
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<RoleDto> findAll() {
		List<Role> entities = roleRepository.findAll();
		List<RoleDto> dtos = new ArrayList<RoleDto>();

		for (Role entity : entities) {
			dtos.add(new RoleDto(entity.getId(), entity.getDescription(), entity.getName()));
		}

		return dtos;
	}

	@Override
	public RoleDto findById(int id) {
		Role entity = roleRepository.getById(id);
		return new RoleDto(entity.getId(), entity.getDescription(), entity.getName());
	}

	@Override
	public void update(int id, RoleDto dto) {
		if (roleRepository.existsById(id)) {
			Role entity = roleRepository.getById(dto.getId());
			if (entity == null)
				return;
			entity.setName(dto.getName());
			entity.setDescription(dto.getDescription());
			roleRepository.save(entity);
		}
	}

	@Override
	public void add(RoleDto dto) {
		Role entity = new Role(dto.getName(), dto.getDescription());
		roleRepository.save(entity);
	}

	@Override
	public void delete(int id) {
		roleRepository.deleteById(id);
	}

	
}
