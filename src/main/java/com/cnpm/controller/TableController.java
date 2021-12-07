package com.cnpm.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cnpm.entity.TableEntity;
import com.cnpm.service.TableService;

@Controller
public class TableController {
	@Autowired
	private TableService tableService;
	
	@RequestMapping("/loop-example")
	public String loopExample(Model model) {
		ArrayList<TableEntity> tables =(ArrayList<TableEntity>) tableService.findAll();
		
		for (TableEntity tableEntity : tables) {
			System.out.println(tableEntity.getTableName());
		}
		
		model.addAttribute("tables", tables);
	    return "loop-example";
	}
	
	@GetMapping(value = "/demo")
	public String display(Model model) {
		ArrayList<TableEntity> tables =(ArrayList<TableEntity>) tableService.findAll();
		
		model.addAttribute("tables", tables);
		return "seat";
	}
}
