package com.cnpm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.cnpm.dto.TableDTO;
import com.cnpm.entity.TableEntity;
import com.cnpm.service.TableService;

@Controller
public class TableController {
	@Autowired
	private TableService tableService;

	@GetMapping(value = "/table/{id}")
	public String delete(@PathVariable Long id, Model model) {
		tableService.delete(id);
		System.out.println(id);
		return "redirect:/table";
	}

	@GetMapping(value = "/test")
	public String demo() {
		return "test";
	}
	
	@GetMapping(value = "/table/search")
	public String searchTable(@RequestParam(value = "tableName") String tableName, Model model) {
		ArrayList<TableDTO> tables =(ArrayList<TableDTO>) tableService.find(tableName);
		if(tables != null) {
			model.addAttribute("tables", tables);
		}
		return "seat";
	}
	
	@GetMapping(value = "/table/new-table")
	public String newTable(@RequestParam(value = "tableName") String tableName) {
		TableEntity newTable = new TableEntity();
		newTable.setTableName(tableName);
		newTable.setStatus(TableDTO.available);
		
		if(tableService.save(newTable) == null) {
			System.out.println("Trùng Tên");
		}
		return "redirect:/table";
	}
	
	@GetMapping(value = "/table/order")
	public String orderTable(
			@RequestParam(value = "id") Long id, 
			@RequestParam(value = "guestName") String guestName,
			@RequestParam(value = "phone") String phone
			) {
		tableService.orderTable(id, guestName, phone);
		return "redirect:/table";
	}
//	th:data-customerName="${table.getBill().getCustomer().getCustormerName()}"
	
	@GetMapping(value = "/table")
	public String display(Model model) {
		ArrayList<TableDTO> tables = (ArrayList<TableDTO>)tableService.findAll();
		
		TableDTO temp = tables.get(3);
		System.out.println(temp.getGuestName());
		System.out.println(temp.getTelephone());
		model.addAttribute("tables", tables);
		return "seat";
	}

}
