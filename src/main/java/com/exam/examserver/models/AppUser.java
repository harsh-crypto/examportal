package com.exam.examserver.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany; 

public class AppUser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false, unique=true)
	private String username;
	@Column
	private String password;
	@Column
	private String lastname;
	@Column
	private String firstName;
	@Column(nullable=false, unique=true)
	private String email;
	@Column(nullable=false)
	private String phone; 
	@Column(nullable=false)
	private boolean enabled;
	
    @JoinColumn(name = "user_id")
	private Role roles;
	
	@ManyToMany(targetEntity=Credential.class,cascade= {CascadeType.PERSIST})
	@JoinTable(
			name="User_credentials",
			joinColumns= {@JoinColumn(name="user_id")},
			inverseJoinColumns= {@JoinColumn(name="credential_id")})
	Set<Credential> credentials;

	public AppUser() 
	{
		
	}
	
	public AppUser(Long id, String username, String password, String lastname, String firstName, String email,
			String phone, boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.lastname = lastname;
		this.firstName = firstName;
		this.email = email;
		this.phone = phone;
		this.enabled = enabled;
	}
	
	public AppUser(Long id, String username, String password, String lastname, String firstName, String email,
			String phone, boolean enabled,Role roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.lastname = lastname;
		this.firstName = firstName;
		this.email = email;
		this.phone = phone;
		this.enabled = enabled;
		this.roles = roles;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setRoles(Role roles) {
		this.roles = roles;
	}
	
	public Role getRoles() {
		return roles;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Credential> getCredentials() {
		return credentials;
	}

	public void setCredentials(Set<Credential> credentials) {
		this.credentials = credentials;
	}
	

}
