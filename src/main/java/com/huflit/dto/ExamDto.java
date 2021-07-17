package com.huflit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExamDto {

	private int id;
	
	private String title;
	
	private int time;
	
	private CategoryDto category;
	
	private String lastUpdate;
	
	private String createDate;
	
}
