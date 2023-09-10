package com.exam.examserver.controller;

import com.exam.examserver.VO.CredentialsVO;
import com.exam.examserver.models.AppUser;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.exam.examserver.VO.UserVO;
import com.exam.examserver.models.Credential;
import com.exam.examserver.models.Role;
import com.exam.examserver.repository.RoleRepository;
import com.exam.examserver.services.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

	@Autowired 
	UserService UserSvc;
	
	@Autowired
	RoleRepository roleRepo;

	public UserController(UserService userSvc,RoleRepository RR) {
		this.UserSvc = userSvc;
		this.roleRepo=RR;
	}

	@RequestMapping(value="/createUser",method=RequestMethod.POST)
	ResponseEntity<?> createUser(@RequestBody UserVO usr,@RequestBody CredentialsVO c) {
		Role admin = roleRepo.findById(1).get();
		String status = UserSvc.createUser(usr, admin, c);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@RequestMapping(value="/User/all",method=RequestMethod.GET)
	ResponseEntity<?> AllUsers(@RequestParam int pages,@RequestParam int items){
		List<AppUser> APs = new ArrayList<>();
		try{
			UserSvc.getAllUsers(pages,items);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("somethings not right",HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(APs,HttpStatus.OK);
	}
	@RequestMapping(value = "/User/{id}",method = RequestMethod.GET)
	ResponseEntity<?> UserById(@RequestParam("id")int ID){
		AppUser ap = new AppUser();
		try{
			ap = UserSvc.getUserByID(ID);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("Cant fetch this user"+e.getMessage(),HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<>(ap,HttpStatus.OK);
	}
}
