package com.exam.examserver.services.implementation;
import java.nio.charset.StandardCharsets;
import java.util.*;

import com.exam.examserver.VO.CredentialsVO;
import com.exam.examserver.repository.CredentialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	RoleRepository RoleRepo;

	@Autowired
	CredentialRepo CR;
	
	//Throw a null user when no user created and else will throw a user same as userVo
	public AppUser getUserbyID(int ID){
		return UserRepo.findById(ID).get();
	}
	@Override
	public String createUser(UserVO usr, Role role, CredentialsVO c) {
		Set<Credential> cred = new HashSet<Credential>();
		Credential credential = new Credential();
		credential.setUsername(c.getUsername());
		credential.setPassword(c.getPassword());
		credential = CR.save(credential); // saving the credentials
		AppUser user = new AppUser();
		user.setUsername(user.getUsername());
		user.setEmail(usr.getEmail());
		user.setFirstName(usr.getFirstName());
		user.setLastname(usr.getLastname());
		user.setRoles(role);
		user.setPhone(usr.getPhone());
		user.setEnabled(true);
		user.setRoles(role);
		cred.add(credential);
		user.setCredentials(cred);		// mapping the credentials
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
	public List<AppUser> getAllUsers(int pages, int items) {
		Pageable pg = PageRequest.of(pages,items);
		return UserRepo.findAll(pg).getContent();
	}

	@Override
	public String AddCredentialsToUser(int ID, Credential c) {
		AppUser US = UserRepo.findById(ID).get();
		Set<Credential> CC = US.getCredentials();
		CC.add(c);
		UserRepo.save(US);
		return "Credentials Stored"+c.toString();
	}

	@Override
	public String RandomUsername() {
		boolean t = false;
		String returnl = null;
		byte[] array = new byte[7];
		while(t) {
			new Random().nextBytes(array);
			String generatedString  = new String(array, StandardCharsets.UTF_8);
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
