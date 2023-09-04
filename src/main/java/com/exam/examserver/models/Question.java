package com.exam.examserver.models;

import jakarta.persistence.*;

import java.util.List;

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

	@Column
	private String QuestionIdentifier;
	@ManyToMany
	@JoinTable(
			name = "Question_and_subject",
			joinColumns = @JoinColumn(name="Subject_id"),
			inverseJoinColumns = @JoinColumn(name="Question_id")
	)
	private List<Subject> sub;

	public Question(String statement, QuestionType typeOfQuestion, String answer, int marks, String difficulty) {
		super();
		this.statement = statement;
		this.typeOfQuestion = typeOfQuestion;
		this.answer = answer;
		this.marks = marks;
		this.difficulty = difficulty;
	}

	public String QuestionIdentifier() {
		return QuestionIdentifier;
	}

	public Question setQuestionIdentifier(String questionIdentifier) {
		QuestionIdentifier = questionIdentifier;
		return this;
	}
	public Question() {

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
