package com.cnpm.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cnpm.entity.EventEntity;
import com.cnpm.service.EventService;

@Controller
public class EventController {
//	public static String uploadDirectory = "C:\\images";
	@Autowired
	EventService eventService;
	
	/*
	 * This method is used to create a event
	 */
	 @RequestMapping(value = "/event/new", method = RequestMethod.POST, params="close")
	 public String cancelEvent(){
		  return "redirect:/event";
	  }

	 @RequestMapping(value = "/event/new", method = RequestMethod.POST, params="create")
	 public String newEvent(Model model,
			  @RequestParam("files") MultipartFile file,
			  @RequestParam("eventName") String eventName,
			  @RequestParam("description") String description,
			  @RequestParam("timeStart") String timeStart,
			  @RequestParam("timeEnd") String timeEnd,
			  @RequestParam("discountRate") int discountRate){
		 Path path = Paths.get("uploads/");
		 try {
			 InputStream inputStream = file.getInputStream();
			 Files.copy(inputStream, path.resolve(file.getOriginalFilename()),
					 StandardCopyOption.REPLACE_EXISTING);
			 System.out.println(timeEnd);
			 Date start = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(timeStart);
			 System.out.println(start.toString());
			 Date end = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(timeEnd);
			 EventEntity newEvent = new EventEntity(eventName, description, start, end, discountRate);
			 newEvent.setUrl(file.getOriginalFilename().toLowerCase());
			 
			 if(eventService.save(newEvent) != null) {
				 System.out.println("Success");
			 }else {
				 System.out.println("False");
			 }
		 }catch (Exception e) {

		 }
		 return "redirect:/event";
	  }
	/*
	 * This method is used to get event's information and display it in dashboard 
	 */
	@GetMapping(value = "/event")
	public String display(Model model) {
		ArrayList<EventEntity> events = (ArrayList<EventEntity>)eventService.findAll();
		model.addAttribute("events", events);
//		for (EventEntity eventEntity : events) {
//			System.out.println(eventEntity.getUrl());
//		}
		return "event";
	}
	
/*
 * This method is used to edit event
 * Input : id, eventName, description, time start, time end , discountRate 
 */
	@PutMapping(value = "/test")
	public String editEvent(@RequestParam Long id,@RequestParam String eventName, @RequestParam String description
			,@RequestParam String timeStart,@RequestParam String timeEnd
			, @RequestParam int discountRate) {
		EventEntity event = eventService.findEventById(id);
		if(event == null) {
			System.out.println("Error");
			return "login";
		}else {
			Date start = null,end = null;
			try {
				start = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(timeStart);
				end = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(timeEnd);
				System.out.println("Success");
				event.setEventName(eventName);
				event.setDescription(description);
				event.setTimeStart(start);
				event.setTimeEnd(end);
				event.setDiscountRate(discountRate);
				eventService.save(event);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return "login";
		}
	}
	
	/*
	 * This method is used to search event with name of event
	 */ 
	@GetMapping(value = "/event/search")
	public String searchEvent(@RequestParam String eventName, Model model) {
		ArrayList<EventEntity> events = (ArrayList<EventEntity>)eventService.findEventByName(eventName);
		if(events.size() != 0) {
			model.addAttribute("events", events);
			return "event";
		}
		return "redirect:/event";
	}
	
	/*
	 * This method is used to delete event with event's id. 
	 */
	@GetMapping(value = "/event/{id}")
	public String deleteEvent(@PathVariable Long id, Model model) {
		eventService.delete(id);
		System.out.println("Delete event : "+ id);
		return "redirect:/event";
	}
	
}










