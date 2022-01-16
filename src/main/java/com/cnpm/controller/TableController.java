package com.cnpm.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@GetMapping(value = "/table/use/{id}")
	public String useTable(@PathVariable Long id) {
		tableService.useTable(id);
		return "redirect:/table";
	}

	@GetMapping(value = "/table/cancel/{id}")
	public String calcelTable(@PathVariable Long id) {
		tableService.cancelTable(id);
		return "redirect:/table";
	}

	@GetMapping(value = "/table/search")
	public String searchTable(@RequestParam(value = "tableName") String tableName, Model model, RedirectAttributes redirectAttributes) {
		ArrayList<TableDTO> tables = (ArrayList<TableDTO>) tableService.find(tableName);
		if (tables != null) {
			model.addAttribute("tables", tables);
			return "seat";
		} else {
			redirectAttributes.addFlashAttribute("message", "Không Tìm Thấy Bàn!!!");
			return "redirect:/table";
		}
	}

	@RequestMapping(value = "/table/new-table", method = RequestMethod.POST, params = "add")
	public String newTable(@RequestParam(value = "tableName") String tableName, RedirectAttributes redirectAttributes) {
		TableEntity newTable = new TableEntity();
		newTable.setTableName(tableName);
		newTable.setStatus(TableDTO.available);

		if (tableService.save(newTable) == null) {
			System.out.println("Trùng Tên");
			redirectAttributes.addFlashAttribute("message", "Trùng Tên Bàn. Vui Lòng Thử Lại !!!");
		}else {
			redirectAttributes.addFlashAttribute("message", "Thêm Bàn Thành Công!!!");
		}
		return "redirect:/table";
	}

	@RequestMapping(value = "/table/new-table", method = RequestMethod.POST, params = "cancel")
	public String cancelAddTB() {
		return "redirect:/table";
	}

	@GetMapping(value = "/table/order", params = "add")
	public String orderTable(@RequestParam(value = "id") Long id, @RequestParam(value = "guestName") String guestName,
			@RequestParam(value = "phone") String phone, RedirectAttributes redirectAttributes) {
		if(tableService.orderTable(id, guestName, phone) == null) {
			redirectAttributes.addFlashAttribute("message", "Vui Lòng Nhập Đầy Đủ Thông Tin !!!");
		}
		return "redirect:/table";
	}

	@GetMapping(value = "/table/order", params = "cancel")
	public String cancelOrderTable() {
		return "redirect:/table";
	}

	@GetMapping(value = "/table")
	public String display(Model model) {
		ArrayList<TableDTO> tables = (ArrayList<TableDTO>) tableService.findAll();

		TableDTO temp = tables.get(3);
		model.addAttribute("tables", tables);
		return "seat";
	}

}
