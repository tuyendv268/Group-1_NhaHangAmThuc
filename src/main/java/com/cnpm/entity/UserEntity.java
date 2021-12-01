package com.cnpm.entity;

import java.util.ArrayList;
import javax.persistence.JoinColumn;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column
	private String password;

	public Long getUserId() {
		return userId;
	}
	
	@ManyToMany
	@JoinTable(name = "user_role",
				joinColumns = @JoinColumn(name = "user_id", insertable = true,updatable = true, nullable=false),
				inverseJoinColumns = @JoinColumn(name = "role_id", insertable = true,updatable = true, nullable=false))
	private List<RoleEntity> roles = new ArrayList<>();


	public List<RoleEntity> getRoles() {
		return roles;
	}


	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
