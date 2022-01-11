package com.cnpm.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cnpm.entity.EventEntity;
import com.cnpm.repository.EventRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository eventRepository;

	public EventEntity save(EventEntity eventEntity) {
		if (eventEntity.getTimeStart().before(eventEntity.getTimeEnd())) {
			return eventRepository.save(eventEntity);
		}
		return null;
	}

	@Scheduled(fixedDelay = 1000)
	public void checkTime() {
		List<EventEntity> events = eventRepository.findAll();
		
		for (EventEntity event : events) {
			if(event.isDisplayed()) {
				if(event.getTimeEnd().before(new Date())) {
					event.setDisplayed(false);
					System.out.println("Event ended : "+event.getEventName());
					eventRepository.save(event);
				}
			}else {
				if(event.getTimeStart().before(new Date()) && event.getTimeEnd().after(new Date())) {
					event.setDisplayed(true);
					System.out.println("Event started : "+event.getEventName());
					eventRepository.save(event);
				}
			}
			if(event.getTimeStart().getYear() != (new Date()).getYear()) {
				event.getTimeStart().setYear(new Date().getYear());
				event.getTimeEnd().setYear(new Date().getYear());
				eventRepository.save(event);
			}
		}
		// added sleep to simulate method
		// which takes longer to execute.
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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

	public List<EventEntity> findAll() {
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
