package com.huflit.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "group_messages")
public class GroupMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "content", length = 255)	
	private String content;
	
	@Column(name = "date", length = 8)	
	private String date;
	
	@Column(name = "group_id")
	private int groupId;
	
	@Column(name = "user_id")
	private int userId;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "group_id", insertable = false, updatable = false)
	private Group group;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;

	public GroupMessage(int id, String content, String date, int groupId, int userId) {
		super();
		this.id = id;
		this.content = content;
		this.date = date;
		this.groupId = groupId;
		this.userId = userId;
	}

	public GroupMessage(String content, String date, int groupId, int userId) {
		super();
		this.content = content;
		this.date = date;
		this.groupId = groupId;
		this.userId = userId;
	}
	
	
}
