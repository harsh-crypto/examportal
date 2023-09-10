package com.exam.examserver.services.implementation;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.exam.examserver.repository.CredentialRepo;
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
	RoleRepository RoleRepo;

	@Autowired
	CredentialRepo CR;
	
	//Throw a null user when no user created and else will throw a user same as userVo
	
	public String createUser(UserVO usr, Role role,Credential c,boolean isInstitutional) {
		Set<Credential> cred = new HashSet<>();
		cred.add(c);
		AppUser user = new AppUser(usr.getId(), usr.getUsername(), usr.getPassword(), usr.getLastname(), usr.getFirstName(), usr.getEmail(),usr.getPhone(), usr.isEnabled(),role);
		user.setCredentials(cred);
		user.setRoles(role);
		user.setInstitutionUser(isInstitutional);
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
	public String AddCredentialsToUser(int ID, Credential c) {
		AppUser US = UserRepo.findById(ID).get();
		Set<Credential> CC = US.getCredentials();
		if(US.institutionUser())CC.add(c);
		else return "cannot save the credentials";
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
