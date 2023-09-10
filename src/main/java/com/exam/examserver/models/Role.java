package com.exam.examserver.models;

import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(unique=true)
	private String roleName;
	
	public String getRoleName() {
		return roleName;
	}

	@OneToMany(cascade=CascadeType.MERGE)
	private List<AppUser> user_id;

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Role() {
		
	}

	public Long id() {
		return id;
	}

	public Role setId(Long id) {
		this.id = id;
		return this;
	}
	public Role(Long id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}
	
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}
	
	
	
}
