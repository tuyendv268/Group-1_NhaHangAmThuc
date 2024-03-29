package com.cnpm.controller;

import java.util.ArrayList;
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
import com.cnpm.entity.ComboEntity;
import com.cnpm.entity.CustomerEntity;
import com.cnpm.entity.DishEntity;
import com.cnpm.entity.TableEntity;
import com.cnpm.repository.BillDetailRepository;
import com.cnpm.repository.BillRepository;
import com.cnpm.repository.TableRepository;
import com.cnpm.service.BillService;
import com.cnpm.service.ComboService;
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
	@Autowired
	private ComboService comboService;
	@Autowired
	private BillDetailRepository billDetailRepository;

	@GetMapping(value = "/bill")
	public String display(Model model) {
		
		List<BillEntity> bills = billService.findUnpaidBill();
		for (BillEntity bill : bills) {
			billService.updateTotal(bill);
		}
		List<TableDTO> tables = tableService.findOccupied();
		tables.addAll(tableService.findReserved());
		tables.addAll(tableService.findAvailable());
		List<DishEntity> dishes = dishService.findAvailable();
		List<ComboEntity> combos = comboService.findAvailable();
		model.addAttribute("tables", tables);
		model.addAttribute("bills", bills);
		model.addAttribute("dishes", dishes);
		
		model.addAttribute("combos", combos);
		return "bill";
	}

	@GetMapping("/deleteBill/{id}")
	public String deleteBill(@PathVariable(value = "id") Long id) {

		BillEntity bill = billService.findBillById(id);
		List<TableEntity> tables = bill.getTables();
		for (TableEntity tableEntity : tables) {
			tableEntity.setBill(null);
			tableEntity.setGuest("");
			tableEntity.setPhone("");
			tableEntity.setStatus("available");
			tableService.save(tableEntity);
		}
		this.billService.deleteById(id);
		return "redirect:/bill";
	}

	@PostMapping(value = "/newBill")
	public String newBill(@RequestParam(value = "customerName") String customerName, @RequestParam String phone,
			@RequestParam String customerId, 
			@RequestParam(required = false, defaultValue = "") List<Long> selectTables, Model model) {
		BillEntity bill = new BillEntity();
		
		bill = billService.setDateandEvent(bill);
		
		CustomerEntity customer = new CustomerEntity();
		if (customerId != "") {
			customer = customerService.getById(Long.valueOf(customerId).longValue());
		} 
		else {
			customer = customerService.newCustomer(customerName, phone, (long) 6);
			customerService.addStranger(customer);
		}
		if(selectTables.size()>0) {
		List<TableEntity> tables = tableService.getByIds(selectTables);

		bill.setTables(tables);
		for (TableEntity table : tables) {
			
			table.setBill(bill);
			table.setGuest(customerName);
			table.setPhone(phone);
			table.setStatus("occupied");
		}
		}
		bill.setCustomer(customer);
		
		billService.save(bill);
		
		return ("redirect:/bill");
	}

	@PostMapping(value = "/addDishtobill")
	public String addDishtoBill(@RequestParam Long billId,
			@RequestParam(required = false, defaultValue = "") List<Integer> quantityDish,
			@RequestParam(required = false, defaultValue = "") List<Long> dishId,
			@RequestParam(required = false, defaultValue = "") List<Integer> quantityCombo,
			@RequestParam(required = false, defaultValue = "") List<Long> comboId) {
		List<BillDetail> billdetails = billService.findBillById(billId).getBillDetails();
		billService.findBillById(billId).setBillDetails(null);
		for (BillDetail billdetail : billdetails) {
			billdetail.setBill(null);
			billDetailRepository.delete(billdetail);
		}
		if (dishId.size() > 0) {

			for (int i = 0; i < dishId.size(); i++) {
				billService.addDish(billId, dishId.get(i), quantityDish.get(i));
			}
		}
		if (comboId.size() > 0) {

			for (int i = 0; i < comboId.size(); i++) {
				billService.addCombo(billId, comboId.get(i), quantityCombo.get(i));
			}

		}
		return ("redirect:/bill");
	}

	@GetMapping("/payBill/{id}")
	public String payBill(@PathVariable(value = "id") Long id) {
		
		BillEntity bill = billService.payBill(id);
		if(bill.getCustomer().getMembership().getName() !="Stranger")
			customerService.addPoint(bill.getCustomer(), bill.getFinalTotal());
		return "redirect:/bill";
	}

	@GetMapping(value = "/searchBill")
	public String search (@RequestParam String customerName, Model model){
		String customername = customerName.toLowerCase();
		List<BillEntity> bills = new ArrayList<BillEntity>();
		List<CustomerEntity> customers = customerService.findAll();
		for(CustomerEntity customer : customers) {
			System.out.println(customer.getCustomerName());
			if(customer.getCustomerName().toLowerCase().contains(customername)) {
				
				bills.addAll(customer.getBills());
			}
		}
		
		for (BillEntity bill : bills) {
			billService.updateTotal(bill);
		}
		List<TableDTO> tables = tableService.findOccupied();
		tables.addAll(tableService.findAvailable());
		tables.addAll(tableService.findReserved());
		List<DishEntity> dishes = dishService.findAvailable();
		List<ComboEntity> combos = comboService.findAvailable();
		model.addAttribute("tables", tables);
		model.addAttribute("bills", bills);
		model.addAttribute("dishes", dishes);
		model.addAttribute("searchvalue", customerName);
		model.addAttribute("combos", combos);
		return "bill";
	}
	
	@PostMapping("/editBill")
	public String editBill(@RequestParam Long billId,
			@RequestParam String customerName, 
			@RequestParam String phone,
			
			@RequestParam(required = false, defaultValue = "") List<Long> selectTables, 
			Model model) {
		
		BillEntity bill = billService.findBillById(billId);
		bill.getCustomer().setCustomerName(customerName);
		bill.getCustomer().setTelephone(phone);
		
		billService.save(bill);
		
		
		List<TableEntity> billtables = bill.getTables();
		for (TableEntity tableEntity : billtables) {
			tableEntity.setBill(null);
			tableEntity.setGuest("");
			tableEntity.setPhone("");
			tableEntity.setStatus("available");
			tableService.save(tableEntity);
		}
		
		if(selectTables.size()>0) {
			List<TableEntity> tables = tableService.getByIds(selectTables);
			
			bill.setTables(tables);
			for (TableEntity table : tables) {
				
				table.setBill(bill);
				table.setGuest(customerName);
				table.setPhone(phone);
				table.setStatus("occupied");
			}
			}
		billService.save(bill);
		System.out.println(billId);
		return "redirect:/bill";
	}
}