package com.cnpm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class BillController {
	@GetMapping(value = "/bill")
	public String display() {
		return "bill";
	}
}
