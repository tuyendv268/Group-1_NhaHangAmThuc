package com.cnpm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnpm.entity.EventEntity;
import com.cnpm.repository.EventRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository eventRepository;
	
	public boolean save(EventEntity eventEntity) {
		EventEntity event = eventRepository.save(eventEntity);
		if(event == null) {
			return false;
		}
		return true;
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
