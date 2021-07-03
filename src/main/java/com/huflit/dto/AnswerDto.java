package com.huflit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDto {

	private int id;
	
	private String content;
	
	private int questionId;
	
	private boolean isTrue;

	public AnswerDto(String content, int questionId, boolean isTrue) {
		super();
		this.content = content;
		this.questionId = questionId;
		this.isTrue = isTrue;
	}
	
	
}
