package com.cnpm.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cnpm.entity.ComboEntity;
import com.cnpm.entity.DishEntity;
import com.cnpm.repository.ComboRepository;

@Service
public class ComboService {
	@Autowired
	private ComboRepository comboRepository;
	
	
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
	
	public ComboEntity editCombo(Long comboId, String comboName, int comboPrice, String comboDescription, int comboAmountOfPeople, int comboDiscountRate) {
		ComboEntity combo= findById(comboId);
		combo.setComboName(comboName);
		combo.setPrice(comboPrice);
		combo.setDescription(comboDescription);
		combo.setNumberOfPeopleRecommend(comboAmountOfPeople);
		combo.setDiscountRate(comboDiscountRate);
		return comboRepository.save(combo);
	}
}
