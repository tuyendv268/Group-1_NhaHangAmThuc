package com.cnpm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cnpm.dto.TableDTO;

import com.cnpm.entity.BillDetail;

import com.cnpm.entity.BillEntity;
import com.cnpm.entity.CustomerEntity;
import com.cnpm.entity.DishEntity;
import com.cnpm.entity.TableEntity;
import com.cnpm.repository.TableRepository;
import com.cnpm.service.BillService;
import com.cnpm.service.CustomerService;
import com.cnpm.service.DishService;
import com.cnpm.service.TableService;
@Controller
public class BillController {
	@Autowired
	private BillService billService;
	@Autowired
	private TableService tableService;
	@Autowired
	private CustomerService customerService;
	@Autowired 
	private DishService dishService;
	@GetMapping(value = "/bill")
	public String display(Model model) {
		List<BillEntity> bills = billService.findUnpaidBill();
		List<TableDTO> tables = tableService.findAvailable();
		tables.addAll(tableService.findReserved());
		List<DishEntity> dishes = dishService.findAll();
		model.addAttribute("tables", tables);
		model.addAttribute("bills", bills);
		model.addAttribute("dishes", dishes);
		return "bill";
	}
	@GetMapping("/deleteBill/{id}")
	public String deleteBill(@PathVariable (value = "id") Long id) {

		BillEntity bill = billService.findBillById(id);
		List<TableEntity> tables = bill.getTables();
		for (TableEntity tableEntity : tables) {
			tableEntity.setBill(null);
			tableService.save(tableEntity);
		}
		this.billService.deleteById(id);
		return "redirect:/bill";
	}
	
	@PostMapping(value = "/newBill")
	public String newBill(@RequestParam(value = "customerName") String customerName, 
			@RequestParam String phone,
			@RequestParam String customerId,
			@RequestParam List<Long> selectTables, 
			Model model) {
		BillEntity bill = new BillEntity();
		CustomerEntity customer = new CustomerEntity();
		if(customerId != "") {
			customer = customerService.getById(Long.valueOf(customerId).longValue());
		}else  customer = customerService.newCustomer(customerName, phone, (long) 6);
		customerService.addStranger(customer);
		List<TableEntity> tables = tableService.getByIds(selectTables);
		
		
		bill.setTables(tables);
		for(TableEntity table : tables ) {
			if(table.getStatus() == "reserved") {
				
			}
			table.setBill(bill);
			table.setGuest(customerName);
			table.setPhone(phone);
			table.setStatus("occupied");
		}
		bill.setCustomer(customer);
		billService.save(bill);
		System.out.println(selectTables.get(0));
		return("redirect:/bill");
	}
	
	@GetMapping("/payBill/{id}")
	public String payBill(@PathVariable (value = "id") Long id) {

		BillEntity bill = billService.findBillById(id);
		List<TableEntity> tables = bill.getTables();
		for (TableEntity tableEntity : tables) {
			tableEntity.setBill(null);
			tableService.save(tableEntity);
		}
		this.billService.deleteById(id);
		return "redirect:/bill";
	}
	
	
	
	
//	@GetMapping("/editBill/{id}")
//	public String editBill(@PathVariable (value = "id") Long id,
//			@RequestParam(value = "customerName") String customerName, 
//			@RequestParam String phone,
//			@RequestParam String customerId,
//			@RequestParam List<Long> selectTables, 
//			Model model) {
//		
//		BillEntity bill = billService.findBillById(id);
//		List<TableEntity> tables = bill.getTables();
//		for (TableEntity tableEntity : tables) {
//			tableEntity.setBill(null);
//			tableService.save(tableEntity);
//		}
//		this.billService.deleteById(id);
//		return "redirect:/bill";
//	}
}