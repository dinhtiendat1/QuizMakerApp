package com.huflit.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name = "email", length = 255)
	private String email;
	
	@NotNull
	@Column(name = "fullname", length = 100)
	private String fullname;
	
	@NotNull
	@Column(name = "password", length = 100)
	private String password;
	
	@Column(name = "avatar", length = 255)
	private String avatar;
	
	@Column(name = "phone", length = 255)
	private String phone;
	
	@Column(name = "address", length = 255)
	private String address;
	
	@Column(name = "role_id")
	private int roleId;
	
	@ManyToOne
	@JoinColumn(name = "role_id", insertable = false, updatable = false)
	private Role role;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<UserExam> userExams;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Question> questions;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<UserGroup> userGroups;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Group> groups;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<GroupMessage> groupMessages;
	
	public User(String email, String fullname, String password, String avatar, String phone, String address,
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
	
	public User(String email, String fullname, String password, String avatar, String phone,
			int roleId) {
		super();
		this.email = email;
		this.fullname = fullname;
		this.password = password;
		this.avatar = avatar;
		this.phone = phone;
		this.roleId = roleId;
	}
	
}
