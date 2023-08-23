package com.exam.examserver.VO;

import com.exam.examserver.models.QuestionType;
import jakarta.persistence.Column;

public class questionVO {



    private String statement;
    private QuestionType typeOfQuestion;
    private String answer;
    private int marks;
    private String difficulty;
    public questionVO(String statement, QuestionType typeOfQuestion, String answer, int marks, String difficulty) {
        this.statement = statement;
        this.typeOfQuestion = typeOfQuestion;
        this.answer = answer;
        this.marks = marks;
        this.difficulty = difficulty;
    }
    public String statement() {
        return statement;
    }

    public questionVO setStatement(String statement) {
        this.statement = statement;
        return this;
    }

    public QuestionType typeOfQuestion() {
        return typeOfQuestion;
    }

    public questionVO setTypeOfQuestion(QuestionType typeOfQuestion) {
        this.typeOfQuestion = typeOfQuestion;
        return this;
    }

    public String answer() {
        return answer;
    }

    public questionVO setAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public int marks() {
        return marks;
    }

    public questionVO setMarks(int marks) {
        this.marks = marks;
        return this;
    }

    public String difficulty() {
        return difficulty;
    }

    public questionVO setDifficulty(String difficulty) {
        this.difficulty = difficulty;
        return this;
    }
}
