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
public class GroupExamPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "exam_id")
	private int examId;
	
	@Column(name = "group_id")
	private int groupId;
}
