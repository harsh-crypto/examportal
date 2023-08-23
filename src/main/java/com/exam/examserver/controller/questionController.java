package com.exam.examserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

public class questionController {

    private questionRepo QR;
    @Autowired
    public questionController(questionRepo qr){
        this.QR=qr;
    }

    @requetMapping(value="/createQuestion",method= RequestMethod.POST)
    public String createQuestion(@RequestBody questionVO QVO){
        
        return "none created."
    }
}
