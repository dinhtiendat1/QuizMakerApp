package com.huflit.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "user_groups")
public class UserGroup implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private UserGroupPK id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
//	@JsonBackReference
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "group_id", insertable = false, updatable = false)
//	@JsonBackReference`
	private Group group;

	public UserGroup(UserGroupPK id) {
		super();
		this.id = id;
	}
	
	
}
