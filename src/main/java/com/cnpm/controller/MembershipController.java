package com.cnpm.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		newCustomer.setCustomerName(customerName);
		newCustomer.setTelephone(phone);
		
		System.out.println("dis 1");
		
		customerService.addCustomer(newCustomer);
		return "redirect:/membership";
	}
	
	@RequestMapping(value = "/membership/new-customer", method=RequestMethod.POST, params = "cancel")
	public String cancelNewCustomer() {
		return "redirect:/membership";
	}
	
	@GetMapping(value = "/membership/delete/{id}")
	public String deleteCustomer(@PathVariable Long id, Model model) {
		customerService.deleteCustomer(id);
		System.out.println("Deleted Customer: " + id);
		return "redirect:/membership";
	}
	
	
	@RequestMapping(value = "/membership/edit-customer/", method = RequestMethod.POST, params = "edit")
	public String editCustomer(Model model,
				 @RequestParam(value = "customerId") Long id,
				 @RequestParam(value = "customerName") String customerName,
				 @RequestParam(value = "phone") String phone) {
		customerService.editCustomerInfo(id, customerName, phone);
		System.out.print("edited");
		return "redirect:/membership";
	}
	
	@RequestMapping(value = "/membership/edit-customer/", method = RequestMethod.POST, params = "cancel")
	public String cancelEditCustomer() {
		return "redirect:/membership";
	}

	@RequestMapping(value = "/membership/edit-discountrate/", method = RequestMethod.POST, params = "edit")
	public String editDiscountRate(Model model,
				 @RequestParam(value = "customerId") Long id,
				 @RequestParam(value = "discountRate") int discountRate) {
		membershipService.editDiscountRate(id, discountRate);
		return "redirect:/membership";
	}
}