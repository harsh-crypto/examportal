package com.exam.examserver.controller;

import com.exam.examserver.VO.questionVO;
import com.exam.examserver.models.Question;
import com.exam.examserver.repository.questionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class questionController {

    private questionRepo QR;
    @Autowired
    public questionController(questionRepo qr){
        this.QR=qr;
    }

    public String GenerateQuestionIdentifier(){
        return RandomStringUtils.random(16, true, true);
    }
    @RequestMapping(value="/createQuestion", method= RequestMethod.POST)
    public ResponseEntity<?> createQuestion(@RequestBody questionVO QVO){
        Question question = new Question();
        question.setTypeOfQuestion(QVO.typeOfQuestion());
        question.setAnswer(QVO.answer());
        question.setDifficulty(QVO.difficulty());
        question.setStatement(QVO.statement());
        question.setMarks(QVO.marks());
        String ID = GenerateQuestionIdentifier()
        question.setQuestionIdentifier(ID);
        try{
            QR.save(question);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Cannot create", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Question created - "+ID, HttpStatus.OK);
    }

    @RequestMapping(value="/getquestion/{id}",method = RequestMethod.GET)
    public ResponseEntity<Question> getQuestionByIdentifier(@RequestParam("id") String ID){
        Question q = QR.
    }
}
