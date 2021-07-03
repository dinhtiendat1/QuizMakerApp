package com.huflit.service;

import java.util.List;

import com.huflit.dto.RoleDto;

public interface RoleService {

	List<RoleDto> findAll();

	RoleDto findById(int id);

	void update(int id, RoleDto dto);

	void add(RoleDto dto);

	void delete(int id);
}
