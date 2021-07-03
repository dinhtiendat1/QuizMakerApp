package com.huflit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

	private int id;
	
	private String description;
	
	private String name;

	public RoleDto(String description, String name) {
		super();
		this.description = description;
		this.name = name;
	}
	
	
}
