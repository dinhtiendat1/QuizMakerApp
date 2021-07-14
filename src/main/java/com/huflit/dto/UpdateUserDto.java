package com.huflit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto {

	private int id;
	
	private String fullname;
	
	private String avatar;
	
	private String phone;
	
	private String address;
}
