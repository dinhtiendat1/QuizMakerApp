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
public class QuestionDto {

	private int id;
	
	private String content;
		
	private int questionTypeId;

	public QuestionDto(String content, int questionTypeId) {
		super();
		this.content = content;
//		this.examId = examId;
		this.questionTypeId = questionTypeId;
	}
	
	
}
