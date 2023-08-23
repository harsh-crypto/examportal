package com.exam.examserver.models;

import jakarta.persistence.*;

public class Subject {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	
	@Column(nullable = false)
	String name;
	
	@Column
	String description;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Subject_id")
	Question question_id;


	public Subject(Integer id, String name, String description) {
		super();
		this.id = id;
		
		this.name = name;
		
		this.description = description;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	


}
