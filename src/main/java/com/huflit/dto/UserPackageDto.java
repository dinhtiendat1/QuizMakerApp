package com.huflit.dto;

import com.huflit.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPackageDto {

	private int id;
	
	private String email;
	
	private String fullname;
	
	private String password;
	
	private String avatar;
	
	private String phone;
	
	private String address;
	
	private Role role;
}
