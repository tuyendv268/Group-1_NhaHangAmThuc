package com.cnpm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cnpm.service.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService user;
	
	@GetMapping(value = "/")
	public String customerPage() {

		return "menu";
	}
	@GetMapping(value = "/login")
	public String login() {

		return "index";
	}
	
	@GetMapping(value = "/contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping("/about")
	public String about() {
		
		return "about";
	}
	
	
	@PostMapping("/login")
	public String welcome(@RequestParam String username,@RequestParam String password,Model model){
		System.out.println("Hello world");
		String role = user.checkLogin(username,password);
		if(role != null) {
			if(role.equals("admin")) {
				return "welcomeAdmin";
			}else if(role.equals("staff")) {
				return "welcomeStaff";
			}
		}
		System.out.println("Không tồn tại tài khoản");
		return "index";
	}
	
}
// Cái này để thêm data vào database , các anh đừng xóa nhé
//UserEntity user1 = new UserEntity();
//user1.setUserName("user1");
//user1.setPassword("root");
//
//UserEntity user2 = new UserEntity();
//user2.setUserName("user2");
//user2.setPassword("root");
//
//RoleEntity role1 = new RoleEntity();
//role1.setRoleName("admin");
//
//RoleEntity role2 = new RoleEntity();
//role2.setRoleName("staff");
//
//role.save(role1);
//role.save(role2);
//
//ArrayList<RoleEntity> arr = new ArrayList<>();
//arr.add(role1);
//
//ArrayList<RoleEntity> arr1 = new ArrayList<>();
//arr1.add(role2);
//
//user1.setRoles(arr);
//user2.setRoles(arr1);
//
//user.save(user1);
//user.save(user2);
