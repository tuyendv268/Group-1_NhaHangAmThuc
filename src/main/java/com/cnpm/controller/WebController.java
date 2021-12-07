package com.cnpm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cnpm.entity.UserEntity;
import com.cnpm.repository.UserRepository;

@Controller
public class WebController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping(value = {"/home" })
	public String homepage() {
		return "home";
	}

	@GetMapping(value = {"/" ,"/login"})
	public String login() {
//		UserEntity user = new UserEntity();
//		user.setUserName("tien");
//		user.setPassword(passwordEncoder.encode("tien"));
//		userRepository.save(user);
//		System.out.println(user);
		return "login";
	}
	@GetMapping("/menu")
	public String menu() {
		return "index";
	}

}
