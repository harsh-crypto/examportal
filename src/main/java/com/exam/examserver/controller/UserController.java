package com.exam.examserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examserver.VO.UserVO;
import com.exam.examserver.models.Credential;
import com.exam.examserver.models.Role;
import com.exam.examserver.repository.RoleRepository;
import com.exam.examserver.services.UserService;

@RestController
public class UserController {

	@Autowired 
	UserService UserSvc;
	
	@Autowired
	RoleRepository roleRepo;
	
	@RequestMapping(value="/createUser",method=RequestMethod.POST)
	ResponseEntity<?> createUser(@RequestBody UserVO usr,@RequestBody Credential c) {
		Role admin = roleRepo.findById(1).get();
		String status = UserSvc.createUser(usr, admin, c,false);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
}
