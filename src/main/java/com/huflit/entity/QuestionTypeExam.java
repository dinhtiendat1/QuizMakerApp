package com.huflit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "question_type_exams")
public class QuestionTypeExam implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private QuestionTypeExamPK id;
	
	@Column(name = "number")
	private int number;
	
	@ManyToOne
	@JoinColumn(name = "exam_id", insertable = false, updatable = false)
	private Exam exam;
	
	@ManyToOne
	@JoinColumn(name = "question_type_id", insertable = false, updatable = false)
	private QuestionType questionType;
	
	
}
