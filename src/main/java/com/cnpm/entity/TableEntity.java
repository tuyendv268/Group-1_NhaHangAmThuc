package com.cnpm.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "_table")
public class TableEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long tableId;
	
	@Column(name = "table_name")
	private String tableName;
	@Column(name = "status")
	private String status;
	@Column(name = "guest_name")
	private String guest;
	@Column(name = "phone")
	private String phone;
	@Column(name = "ordered_time")
	private LocalTime ordered_time;
	@Column(name = "expired_time")
	private LocalTime expired_time;
	
	@ManyToOne
	@JoinColumn(name = "bill_id")
	private BillEntity bill;
	
	public TableEntity(Long tableId, String tableName, String status) {
		this.tableId = tableId;
		this.tableName = tableName;
		this.status = status;
	}
	public TableEntity() {
		
	}

	public String getTableName() {
		return tableName;
	}
	
	

	public String getGuest() {
		return guest;
	}
	public void setGuest(String guest) {
		this.guest = guest;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	public BillEntity getBill() {
		return bill;
	}

	public void setBill(BillEntity bill) {
		this.bill = bill;
	}
	public LocalTime getOrdered_time() {
		return ordered_time;
	}
	public void setOrdered_time(LocalTime ordered_time) {
		this.ordered_time = ordered_time;
	}
	public LocalTime getExpired_time() {
		return expired_time;
	}
	public void setExpired_time(LocalTime expired_time) {
		this.expired_time = expired_time;
	}
}
