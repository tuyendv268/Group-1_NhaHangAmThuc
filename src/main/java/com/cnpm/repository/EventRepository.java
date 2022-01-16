package com.cnpm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cnpm.entity.EventEntity;

public interface EventRepository extends CrudRepository<EventEntity, Long>{
	List<EventEntity> findByEventName(String eventName);
	EventEntity findByEventId(Long id);
	EventEntity save(EventEntity event);
	List<EventEntity> findAll();
	List<EventEntity> findByOrderByDiscountRateDesc();
}