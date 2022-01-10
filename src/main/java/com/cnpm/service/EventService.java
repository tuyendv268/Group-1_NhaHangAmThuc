package com.cnpm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnpm.entity.EventEntity;
import com.cnpm.repository.EventRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository eventRepository;
	
	public EventEntity save(EventEntity eventEntity) {
		if(eventEntity.getTimeStart().before(eventEntity.getTimeEnd())) {
			return eventRepository.save(eventEntity);
		}
		return null;
	}
//	public void saveEvent(MultipartFile file,String eventName, String description
//			,String timeStart, String timeEnd, int discountRate) {
//		LocalDate start = LocalDate.parse(timeStart);
//		LocalDate end = LocalDate.parse(timeEnd);
//		EventEntity newEvent = new EventEntity(eventName, description, start, end, discountRate);
////		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
////		if(fileName.contains("..")) {
////			System.out.println("invalid file");
////		}
////		try {
////			newEvent.setUrl(Base64.getEncoder().encodeToString(file.getBytes()));
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
//		eventRepository.save(newEvent);
//	}
//	public void saveEvent(String eventName, String description
//			,String timeStart, String timeEnd, int discountRate) {
//		LocalDate start = LocalDate.parse(timeStart);
//		LocalDate end = LocalDate.parse(timeEnd);
//		EventEntity newEvent = new EventEntity(eventName, description, start, end, discountRate);
//		eventRepository.save(newEvent);
//	}
	
	public List<EventEntity> findAll(){
		return eventRepository.findAll();
	}
	
	public List<EventEntity> findEventByName(String eventName) {
		return eventRepository.findByEventName(eventName);
	}
	
	public void delete(Long id) {
		eventRepository.deleteById(id);
	}
	
	public EventEntity findEventById(Long id) {
		EventEntity event = eventRepository.findByEventId(id);
		return event;
	}
}
