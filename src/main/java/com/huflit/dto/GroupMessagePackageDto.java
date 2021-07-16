package com.huflit.dto;

import com.huflit.entity.Group;
import com.huflit.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupMessagePackageDto {
	
	private int id;
	
	private String content;
	
	private User user;
	
	private Group group;
	
	private String date;
}
