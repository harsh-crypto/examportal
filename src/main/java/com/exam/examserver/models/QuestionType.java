package com.exam.examserver.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


public enum QuestionType {
	
	MCQ("MCQ"),LONG("LONG"),SHORT("SHORT"),ONEWORD("One_word");
	
	QuestionType(String string) {
		// TODO Auto-generated constructor stub
	}

	public String getValue() {
		return this.getValue();
	}

}
