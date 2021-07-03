package com.huflit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

	private int id;

	private String name;

	private String icon;

	public CategoryDto(String name, String icon) {
		super();
		this.name = name;
		this.icon = icon;
	}
	
}
