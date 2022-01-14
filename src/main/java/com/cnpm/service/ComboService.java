package com.cnpm.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cnpm.entity.ComboEntity;
import com.cnpm.entity.DishEntity;
import com.cnpm.entity.DishInComboEntity;
import com.cnpm.repository.ComboRepository;

@Service
public class ComboService {
	@Autowired
	private ComboRepository comboRepository;
	@Autowired
	private DishService dishService;
	@Autowired
	private DishInComboService dishInComboService;
	
	public ComboEntity addCombo(ComboEntity combo) {
		return comboRepository.save(combo);
	}
	
	public List<ComboEntity> findAll(){
		return comboRepository.findAll();
	}
	
	public List<ComboEntity> findByName(String comboName){
		return comboRepository.findByComboName(comboName);
	}
	
	public ComboEntity findById(Long id) {
		return comboRepository.findByComboId(id);
	}
	
	public ComboEntity deleteCombo(Long id) {
		ComboEntity combo = findById(id);
		combo.setStatus(false);		
		return comboRepository.save(combo);
	}
	
	public ComboEntity editCombo(Long comboId, String comboName, int comboPrice, String comboDescription, int comboAmountOfPeople, int comboDiscountRate, String list_of_dishes_in_combo_edit) {
		ComboEntity combo= findById(comboId);
		combo.setComboName(comboName);
		combo.setPrice(comboPrice);
		combo.setDescription(comboDescription);
		combo.setNumberOfPeopleRecommend(comboAmountOfPeople);
		combo.setDiscountRate(comboDiscountRate);
		
//		System.out.println(list_of_dishes_in_combo_edit);
		String[] dishesInCombo = list_of_dishes_in_combo_edit.split(",");
		
		//tÃ¬m táº¥t cáº£ dishincombo theo comboId vÃ  xÃ³a sáº¡ch
		dishInComboService.deleteListOfDishInCombo(combo);
		//khá»Ÿi táº¡o láº¡i tá»« Ä‘áº§u
		ArrayList<DishInComboEntity> listOfDishInComboEntity = new ArrayList<DishInComboEntity>();
		
		for(int i=0;i<dishesInCombo.length;i++) {				
//			System.out.println(dishesInCombo[i]);	
			if(i%2==1) continue;
			DishEntity dishEntity = dishService.findByName(dishesInCombo[i]);
//			System.out.println("DishEntity:" +dishEntity.getDishId());
			
			DishInComboEntity dishInComboEntity = new DishInComboEntity();
			listOfDishInComboEntity.add(dishInComboEntity);
			
			dishInComboEntity.setDish(dishEntity);
			dishEntity.setDishInComboEntities(oneElement(dishInComboEntity));
			
			dishInComboEntity.setCombo(combo);
			dishInComboEntity.setQuantity(Long.valueOf(dishesInCombo[i+1]));
			dishInComboService.addDishInCombo(dishInComboEntity);
//			System.out.println("DishInCombo:"+dishInComboEntity.getId());
			dishService.addDish(dishEntity);
			
		}
		combo.setDishInComboEntities(listOfDishInComboEntity);		
		return addCombo(combo);
		
	}
	
	public ArrayList<DishInComboEntity> oneElement(DishInComboEntity dishInComboEntity) {
		ArrayList<DishInComboEntity> list = new ArrayList<DishInComboEntity>();
		list.add(dishInComboEntity);
		return list;
	}
}
