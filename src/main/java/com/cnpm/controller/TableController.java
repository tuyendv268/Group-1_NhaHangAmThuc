package com.cnpm.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cnpm.entity.TableEntity;
import com.cnpm.service.TableService;

@Controller
public class TableController {
	@Autowired
	private TableService tableService;
	
	@DeleteMapping(value = "/table/{id}")
	public String delete(@PathVariable int id) {
		tableService.delete(Long.getLong(""+id));
		System.out.println(id);
		return "seat";
	}
	
	@GetMapping(value = "/test")
	public String demo() {
		return "test";
	}
	
	@GetMapping(value = "/table")
	public String display(Model model) {
		ArrayList<TableEntity> tables =(ArrayList<TableEntity>) tableService.findAll();
		
		model.addAttribute("tables", tables);
		return "seat";
	}
}
