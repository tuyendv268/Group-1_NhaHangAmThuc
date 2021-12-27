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
	
	public boolean save(EventEntity eventEntity) {
		if(eventEntity.getTimeStart().isBefore(eventEntity.getTimeEnd())) {
			if(eventRepository.save(eventEntity) != null) {
				return true;
			}
		}
		return false;
	}
	
	public List<EventEntity> findAll(){
		return eventRepository.findAll();
	}
	
	public EventEntity findEventByName(String eventName) {
		EventEntity event = eventRepository.findByEventName(eventName);
		return event;
	}
	
	public void delete(Long id) {
		eventRepository.deleteById(id);
	}
	
	public EventEntity findEventById(Long id) {
		EventEntity event = eventRepository.findByEventId(id);
		return event;
	}
}
