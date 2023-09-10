package com.exam.examserver;

import com.exam.examserver.VO.CredentialsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.examserver.VO.UserVO;
import com.exam.examserver.models.Credential;
import com.exam.examserver.models.Role;
import com.exam.examserver.repository.RoleRepository;
import com.exam.examserver.services.UserService;

@SpringBootApplication
public class ExamPortalApplication implements CommandLineRunner{
	@Autowired 
	RoleRepository rp;
	@Autowired
	UserService US;
	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role r1 = new Role("Admin");
		Role r2 = new Role("Moderator");
		Role r3 = new Role("Invigilator");
		Role r4 = new Role("Student");
		rp.save(r1);
		rp.save(r2);
		rp.save(r3);
		rp.save(r4);
		CredentialsVO c = new CredentialsVO();
		c.setUsername("Username");
		c.setPassword("password");
		UserVO user = new UserVO("FirstUser", "Harsh", "Iccha", "Micha", "teriIccha@gmail.com","000-8975746", true);
		US.createUser(user, r1,c);
	}
}
