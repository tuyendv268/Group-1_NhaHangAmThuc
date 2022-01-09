package com.cnpm.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cnpm.dto.TableDTO;
import com.cnpm.entity.BillEntity;
import com.cnpm.entity.TableEntity;
import com.cnpm.repository.TableRepository;

@Service
public class TableService {
	@Autowired
	private TableRepository tableRepository;
	
	public List<TableDTO> findAll(){
		return convert2DTO(tableRepository.findAll());
	}
	
	@Scheduled(fixedDelay = 2000)
	  public void updateTime() throws InterruptedException {
	    List<TableEntity> tables = tableRepository.findAll();
	    for (TableEntity table : tables) {
	    	if(table.getExpired_time()!=null) {
	    		if(LocalTime.now().isAfter(table.getExpired_time())
	    				&&(table.getStatus().equals(TableDTO.reserved))) {
	    			table.setStatus(TableDTO.available);
	    			table.setGuest(null);
	    			table.setPhone(null);
	    			tableRepository.save(table);
					System.out.println("Expried Order"+table.getTableName());
				}
	    	}
		}
	    // added sleep to simulate method 
	    // which takes longer to execute.   
	    Thread.sleep(4000); 
	}
	
	public void delete(Long id) {
		tableRepository.deleteById(id);
	}
	
	public TableEntity findByID(Long id) {
		return tableRepository.findByTableId(id);
	}
	
	public TableEntity useTable(Long id) {
		TableEntity table = tableRepository.findByTableId(id);
		if(table == null) {
			return null;
		}
		table.setStatus(TableDTO.occupied);
		tableRepository.save(table);
		
		return table;
	}
	
	public TableEntity cancelTable(Long id) {
		TableEntity table = tableRepository.findByTableId(id);
		if(table == null) {
			return null;
		}
		table.setStatus(TableDTO.available);
		table.setGuest(null);
		table.setExpired_time(null);
		table.setOrdered_time(null);
		table.setPhone(null);
		tableRepository.save(table);
		
		return table;
	}
	
	public List<TableEntity> findByBill(Long id) {
		return tableRepository.findByBill(id);
	}

	public TableEntity orderTable(Long id, String guestName, String phone) {
		TableEntity table = findByID(id);
		table.setGuest(guestName);
		table.setPhone(phone);
		table.setStatus(TableDTO.reserved);
		table.setOrdered_time(LocalTime.now());
		table.setExpired_time(LocalTime.now().plusMinutes(30));
		System.out.println("Order : "+table.getGuest()+"-"+table.getPhone());
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
			return new TableDTO(tableId, tableName, guestName, phone, status, tableEntity.getExpired_time());
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
