package com.exam.examserver.services;

import com.exam.examserver.VO.CredentialsVO;
import com.exam.examserver.models.AppUser;
import org.springframework.stereotype.Service;

import com.exam.examserver.VO.UserVO;
import com.exam.examserver.models.Credential;
import com.exam.examserver.models.Role;

import java.util.List;

@Service
public interface UserService {
	String createUser(UserVO usr, Role role, CredentialsVO c);

	/**
	 * @param pages
	 * @param items
	 * @return
	 */
	List<AppUser> getAllUsers(int pages, int items);
	AppUser getUserByID(int ID);
	public String AddCredentialsToUser(int ID, Credential c);
	String RandomUsername();
}
