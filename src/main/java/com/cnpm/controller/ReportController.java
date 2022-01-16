package com.cnpm.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		
		ArrayList<String> months = new ArrayList<String>();
		months.add("Jan");
		months.add("Feb");
		months.add("Mar");
		months.add("Apr");
		months.add("May");
		months.add("Jun");
		months.add("Jul");
		months.add("Aug");
		months.add("Sep");
		months.add("Oct");
		months.add("Nov");
		months.add("Dec");
		model.addAttribute("Categories", months);

		ArrayList<Integer> revenue = new ArrayList<Integer>();
		for (int i = 1; i <= 12; i++) {
			revenue.add(0);
		}
		ArrayList<Object[]> cursor = billService.findRevenueDueMonth(2021, 1, 12);
		for (Object[] ob : cursor) {
			int month = Integer.valueOf(String.valueOf(ob[0]));
			int revenueAMonth = Integer.valueOf(String.valueOf(ob[1]));
			revenue.set(month - 1, revenueAMonth);
		}
		model.addAttribute("Revenue", revenue);
		
		return "report";
	}
	
	//thống kê theo năm
	 @RequestMapping(value = "/report/statistic", method = RequestMethod.GET, params="statistic")
	public String statistic( @RequestParam("startday") String startday, @RequestParam("endday") String endday, Model model){
		System.out.println("voly1");
		int yearstart,yearend;
		try {
			 Date start = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(startday);
			 yearstart=start.getYear()+1900;	
			 Date end = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(endday);
			 yearend=end.getYear()+1900;
			 System.out.println(yearstart+"/"+yearend);
		}catch (Exception e) {
			System.out.println("khong duoc");
			yearstart=2021;
			yearend=2022;
		}
		 ArrayList<Integer> years = new ArrayList<Integer>();		
		 for(int i=yearstart;i<=yearend;i++) {
			 years.add(i);
		 }
		
		 model.addAttribute("Categories",years); 
		 ArrayList<Integer> revenue = new ArrayList<Integer>();
		 ArrayList<Object[]> cursor =billService.findRevenueDueYear(yearstart, yearend);
		 for (Object[] ob : cursor){
			int revenueAYear = Integer.valueOf(String.valueOf(ob[1]));
			revenue.add(revenueAYear);
		}
			model.addAttribute("Revenue",revenue);
		return "report";
	}
	 
	 
	 //thống kê theo tháng
	 @RequestMapping(value = "/report/statistic", method = RequestMethod.GET, params="statisticDueMonth")
	public String statisticDueMonth( @RequestParam("startday") String startday, @RequestParam("endday") String endday, Model model){
		System.out.println("voly2");
		int year,monthstart,monthend;
		try {
			 Date start = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(startday);
			 System.out.println(start.toString());
			 year = start.getYear()+1900;			
			 monthstart=start.getMonth()+1;		
			 Date end = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(endday);
			 monthend=end.getMonth()+1;

		}catch (Exception e) {
			System.out.println("khong duoc");
			year=2021;
			monthstart=1;
			monthend=12;
		}
		
				
		ArrayList<String> months = new ArrayList<String>();
		months.add("Jan");
		months.add("Feb");
		months.add("Mar");
		months.add("Apr");
		months.add("May");
		months.add("Jun");
		months.add("Jul");
		months.add("Aug");
		months.add("Sep");
		months.add("Oct");
		months.add("Nov");
		months.add("Dec");
		model.addAttribute("Categories", months);

		ArrayList<Integer> revenue = new ArrayList<Integer>();
		for (int i = 1; i <= 12; i++) {
			revenue.add(0);
		}
		ArrayList<Object[]> cursor = billService.findRevenueDueMonth(year,monthstart, monthend);
		for (Object[] ob : cursor) {
			int month = Integer.valueOf(String.valueOf(ob[0]));
			int revenueAMonth = Integer.valueOf(String.valueOf(ob[1]));
			revenue.set(month - 1, revenueAMonth);
		}
		model.addAttribute("Revenue", revenue);
		return "report";
	}
}
