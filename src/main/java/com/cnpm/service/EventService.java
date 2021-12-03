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
}
