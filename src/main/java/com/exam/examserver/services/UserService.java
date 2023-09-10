package com.exam.examserver.services;

import org.springframework.stereotype.Service;

import com.exam.examserver.VO.UserVO;
import com.exam.examserver.models.Credential;
import com.exam.examserver.models.Role;

@Service
public interface UserService {

	public String createUser(UserVO usr, Role role,Credential c,boolean isInstitutional);

	public String AddCredentialsToUser(int ID, Credential c);
	String RandomUsername();
}
