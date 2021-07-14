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
@Table(name = "question_types")
public class QuestionType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "icon", length = 255)
	private String icon;
	
	@Column(name = "status")
	private Boolean status;
	
	@Column(name = "category_id")
	private int categoryId;
	
	@ManyToOne
	@JoinColumn(name = "category_id", insertable = false, updatable = false)
	private Category category;
	
	@OneToMany(mappedBy = "questionType", fetch = FetchType.LAZY)
	private List<QuestionTypeExam> questionTypeExams;
	
	@OneToMany(mappedBy = "questionType", fetch = FetchType.LAZY)
	private List<Question> questions;

	public QuestionType(String name, String icon, int categoryId) {
		super();
		this.name = name;
		this.icon = icon;
		this.categoryId = categoryId;
	}
	
	public QuestionType(String name, String icon, int categoryId, boolean status) {
		super();
		this.name = name;
		this.icon = icon;
		this.categoryId = categoryId;
		this.status = status;
	}
	
	public QuestionType(int id, String name, String icon, int categoryId) {
		super();
		this.name = name;
		this.icon = icon;
		this.categoryId = categoryId;
	}
	
	
}
