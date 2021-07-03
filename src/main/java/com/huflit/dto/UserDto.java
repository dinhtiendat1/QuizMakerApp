package com.huflit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private int id;
	
	private String email;
	
	private String fullname;
	
	private String password;
	
	private String avatar;
	
	private String phone;
	
	private String address;
	
	private int roleId;

	public UserDto(String email, String fullname, String password, String avatar, String phone, String address,
			int roleId) {
		super();
		this.email = email;
		this.fullname = fullname;
		this.password = password;
		this.avatar = avatar;
		this.phone = phone;
		this.address = address;
		this.roleId = roleId;
	}
	
}
