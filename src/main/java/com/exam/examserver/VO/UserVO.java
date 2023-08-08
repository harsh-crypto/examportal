package com.exam.examserver.VO;

public class UserVO {
	private Long id;
	private String username;
	private String password;
	private String lastname;
	private String firstName;
	private String email;
	private String phone; 
	private boolean enabled;
	public UserVO(Long id, String username, String password, String lastname, String firstName, String email,
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
	
	public UserVO(String username, String password, String lastname, String firstName, String email,
			String phone, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.lastname = lastname;
		this.firstName = firstName;
		this.email = email;
		this.phone = phone;
		this.enabled = enabled;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
