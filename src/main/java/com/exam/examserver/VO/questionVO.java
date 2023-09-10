package com.exam.examserver.VO;

import com.exam.examserver.models.QuestionType;

public class questionVO {
    private String Statement;
    private QuestionType TypeOfQuestion;
    private String Answer;
    private int Marks;
    private String Difficulty;
    public questionVO(String statement, QuestionType typeOfQuestion, String answer, int marks, String difficulty) {
        this.Statement = statement;
        this.TypeOfQuestion = typeOfQuestion;
        this.Answer = answer;
        this.Marks = marks;
        this.Difficulty = difficulty;
    }
    public String statement() {
        return Statement;
    }

    public questionVO setStatement(String statement) {
        this.Statement = statement;
        return this;
    }

    public QuestionType typeOfQuestion() {
        return TypeOfQuestion;
    }

    public questionVO setTypeOfQuestion(QuestionType typeOfQuestion) {
        this.TypeOfQuestion = typeOfQuestion;
        return this;
    }

    public String answer() {
        return Answer;
    }

    public questionVO setAnswer(String answer) {
        this.Answer = answer;
        return this;
    }

    public int marks() {
        return Marks;
    }

    public questionVO setMarks(int marks) {
        this.Marks = marks;
        return this;
    }

    public String difficulty() {
        return Difficulty;
    }

    public questionVO setDifficulty(String difficulty) {
        this.Difficulty = difficulty;
        return this;
    }
}
