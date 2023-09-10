package com.exam.examserver.models;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name="Subject")
public class Subject {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	
	@Column(nullable = false)
	String subName;
	
	@Column
	String description;

	@ManyToMany(mappedBy = "sub")
	List<Question> question_id;


	public Subject(Integer id, String subName, String description) {
		super();
		this.id = id;
		
		this.subName = subName;
		
		this.description = description;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + subName + ", description=" + description + "]";
	}
	


}
