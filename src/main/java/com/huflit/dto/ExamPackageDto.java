package com.huflit.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExamPackageDto {

	private int id;
	
	private String title;
	
	private CategoryDto category;
	
	private String lastUpdate;
	
	private String createDate;
	
	private int time;
	
	private List<QuestionTypeExamPackageDto> questionTypeExams;
	
	private List<QuestionPackageDto> questions;

	public ExamPackageDto(String title, CategoryDto category, String lastUpdate, String createDate, int time,
			List<QuestionTypeExamPackageDto> questionTypeExams, List<QuestionPackageDto> questions) {
		super();
		this.title = title;
		this.category = category;
		this.lastUpdate = lastUpdate;
		this.createDate = createDate;
		this.time = time;
		this.questionTypeExams = questionTypeExams;
		this.questions = questions;
	}
	
	
}
