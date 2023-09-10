package com.exam.examserver.controller;

import com.exam.examserver.VO.questionVO;
import com.exam.examserver.models.Question;
import com.exam.examserver.repository.QuestionRepo;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {
    private final QuestionRepo QR;
    @Autowired
    public QuestionController(QuestionRepo qr){
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
        String ID = GenerateQuestionIdentifier();
        question.setQuestionIdentifier(ID);
        try{
            QR.save(question);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Cannot create a question with the details below:\n"+question.toString(), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Question created - "+ID, HttpStatus.OK);
    }

    @RequestMapping(value="/question/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getQuestionByQIdentifier(@RequestParam("id") String QID){
        Question test = QR.findByQID(QID);
        if(test!=null){
        return new ResponseEntity<Question>(test,HttpStatus.OK);
        }
        else {
            System.out.print(QID+" is not present");
            return new ResponseEntity<String>("Conflict",HttpStatus.BAD_GATEWAY);
        }
    }

    @RequestMapping(value="/question/{sub}",method = RequestMethod.GET)
    public ResponseEntity<?> getQuestionBySubject(@RequestParam("sub") String sub){
        List<Question> test = QR.findBySubject(sub);
        if(!test.isEmpty()){
            return new ResponseEntity<>(test,HttpStatus.OK);
        }
        else {
            System.out.print(sub+" is not present");
            return new ResponseEntity<String>("Conflict",HttpStatus.BAD_GATEWAY);
        }
    }

    @RequestMapping(value="/question/{toq}",method = RequestMethod.GET)
    public ResponseEntity<?> getQuestionByTOQ(@RequestParam("toq") String TOQ){
        List<Question> test = QR.findByTOQ(TOQ);
        if(!test.isEmpty()){
            return new ResponseEntity<>(test,HttpStatus.OK);
        }
        else {
            System.out.print(TOQ+" is not present");
            return new ResponseEntity<String>("Conflict",HttpStatus.BAD_GATEWAY);
        }
    }

    @RequestMapping(value="/question/edit/{qid}",method = RequestMethod.POST)
    public ResponseEntity<?> EditQuestionByQID(@RequestParam("qid") String sub,@RequestBody questionVO QVO){
        Question test = QR.findByQID(sub);
        if(test!=null){
            test.setAnswer(QVO.answer());
            test.setMarks(QVO.marks());
            test.setStatement(QVO.statement());
            test.setTypeOfQuestion(QVO.typeOfQuestion());
            return new ResponseEntity<>(test,HttpStatus.OK);
        }
        else {
            System.out.print(sub+" is not present");
            return new ResponseEntity<>("Conflict",HttpStatus.OK);
        }
    }
}
