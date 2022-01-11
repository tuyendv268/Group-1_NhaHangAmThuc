package com.cnpm.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cnpm.entity.EventEntity;
import com.cnpm.entity.UserEntity;
import com.cnpm.repository.UserRepository;
import com.cnpm.service.EventService;

@Controller
public class WebController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	EventService eventService;

	@GetMapping(value = {"/home" })
	public String homepage(Model model) {
		ArrayList<EventEntity> events = (ArrayList<EventEntity>)eventService.findAll();
		if(events.size() != 0) {
			model.addAttribute("events", events);
		}
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


}
