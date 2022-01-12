package com.cnpm.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cnpm.dto.TableDTO;
import com.cnpm.entity.CustomerEntity;
import com.cnpm.entity.MembershipEntity;
import com.cnpm.entity.TableEntity;
import com.cnpm.service.CustomerService;
import com.cnpm.service.MembershipService;

@Controller
public class MembershipController {
	@Autowired
	private MembershipService membershipService;
	@Autowired
	private CustomerService customerService;

	@GetMapping(value = "/membership")
	public String display(Model model) {
		customerService.updateRankAllCustomers();		
		ArrayList<MembershipEntity> memberships = (ArrayList<MembershipEntity>)membershipService.findAll();
		ArrayList<CustomerEntity> customers = (ArrayList<CustomerEntity>)customerService.findAll();
		
		
		model.addAttribute("memberships", memberships);
		model.addAttribute("customers", customers);
		return "membership";
	}
	
	@RequestMapping(value = "/membership/new-customer", method = RequestMethod.POST, params = "add")
	public String newCustomer(Model model,
						   @RequestParam(value = "customerName") String customerName,
						   @RequestParam(value = "phone") String phone) {
		CustomerEntity newCustomer = new CustomerEntity();
		newCustomer.setCustormerName(customerName);
		newCustomer.setTelephone(phone);
		
		System.out.println("dis 1");
		
		customerService.addCustomer(newCustomer);
		return "redirect:/membership";
	}
	
	@RequestMapping(value = "/membership/new-customer", method=RequestMethod.POST, params = "cancel")
	public String cancelNewCustomer() {
		return "redirect:/membership";
	}
	
	@GetMapping(value = "/membership/{id}")
	public String deleteCustomer(@PathVariable Long id, Model model) {
		customerService.deleteById(id);
		System.out.println("Deleted Customer: "+ id);
		return "redirect:/event";
	}


//	@RequestMapping(value = "/menu/new-dish", method = RequestMethod.POST, params = "create")
//	public String addDish(@RequestParam("files") MultipartFile file, @RequestParam(value = "dishName") String dishName,
//			@RequestParam(value = "dishPrice") int dishPrice,
//			@RequestParam(value = "dishDescription") String dishDescription,
//			@RequestParam(value = "dishCategory") String dishCategory,
//			@RequestParam(value = "dishIngredient") String dishIngredient) {
//		
//		Path path = Paths.get("uploads/");
//		try {
//			InputStream inputStream = file.getInputStream();
//			Files.copy(inputStream, path.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
//			DishEntity newDish = new DishEntity();
//			newDish.setDishName(dishName);
//			newDish.setPrice(dishPrice);
//			newDish.setDescription(dishDescription);
//			newDish.setCategory(dishCategory);
//			newDish.setIngredient(dishIngredient);
//			newDish.setStatus(true);
//			newDish.setUrl(file.getOriginalFilename().toLowerCase());
//			dishService.addDish(newDish);
//
//		} catch (Exception e) {
//
//		}
//		return "redirect:/menu";
//	}
//	
//	@RequestMapping(value = "/menu/new-dish", method = RequestMethod.POST, params = "close")
//	 public String closeDish(){
//		  return "redirect:/menu";
//	  }
//	
//	@RequestMapping(value = "/menu/edit-dish", method = RequestMethod.POST, params = "done")
//	public String editDish(@RequestParam(value = "dishId") Long dishId, 
//			@RequestParam(value = "dishName") String dishName,
//			@RequestParam(value = "dishPrice") int dishPrice,
//			@RequestParam(value = "dishDescription") String dishDescription,
//			@RequestParam(value = "dishCategory") String dishCategory,
//			@RequestParam(value = "dishIngredient") String dishIngredient,
//			@RequestParam(value = "dishStatus",required = false) String dishStatus) {
//		if(dishStatus!=null)
//			dishService.editDish(dishId, dishName, dishPrice, dishDescription, dishCategory, dishIngredient, "true");
//		else if(dishStatus==null)
//			dishService.editDish(dishId, dishName, dishPrice, dishDescription, dishCategory, dishIngredient, "false");
//		return "redirect:/menu";
//	}
//	
//	@GetMapping(value="/menu/delete/{id}")
//	public String deleteDish(@PathVariable Long id) {
//		dishService.deleteDish(id);
//		return "redirect:/menu";
//	}
	

}