package com.cnpm.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cnpm.entity.EventEntity;
import com.cnpm.service.EventService;

@Controller
public class EventController {
	@Autowired
	EventService eventService;
	
	@PostMapping(value = "/event")
	public void newEvent(@RequestParam String eventName, @RequestParam String description
			,@RequestParam LocalDate timeStart,@RequestParam LocalDate timeEnd
			, @RequestParam int discountRate) {
		EventEntity newEvent = new EventEntity(eventName, description, timeStart, timeEnd, discountRate);
		
	}
	
	@PostMapping(value = "/test")
	public String test() {
//		String eventName = "demo1";
//		String description = "demo1";
//		LocalDate timeStart = LocalDate.now();
//		LocalDate timeEnd = LocalDate.now();
//		int discountRate = 100;
//		EventEntity newEvent = new EventEntity(eventName, description, timeStart, timeEnd, discountRate);
//		if(eventService.save(newEvent)) {
//			System.out.println("Success");
//		}else {
//			System.out.println("False");
//		}
		return "login";
	}
}










