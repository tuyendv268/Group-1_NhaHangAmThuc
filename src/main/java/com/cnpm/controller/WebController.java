package com.cnpm.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cnpm.entity.DishEntity;
import com.cnpm.entity.EventEntity;
import com.cnpm.entity.UserEntity;
import com.cnpm.repository.UserRepository;
import com.cnpm.service.DishService;
import com.cnpm.service.EventService;

@Controller
public class WebController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	EventService eventService;
	@Autowired
	DishService dishService;

	@GetMapping(value = {"/" ,"/home"})
	public String homepage(Model model) {
		ArrayList<EventEntity> events = (ArrayList<EventEntity>)eventService.findAll();
		System.out.println(events.size());
		for(int i = events.size(); i > 0; i--) {
			if(!events.get(i-1).isDisplayed()) {
				events.remove(i-1);
			}
		}
		for(int i = 0; i < events.size(); i++) {
			System.out.println(events.get(i).getEventName());
		}
		if(events.size() != 0) {
			model.addAttribute("events", events);
		}
		
		ArrayList<DishEntity> dishes = (ArrayList<DishEntity>) dishService.findTopFeaturedDish();
		model.addAttribute("dishes", dishes);
		
		return "home";
	}

	@GetMapping(value = {"/login"})
	public String login() {
//		UserEntity user = new UserEntity();
//		user.setUserName("tien");
//		user.setPassword(passwordEncoder.encode("tien"));
//		userRepository.save(user);
//		System.out.println(user);
		return "login";
	}


}
