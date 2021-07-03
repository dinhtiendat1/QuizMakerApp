package com.huflit.entity;

import java.io.Serializable;

import javax.persistence.Column;
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
@Table(name = "user_exams")
public class UserExam implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserExamPK id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "exam_id", insertable = false, updatable = false)
	private Exam exam;
	
	@Column(name = "complete_time")
	private int completeTime;

	public UserExam(UserExamPK id, int completeTime) {
		super();
		this.id = id;
		this.completeTime = completeTime;
	}
	
	
}
