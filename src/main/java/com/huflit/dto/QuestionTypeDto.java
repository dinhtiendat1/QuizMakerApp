package com.huflit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionTypeDto {

	private int id;

	private String name;

	private String icon;
	
	private int categoryId;

	public QuestionTypeDto(String name, String icon, int categoryId) {
		super();
		this.name = name;
		this.icon = icon;
		this.categoryId = categoryId;
	}
	
}
