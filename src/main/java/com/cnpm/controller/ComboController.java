package com.cnpm.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cnpm.dto.TableDTO;
import com.cnpm.entity.ComboEntity;
import com.cnpm.entity.DishEntity;
import com.cnpm.entity.DishInComboEntity;
import com.cnpm.service.ComboService;
import com.cnpm.service.DishInComboService;
import com.cnpm.service.DishService;


@Controller
public class ComboController {
	@Autowired
	private ComboService comboService;
	@Autowired
	private DishService dishService;
	
	@Autowired
	private DishInComboService dishInComboService;
	
	@RequestMapping(value = "/menu/new-combo", method = RequestMethod.POST, params = "create")
	public String addCombo(@RequestParam("files") MultipartFile file, 
			@RequestParam(value = "comboName") String comboName,
			@RequestParam(value = "comboPrice") int comboPrice,
			@RequestParam(value = "comboDescription") String comboDescription,
			@RequestParam(value = "comboAmountOfPeople") int comboAmountOfPeople,
			@RequestParam(value = "comboDiscountRate") int comboDiscountRate,
			@RequestParam(value= "list_of_dishes_in_combo") String list_of_dishes_in_combo) {
		
		ComboEntity newCombo = new ComboEntity();
		Path path = Paths.get("uploads/");
		try {
			InputStream inputStream = file.getInputStream();
			Files.copy(inputStream, path.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
			newCombo.setComboName(comboName);
			newCombo.setPrice(comboPrice);
			newCombo.setDescription(comboDescription);
			newCombo.setNumberOfPeopleRecommend(comboAmountOfPeople);
			newCombo.setDiscountRate(comboDiscountRate);
			newCombo.setUrl(file.getOriginalFilename().toLowerCase());
			newCombo.setStatus(true);
			comboService.addCombo(newCombo);
		} catch (Exception e) {

		}	
			System.out.println(list_of_dishes_in_combo);
			String[] dishesInCombo = list_of_dishes_in_combo.split(",");
			
	
			ArrayList<DishInComboEntity> listOfDishInComboEntity = new ArrayList<DishInComboEntity>();
			
			for(int i=0;i<dishesInCombo.length;i++) {				
				System.out.println(dishesInCombo[i]);	
				if(i%2==1) continue;
				DishEntity dishEntity = dishService.findByName(dishesInCombo[i]);
				System.out.println("DishEntity:" +dishEntity.getDishId());
				
				DishInComboEntity dishInComboEntity = new DishInComboEntity();
				listOfDishInComboEntity.add(dishInComboEntity);
				
				dishInComboEntity.setDish(dishEntity);
				dishEntity.setDishInComboEntities(oneElement(dishInComboEntity));
				
				dishInComboEntity.setCombo(newCombo);
				dishInComboEntity.setQuantity(Long.valueOf(dishesInCombo[i+1]));
				dishInComboService.addDishInCombo(dishInComboEntity);
				System.out.println("DishInCombo:"+dishInComboEntity.getId());
				dishService.addDish(dishEntity);
				
			}
			newCombo.setDishInComboEntities(listOfDishInComboEntity);
			comboService.addCombo(newCombo);
			
		
		return "redirect:/menu";
	}
	
	public ArrayList<DishInComboEntity> oneElement(DishInComboEntity dishInComboEntity) {
		ArrayList<DishInComboEntity> list = new ArrayList<DishInComboEntity>();
		list.add(dishInComboEntity);
		return list;
	}
	
	@GetMapping(value="/menu/delete/combo/{id}")
	public String deleteCombo(@PathVariable Long id) {
		comboService.deleteCombo(id);
		return "redirect:/menu";
	}
	
	@RequestMapping(value = "/menu/edit-combo", method = RequestMethod.POST, params = "done")
	public String editCombo(@RequestParam(value = "comboId") Long comboId, 
			@RequestParam(value = "comboName") String comboName,
			@RequestParam(value = "comboPrice") int comboPrice,
			@RequestParam(value = "comboDescription") String comboDescription,
			@RequestParam(value = "comboAmountOfPeople") int comboAmountOfPeople,
			@RequestParam(value = "comboDiscountRate") int comboDiscountRate) {		
			comboService.editCombo(comboId, comboName, comboPrice, comboDescription, comboAmountOfPeople, comboDiscountRate);
		return "redirect:/menu";
	}
}
