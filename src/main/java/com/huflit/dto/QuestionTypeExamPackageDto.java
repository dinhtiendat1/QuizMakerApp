package com.huflit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionTypeExamPackageDto {

	private ExamDto exam;
	
	private QuestionTypeDto questionType;
	
	private int number;
}
