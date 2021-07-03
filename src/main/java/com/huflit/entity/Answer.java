package com.huflit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "answers")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "content", length = 255)
	private String content;
	
	@Column(name = "is_true")
	private boolean isTrue;
	
	@Column(name = "question_id")
	private int questionId;
	
	@ManyToOne
	@JoinColumn(name = "question_id", insertable = false, updatable = false)
	private Question question;

	public Answer(int id, String content, boolean isTrue, int questionId) {
		super();
		this.id = id;
		this.content = content;
		this.isTrue = isTrue;
		this.questionId = questionId;
	}

	public Answer(String content, boolean isTrue, int questionId) {
		super();
		this.content = content;
		this.isTrue = isTrue;
		this.questionId = questionId;
	}
	
	
}
