package com.exam.examserver.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


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

	@ManyToOne(cascade=CascadeType.MERGE)
	private List<AppUser> appuser; 
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Role() {
		
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
