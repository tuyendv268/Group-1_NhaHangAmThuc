package com.cnpm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnpm.entity.DishInComboEntity;
import com.cnpm.repository.DishInComboRepository;

@Service
public class DishInComboService {
	@Autowired 
	private DishInComboRepository dishInComboRepository;
	
	public List<DishInComboEntity> findAll(){
		return dishInComboRepository.findAll();
	}
	
	public DishInComboEntity addDishInCombo(DishInComboEntity dishInComboEntity) {
		return dishInComboRepository.save(dishInComboEntity);
	}
	
	
}
