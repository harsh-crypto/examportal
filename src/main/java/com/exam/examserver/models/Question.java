package com.exam.examserver.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="questions")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column
	private String statement;
	
	@Column
	private QuestionType typeOfQuestion;
	
	@Column
	private String answer;
	
	@Column
	private int marks;
	
	@Column
	private String difficulty;

	public Question(String statement, QuestionType typeOfQuestion, String answer, int marks, String difficulty) {
		super();
		this.statement = statement;
		this.typeOfQuestion = typeOfQuestion;
		this.answer = answer;
		this.marks = marks;
		this.difficulty = difficulty;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public QuestionType getTypeOfQuestion() {
		return typeOfQuestion;
	}

	public void setTypeOfQuestion(QuestionType typeOfQuestion) {
		this.typeOfQuestion = typeOfQuestion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
}
