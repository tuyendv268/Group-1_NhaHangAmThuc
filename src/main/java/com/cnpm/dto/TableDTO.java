package com.cnpm.dto;

import java.time.LocalTime;

public class TableDTO {
	public final static String available = "available";
	public final static String reserved = "reserved";
	public final static String occupied = "occupied";
	public final static String outoforder = "outoforder";
	private Long tableId;
	private String status;
	private String tableName;
	private Long billId;
	private String guestName;
	private String telephone;
	private String expired_time;
	private String ordered_time;
	private boolean statusPayment;
	
	public TableDTO(Long tableId, String tableName, String guestName,String phone ,String status,LocalTime expired_time) {
		this.tableId = tableId;
		this.guestName = guestName;
		this.telephone = phone;
		this.tableName = tableName;
		this.status = status;
		if(expired_time != null) {
			this.expired_time = expired_time.toString();
		}else {
			this.expired_time = "none";
		}
	}
	
	public TableDTO(Long tableId, String status,
			String tableName, Long billId, 
			String guestName, 
			String telephone, boolean statusPayment) {
		this.tableId = tableId;
		this.status = status;
		this.tableName = tableName;
		this.billId = billId;

		this.guestName = guestName;
		this.telephone = telephone;
		this.statusPayment = statusPayment;
	}
	

	public String getExpired_time() {
		return expired_time;
	}

	public void setExpired_time(String expired_time) {
		this.expired_time = expired_time;
	}

	public String getOrdered_time() {
		return ordered_time;
	}

	public void setOrdered_time(String ordered_time) {
		this.ordered_time = ordered_time;
	}

	public Long getTableId() {
		return tableId;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public boolean isStatusPayment() {
		return statusPayment;
	}

	public void setStatusPayment(boolean statusPayment) {
		this.statusPayment = statusPayment;
	}
	
	
}
