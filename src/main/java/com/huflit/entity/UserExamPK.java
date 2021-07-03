package com.huflit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Embeddable
public class UserExamPK implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "exam_id")
	private int examId;
	
	@Column(name = "making_test_number")
	private int makingTestNumber;
}
