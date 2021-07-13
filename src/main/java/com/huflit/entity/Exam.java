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
	
	@Column(name = "last_update", length = 8)
	private String lastUpdate;
	
	@Column(name = "create_date", length = 8)
	private String createDate;
	
	@ManyToOne
	@JoinColumn(name = "category_id", insertable = false, updatable = false)
	private Category category;
	
	@OneToMany(mappedBy = "exam", fetch = FetchType.LAZY)
	private List<UserExam> userExams;
	
	@OneToMany(mappedBy = "exam", fetch = FetchType.LAZY)
	private List<ExamQuestion> examQuestions;
	
	@OneToMany(mappedBy = "exam", fetch = FetchType.LAZY)
	private List<QuestionTypeExam> questionTypeExams;
	
	@OneToMany(mappedBy = "exam", fetch = FetchType.LAZY)
	private List<GroupExam> groupExams;

	public Exam(int id, String title, int time, int categoryId, String lastUpdate) {
		super();
		this.id = id;
		this.title = title;
		this.time = time;
		this.categoryId = categoryId;
		this.lastUpdate = lastUpdate;
	}
	
	public Exam(int id, String title, int time, int categoryId, String lastUpdate, String createDate) {
		super();
		this.id = id;
		this.title = title;
		this.time = time;
		this.categoryId = categoryId;
		this.lastUpdate = lastUpdate;
		this.createDate = createDate;
	}

	public Exam(String title, int time, int categoryId, String lastUpdate, String createDate) {
		super();
		this.title = title;
		this.time = time;
		this.categoryId = categoryId;
		this.lastUpdate = lastUpdate;
		this.createDate = createDate;
	}
	
	
}
