package com.exam.examserver.controller;

import com.exam.examserver.VO.questionVO;
import com.exam.examserver.models.Question;
import com.exam.examserver.repository.questionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class questionController {

    private questionRepo QR;
    @Autowired
    public questionController(questionRepo qr){
        this.QR=qr;
    }

    @RequestMapping(value="/createQuestion", method= RequestMethod.POST)
    public String createQuestion(@RequestBody questionVO QVO){
        Question question = new Question();
        question.setTypeOfQuestion(QVO.typeOfQuestion());
        question.setAnswer(QVO.answer());
        question.setDifficulty(QVO.difficulty());
        question.setStatement(QVO.statement());
        question.setMarks(QVO.marks());
        try{
            QR.save(question);
        }catch(Exception e){
            e.printStackTrace();
            return "Cannot create";
        }
        return "none created.";
    }
}
