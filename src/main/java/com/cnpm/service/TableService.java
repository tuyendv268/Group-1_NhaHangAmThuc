package com.cnpm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnpm.dto.TableDTO;
import com.cnpm.entity.BillEntity;
import com.cnpm.entity.CustomerEntity;
import com.cnpm.entity.TableEntity;
import com.cnpm.repository.TableRepository;

@Service
public class TableService {
	@Autowired
	private TableRepository tableRepository;
	
	public List<TableDTO> findAll(){
		return convert2DTO(tableRepository.findAll());
	}
	
	public void delete(Long id) {
		tableRepository.deleteById(id);
	}
	
	public TableEntity findByID(Long id) {
		return tableRepository.findByTableId(id);
	}
	
	public TableEntity orderTable(Long id, String guestName, String phone) {
		TableEntity table = findByID(id);
		table.setGuest(guestName);
		table.setPhone(phone);
		table.setStatus(TableDTO.reserved);
		System.out.println(table.getGuest());
		System.out.println(table.getPhone());
		return tableRepository.save(table);
	}
	
	public List<TableDTO> find(String tableName){
		List<TableDTO> tables = convert2DTO(tableRepository.findByTableName(tableName));
		if(tables.size() == 0) {
			return null;
		}
		return tables;
	}
	
	public TableEntity save(TableEntity newTable) {
		List<TableEntity> tables = tableRepository.findAll();
		for (TableEntity tableEntity : tables) {
			if(newTable.getTableName().equals(tableEntity.getTableName())) {
				return null;
			}
		}
		return tableRepository.save(newTable);
	}
	
	public TableDTO convert2DTO(TableEntity tableEntity) {
		Long tableId = tableEntity.getTableId();
		String status = tableEntity.getStatus();
		String tableName = tableEntity.getTableName();
		String guestName = tableEntity.getGuest();
		String phone = tableEntity.getPhone();
		BillEntity billEntity = tableEntity.getBill();
		if(billEntity != null) {
			Long billId = billEntity.getBillId();
			boolean statusPayment = billEntity.isStatusPayment();
			return new TableDTO(tableId, status, tableName, billId, guestName, phone, statusPayment);
		}else {
			return new TableDTO(tableId, tableName, guestName, phone, status);
		}
	}
	
	public List<TableDTO> convert2DTO(List<TableEntity> tableEntitys) {
		ArrayList<TableDTO> tableDTOs = new ArrayList<>();
		for (TableEntity tableEntity : tableEntitys) {
			tableDTOs.add(convert2DTO(tableEntity));
		}
		return tableDTOs;
	}
}
