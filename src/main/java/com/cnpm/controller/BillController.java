package com.cnpm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.cnpm.entity.BillEntity;
import com.cnpm.service.BillService;
import com.cnpm.service.TableService;
@Controller
public class BillController {
	@Autowired
	private BillService billService;
	@Autowired
	private TableService tableService;
	@GetMapping(value = "/bill")
	public String display(Model model) {
		List<BillEntity> bills = billService.findAll();
		
		model.addAttribute("bills", bills);
		return "bill";
	}
	@GetMapping("/deleteBill/{id}")
	public String deleteBill(@PathVariable (value = "id") Long id) {
		
		// call delete employee method 	
		//List<TableEntity> tablebill = tableService.findByBill(id);
//		BillEntity bill = billService.find
		this.billService.deleteById(id);
//		for(int i=0; i< tablebill.size(); i++) {
//			tablebill.get(i).setBill(null);
//			tableService.save(tablebill.get(i));
//		}
		return "redirect:/bill";
	}
	
	@GetMapping(value = "/newBill")
	public String newBill(@RequestParam String customerName, @RequestParam String phone
			,@RequestParam String customerId, Model model) {
		System.out.println(customerName);
		System.out.println(phone);
		System.out.println(customerId);
		System.out.println("ủa");
		
		return("redirect:/bill");
	}
	// @GetMapping(value = "/editBill/{id}")
}