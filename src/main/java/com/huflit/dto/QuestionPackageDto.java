package com.huflit.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionPackageDto extends QuestionDto {

	private int id;
	
	private String content;
	
//	private int examId;
	
	private int questionTypeId;
	
	private List<AnswerDto> answers;

	public QuestionPackageDto(String content, int questionTypeId, List<AnswerDto> answers) {
		super();
		this.content = content;
//		this.examId = examId;
		this.questionTypeId = questionTypeId;
		this.answers = answers;
	} 
	
	
	
}
