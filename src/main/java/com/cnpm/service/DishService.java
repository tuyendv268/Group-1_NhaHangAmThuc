package com.cnpm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.cnpm.dto.TableDTO;
import com.cnpm.entity.DishEntity;
import com.cnpm.repository.DishInComboRepository;
import com.cnpm.repository.DishRepository;

@Service
public class DishService {
	@Autowired
	private DishRepository dishRepository;
	@Autowired
	private DishInComboRepository dishInComboRepository;
	
	
	public DishEntity addDish(DishEntity dish) {
		return dishRepository.save(dish);
	}
	
	public List<DishEntity> findAll(){
		return dishRepository.findAll();
	}
	
	public List<DishEntity> findElementsByName(String dishName){
		return dishRepository.findAll();
	}
	
	
	public DishEntity findById(Long id) {
		return dishRepository.findByDishId(id);
	}
	
	public DishEntity findByName (String dishName) {
		return dishRepository.findByDishName(dishName);
	}
	
	public DishEntity editDish(Long id,String dishName,int dishPrice,String dishDescription, String dishCategory,String dishIngredient) {
		DishEntity dish = findById(id);
		dish.setDishName(dishName);
		dish.setPrice(dishPrice);
		dish.setDescription(dishDescription);
		dish.setCategory(dishCategory);
		dish.setIngredient(dishIngredient);
	
		return dishRepository.save(dish);
	}
	
	public DishEntity deleteDish(Long id) {
		DishEntity dish = findById(id);
		dish.setStatus(false);		
		return dishRepository.save(dish);
	}
	
	public ArrayList<Object[]> findDishesInCombo(Long comboid){
		ArrayList<Object[]> cursor = (ArrayList<Object[]>) dishInComboRepository.findDishesInCombo(comboid);
		return cursor;
	}
}