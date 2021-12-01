package com.cnpm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnpm.entity.RoleEntity;
import com.cnpm.entity.UserEntity;
import com.cnpm.repository.RoleRepository;
import com.cnpm.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository user;
	
	@Autowired
	RoleRepository role;
	public String checkLogin(String userName, String password) {
		String role = "";
		UserEntity users = user.findOneByUserName(userName);
//		System.out.println(users.getUserName());
//		System.out.println(users.getPassword());
		if(users != null) {
			if(users.getPassword().equals(password)) {
				List<RoleEntity> roles = users.getRoles();
				if(roles != null) {
					for (RoleEntity roleEntity : roles) {
						if(roleEntity.getRoleName().equals("admin")) {
							role = "admin";
							return role;
						}else if(roleEntity.getRoleName().equals("staff")) {
							role = "staff";
						}
						return role;
					}
				}
			}else {
				return null;
			}
		}
		return null;
	}
}
