package com.huflit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "icon", length = 255)
	private String icon;
	
	@Column(name = "status")
	private Boolean status;

	public Category(String name, String icon, boolean status) {
		super();
		this.name = name;
		this.icon = icon;
		this.status = status;
	}
	
	
}
