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
@Table(name = "`groups`")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", length = 255)	
	private String name;
	
	@Column(name = "description", length = 255)	
	private String description;
	
	@Column(name = "owner_id")
	private int ownerId;
	
	@Column(name = "group_code", length = 30)	
	private String groupCode;
	
	@OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
	private List<UserGroup> userGroups;
	
	@OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
	private List<GroupExam> groupExams;
	
	@OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
	private List<GroupMessage> groupMessages;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "owner_id", insertable = false, updatable = false)
	private User user;

	public Group(int id, String name, String description, int ownerId, String groupCode) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.ownerId = ownerId;
		this.groupCode = groupCode;
	}

	public Group(String name, String description, int ownerId, String groupCode) {
		super();
		this.name = name;
		this.description = description;
		this.ownerId = ownerId;
		this.groupCode = groupCode;
	}
	
	
}
