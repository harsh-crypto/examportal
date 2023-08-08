package com.exam.examserver.services.implementation;

import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examserver.VO.UserVO;
import com.exam.examserver.models.AppUser;
import com.exam.examserver.models.Credential;
import com.exam.examserver.models.Role;
import com.exam.examserver.repository.RoleRepository;
import com.exam.examserver.repository.UserRepository;
import com.exam.examserver.services.UserService;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	UserRepository UserRepo;
	
	@Autowired
	RoleRepository rolerepo;
	
	//Throw a null user when no user created and else will throw a user same as userVo
	
	@Override
	public String createUser(UserVO usr, Role role,Credential c) {
		AppUser user = null;
		Set<Credential> cred = new HashSet<>();
		cred.add(c);
		user = new AppUser(usr.getId(), usr.getUsername(), usr.getPassword(), usr.getLastname(), usr.getFirstName(), usr.getEmail(),usr.getPhone(), usr.isEnabled(),role);
		user.setCredentials(cred);
		user.setRoles(role);
		try{
			UserRepo.save(user);
		}
		catch(Exception e) {
			if(e.getMessage().contains("already exists")) {
				return e.getMessage();
			}
			else {
				e.printStackTrace();
				return "Something went wrong, check logs";
			}
		}
		return user.toString();
	}
	
	@Override
	public String RandomUsername() {
		boolean t = false;
		String returnl = null;
		byte[] array = new byte[7];
		while(t) {
			new Random().nextBytes(array);
			String generatedString  = new String(array, Charset.forName("UTF-8"));
			try {
				UserRepo.findByUsername(generatedString);
			}catch(Exception e) {
				returnl=generatedString;
				t=true;
			}
		}
		return returnl;
	}
	
}