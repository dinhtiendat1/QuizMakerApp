package com.huflit.entity;

import java.io.Serializable;
import java.util.List;

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
@Table(name = "exam_questions")
public class ExamQuestion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ExamQuestionPK id;
	
	@ManyToOne
	@JoinColumn(name = "exam_id", insertable = false, updatable = false)
	private Exam exam;
	
	@ManyToOne
	@JoinColumn(name = "question_id", insertable = false, updatable = false)
	private Question question;
	
}
