package com.cnpm.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.cnpm.entity.EventEntity;
import com.cnpm.service.EventService;

@Controller
public class EventController {
	@Autowired
	EventService eventService;
	/*
	 * This method is used to create a event
	 */
	
//	@GetMapping("/demo")
//    public RedirectView saveUser(@RequestParam("image") MultipartFile multipartFile) throws IOException {
//         
////        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
////        event.setPhotos(fileName);
////        
//        System.out.println("lưu thành công : ");
//        return new RedirectView("/demo1", true);
//    }
//	@GetMapping("/demo1")
//    public String display() {
////        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
////        event.setPhotos(fileName);
////        
//        System.out.println("lưu thành công : ");
//        return "test";
//    }
	
	@GetMapping(value = "/event/new")
	public String newEvent(@RequestParam MultipartFile file, @RequestParam String eventName, @RequestParam String description
			,@RequestParam String timeStart,@RequestParam String timeEnd
			, @RequestParam int discountRate) {
//		LocalDate start = LocalDate.parse(timeStart);
//		LocalDate end = LocalDate.parse(timeEnd);
//		EventEntity newEvent = new EventEntity(eventName, description, start, end, discountRate);
//		if(eventService.save(newEvent)) {
//			System.out.println("Success");
//		}else {
//			System.out.println("False");
//		}
		System.out.println("dmeo");
		eventService.saveEvent(file, eventName, description, timeStart, timeEnd, discountRate);
		return "redirect:/event";
	}
	/*
	 * This method is used to get event's information and display it in dashboard 
	 */
	@GetMapping(value = "/event")
	public String display(Model model) {
		ArrayList<EventEntity> events = (ArrayList<EventEntity>)eventService.findAll();
//		for (EventEntity eventEntity : events) {
//			System.out.println(eventEntity.getEventName());
//		}
		model.addAttribute("events", events);
		return "event";
	}
	
/*
 * This method is used to edit event
 * Input : id, eventName, description, time start, time end , discountRate 
 */
	@PutMapping(value = "/test")
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
	@GetMapping(value = "/test")
	public String searchEvent(@RequestParam String eventName) {
		EventEntity event = eventService.findEventByName(eventName);
		System.out.println(event.getEventName());
		return "login";
	}
	
	/*
	 * This method is used to delete event with event's id. 
	 */
	@DeleteMapping(value = "/test")
	public String deleteEvent(@RequestParam Long id) {
		eventService.delete(id);
		return "login";
	}
	
}










