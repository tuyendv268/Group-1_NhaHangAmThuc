package com.cnpm.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cnpm.entity.BillEntity;
import com.cnpm.service.BillService;

@Controller
public class ReportController {
	@Autowired
	private BillService billService;
	
	

	@GetMapping(value = "/report")
	public String report(Model model) {
		
		ArrayList<BillEntity> paidBills = (ArrayList<BillEntity>) billService.findAllPaidBills();
		if(paidBills.size() != 0) {
		model.addAttribute("bills", paidBills);
		}
		
		return "report";
	}
}
