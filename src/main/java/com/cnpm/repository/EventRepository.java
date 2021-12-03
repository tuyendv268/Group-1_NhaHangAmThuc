package com.cnpm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnpm.entity.EventEntity;

public interface EventRepository extends JpaRepository<EventEntity, Long>{
	EventEntity findByEventName(String eventName);
	EventEntity findByEventId(Long id);
	EventEntity save(EventEntity event);
}
