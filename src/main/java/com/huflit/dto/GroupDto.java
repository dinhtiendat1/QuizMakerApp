package com.huflit.dto;

import java.util.List;

import com.huflit.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupDto {

	private int id;
	
	private String name;
	
	private String description;
	
	private int ownerId;
	
	private String groupCode;
	
	private UserDto owner;

	public GroupDto(String name, String description, int ownerId, String groupCode, UserDto owner) {
		super();
		this.name = name;
		this.description = description;
		this.ownerId = ownerId;
		this.owner = owner;
		this.groupCode = groupCode;
	}

	public GroupDto(String name, String description, String groupCode, int ownerId) {
		super();
		this.name = name;
		this.description = description;
		this.ownerId = ownerId;
		this.groupCode = groupCode;
	}

	public GroupDto(int id, String name, String description, String groupCode, UserDto owner) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.owner = owner;
		this.groupCode = groupCode;
	}

	
}
