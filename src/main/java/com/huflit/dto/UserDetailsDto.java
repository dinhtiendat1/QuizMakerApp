package com.huflit.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsDto extends User implements UserDetails {

	private static final long serialVersionUID = 1L;

	private int id;
	
	private int roleId;
	
	public UserDetailsDto(int id, int roleId, String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.id = id;
		this.roleId = roleId;
	}

}
