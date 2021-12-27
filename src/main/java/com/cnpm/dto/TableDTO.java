package com.cnpm.dto;

public class TableDTO {
	public final static String available = "available";
	public final static String reserved = "reserved";
	public final static String occupied = "occupied";
	public final static String outoforder = "outoforder";
	private Long tableId;
	private String status;
	private String tableName;
	private Long billId;
	private Long customerId;
	private String custormerName;
	private String telephone;
	private boolean statusPayment;
	
	public TableDTO(Long tableId, String tableName, String status) {
		this.tableId = tableId;
		this.tableName = tableName;
		this.status = status;
	}
	
	public TableDTO(Long tableId, String status,
			String tableName, Long billId, 
			Long customerId, String custormerName, 
			String telephone, boolean statusPayment) {
		this.tableId = tableId;
		this.status = status;
		this.tableName = tableName;
		this.billId = billId;
		this.customerId = customerId;
		this.custormerName = custormerName;
		this.telephone = telephone;
		this.statusPayment = statusPayment;
	}

	public Long getTableId() {
		return tableId;
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

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustormerName() {
		return custormerName;
	}

	public void setCustormerName(String custormerName) {
		this.custormerName = custormerName;
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
