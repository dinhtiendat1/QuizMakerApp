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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "content", length = 255)
	private String content;
	
//	@Column(name = "exam_id")
//	private int examId;
	
	@Column(name = "question_type_id")
	private int questionTypeId;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "status")
	private Boolean status;
	
//	@ManyToOne
//	@JoinColumn(name = "exam_id", insertable = false, updatable = false)
//	private Exam exam;
	
	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "question_type_id", insertable = false, updatable = false)
	private QuestionType questionType;
	
	@OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
	private List<ExamQuestion> examQuestions;

	public Question(String content, int questionTypeId) {
		super();
		this.content = content;
//		this.examId = examId;
		this.questionTypeId = questionTypeId;
	}

	public Question(int id, String content, int questionTypeId) {
		super();
		this.id = id;
		this.content = content;
//		this.examId = examId;
		this.questionTypeId = questionTypeId;
	}
	
	public Question(String content, int questionTypeId, boolean status) {
		super();
		this.content = content;
//		this.examId = examId;
		this.questionTypeId = questionTypeId;
		this.status = status;
	}
	
	public Question(int id, String content, int questionTypeId, boolean status) {
		super();
		this.id = id;
		this.content = content;
//		this.examId = examId;
		this.questionTypeId = questionTypeId;
		this.status = status;
	}
}
