package com.cnpm.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@GetMapping(value = "/table/{id}/info")
	public String getInfo(@PathVariable Long id, Model model) {
		TableEntity table = tableService.findByID(id);
		if(table != null) {
			model.addAttribute("table_info", table);
		}else {
			System.out.println("NULL");
		}
		return "seat";
	}

	@GetMapping(value = "/table")
	public String display(Model model) {
		ArrayList<TableEntity> tables = (ArrayList<TableEntity>) tableService.findAll();

		model.addAttribute("tables", tables);
		return "seat";
	}
}
