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
@Table(name = "group_exams")
public class GroupExam implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private GroupExamPK id;
	
	@ManyToOne
	@JoinColumn(name = "group_id", insertable = false, updatable = false)
	private Group group;
	
	@ManyToOne
	@JoinColumn(name = "exam_id", insertable = false, updatable = false)
	private Exam exam;

}
