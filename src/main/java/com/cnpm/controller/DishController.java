package com.cnpm.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cnpm.entity.ComboEntity;
import com.cnpm.entity.DishEntity;
import com.cnpm.service.ComboService;
import com.cnpm.service.DishService;

@Controller
public class DishController {
	@Autowired
	private DishService dishService;
	@Autowired
	private ComboService comboService;

	@GetMapping(value = "/menu")
	public String menu(Model model, @RequestParam(value = "combo_dish",required= false) String combo_dish) {
		if(combo_dish==null || combo_dish=="") {
			ArrayList<DishEntity> dishes = (ArrayList<DishEntity>) dishService.findAll();
			model.addAttribute("dishes", dishes);
			ArrayList<ComboEntity> combos = (ArrayList<ComboEntity>) comboService.findAll();
			model.addAttribute("combos", combos);
		}else {
			//thử tìm combo trước
			ArrayList<ComboEntity> combos =(ArrayList<ComboEntity>) comboService.findByName(combo_dish);
			//thấy combo
			if(combos.size()!=0) {
				System.out.println(" thấy combo");	
				model.addAttribute("combos", combos);
				ArrayList<DishEntity> dishes = (ArrayList<DishEntity>) dishService.findAll();
				model.addAttribute("dishes", dishes);
			}
			//combo không thấy thì thử tìm bằng dish
			else {
				System.out.println("không thấy combo");
				ArrayList<DishEntity> dishes = new ArrayList<DishEntity>();
				DishEntity dish= dishService.findByName(combo_dish);
				//thấy dish
				if(dish!=null) {
					System.out.println("thấy dish");
					dishes.add(dish);
					model.addAttribute("dishes", dishes);
					combos = (ArrayList<ComboEntity>) comboService.findAll();
					model.addAttribute("combos", combos);
				}
				//không thấy dish và combo
				else {
					System.out.println("không thấy dish");
					combos = (ArrayList<ComboEntity>) comboService.findAll();
					model.addAttribute("combos", combos);
					dishes = (ArrayList<DishEntity>) dishService.findAll();
					model.addAttribute("dishes", dishes);
				}
			}
		}
		return "menu";
	}

	
	@RequestMapping(value = "/menu/new-dish", method = RequestMethod.POST, params = "create")
	public String addDish(Model model, @RequestParam("files") MultipartFile file, 
			@RequestParam(value = "dishName") String dishName,
			@RequestParam(value = "dishPrice") int dishPrice,
			@RequestParam(value = "dishDescription") String dishDescription,
			@RequestParam(value = "dishCategory") String dishCategory,
			@RequestParam(value = "dishIngredient") String dishIngredient) {
		
		Path path = Paths.get("uploads/");
		try {
			InputStream inputStream = file.getInputStream();
			Files.copy(inputStream, path.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			DishEntity newDish = new DishEntity();
			newDish.setDishName(dishName);
			newDish.setPrice(dishPrice);
			newDish.setDescription(dishDescription);
			newDish.setCategory(dishCategory);
			newDish.setIngredient(dishIngredient);
			newDish.setStatus(true);
			newDish.setUrl(file.getOriginalFilename().toLowerCase());
			dishService.addDish(newDish);

		} catch (Exception e) {

		}
		return "redirect:/menu";
	}
	
	@RequestMapping(value = "/menu/new-dish", method = RequestMethod.POST, params = "close")
	 public String closeDish(){
		  return "redirect:/menu";
	  }
	
	@RequestMapping(value = "/menu/edit-dish", method = RequestMethod.POST, params = "done")
	public String editDish(@RequestParam(value = "dishId") Long dishId, 
			@RequestParam(value = "dishName") String dishName,
			@RequestParam(value = "dishPrice") int dishPrice,
			@RequestParam(value = "dishDescription") String dishDescription,
			@RequestParam(value = "dishCategory") String dishCategory,
			@RequestParam(value = "dishIngredient") String dishIngredient) {
			dishService.editDish(dishId, dishName, dishPrice, dishDescription, dishCategory, dishIngredient);
	
		return "redirect:/menu";
	}
	
	@GetMapping(value="/menu/delete/{id}")
	public String deleteDish(@PathVariable Long id) {
		dishService.deleteDish(id);
		return "redirect:/menu";
	}
	

}