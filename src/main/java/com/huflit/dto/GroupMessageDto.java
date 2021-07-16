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
public class GroupMessageDto {

	private int id;
	
	private String content;
	
	private int userId;
	
	private int groupId;
	
	private String date;
}
