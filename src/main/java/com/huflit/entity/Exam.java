package com.huflit.entity;

import java.util.Date;
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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "exams")
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "title", length = 255)
	private String title;
	
	@Column(name = "time")
	private int time;
	
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name = "last_update")
	private Date lastUpdate;
	
	@ManyToOne
	@JoinColumn(name = "category_id", insertable = false, updatable = false)
	private Category category;
	
	@OneToMany(mappedBy = "exam", fetch = FetchType.LAZY)
	private List<UserExam> userExams;
	
	@OneToMany(mappedBy = "exam", fetch = FetchType.LAZY)
	private List<Question> questions;
	
	@OneToMany(mappedBy = "exam", fetch = FetchType.LAZY)
	private List<QuestionTypeExam> questionTypeExams;

	public Exam(int id, String title, int time, int categoryId, Date lastUpdate) {
		super();
		this.id = id;
		this.title = title;
		this.time = time;
		this.categoryId = categoryId;
		this.lastUpdate = lastUpdate;
	}

	public Exam(String title, int time, int categoryId, Date lastUpdate) {
		super();
		this.title = title;
		this.time = time;
		this.categoryId = categoryId;
		this.lastUpdate = lastUpdate;
	}
	
	
}
