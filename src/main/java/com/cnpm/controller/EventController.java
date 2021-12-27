package com.cnpm.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cnpm.entity.EventEntity;
import com.cnpm.service.EventService;

@Controller
public class EventController {
	@Autowired
	EventService eventService;
	/*
	 * This method is used to create a event
	 */
	@PostMapping(value = "/event")
	public void newEvent(@RequestParam String eventName, @RequestParam String description
			,@RequestParam LocalDate timeStart,@RequestParam LocalDate timeEnd
			, @RequestParam int discountRate) {
		EventEntity newEvent = new EventEntity(eventName, description, timeStart, timeEnd, discountRate);
		if(eventService.save(newEvent)) {
			System.out.println("Success");
		}else {
			System.out.println("False");
		}
	}
	/*
	 * This method is used to get event's information and display it in dashboard 
	 */
	@GetMapping(value = "/dashboard")
	public String display() {
		List<EventEntity> events = eventService.findAll();
		for (EventEntity eventEntity : events) {
			System.out.println(eventEntity.getEventName());
		}
		return "index";
	}
	
/*
 * This method is used to edit event
 * Input : id, eventName, description, time start, time end , discountRate 
 */
	@PutMapping(value = "/event")
	public String editEvent(@RequestParam Long id,@RequestParam String eventName, @RequestParam String description
			,@RequestParam LocalDate timeStart,@RequestParam LocalDate timeEnd
			, @RequestParam int discountRate) {
//		Long id = 1L;
//		String eventName = "helloworld";
//		String description = "hello world";
//		LocalDate timeStart = LocalDate.now();
//		LocalDate timeEnd = LocalDate.now();
//		int discountRate = 10;
		EventEntity event = eventService.findEventById(id);
		if(event == null) {
			System.out.println("Error");
			return "login";
		}else {
			System.out.println("Success");
			event.setEventName(eventName);
			event.setDescription(description);
			event.setTimeStart(timeStart);
			event.setTimeEnd(timeEnd);
			event.setDiscountRate(discountRate);
			eventService.save(event);
			return "login";
		}
	}
	
	/*
	 * This method is used to search event with name of event
	 */
	@GetMapping(value = "/event")
	public String searchEvent(@RequestParam String eventName) {
		EventEntity event = eventService.findEventByName(eventName);
		System.out.println(event.getEventName());
		return "login";
	}
	
	/*
	 * This method is used to delete event with event's id. 
	 */
	@DeleteMapping(value = "/event")
	public String deleteEvent(@RequestParam Long id) {
		eventService.delete(id);
		return "login";
	}
	
}










