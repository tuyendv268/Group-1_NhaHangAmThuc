package com.cnpm.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "bill")
public class BillEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long billId;
	
	@OneToMany(mappedBy = "bill")
	List<BillDetail> billDetails;
	
	@Column(name = "date",columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@ManyToOne
	@JoinColumn(name = "event_id")
	private EventEntity event;
	
	@Column(name = "time_payment",columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timePayment;
	
	@OneToMany(mappedBy = "bill")
	private List<TableEntity> tables;
	
	@Column(name = "total")
	private Long finalTotal;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private CustomerEntity customer;
	
	@Column(name = "status")
	private boolean statusPayment;

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}
	

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getTimePayment() {
		return timePayment;
	}

	public void setTimePayment(Date timePayment) {
		this.timePayment = timePayment;
	}

	public Long getFinalTotal() {
		return finalTotal;
	}

	public void setFinalTotal(Long finalTotal) {
		this.finalTotal = finalTotal;
	}

	public boolean isStatusPayment() {
		return statusPayment;
	}

	public void setStatusPayment(boolean statusPayment) {
		this.statusPayment = statusPayment;
	}

	public List<BillDetail> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(List<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}

	public EventEntity getEvent() {
		return event;
	}

	public void setEvent(EventEntity event) {
		this.event = event;
	}

	public List<TableEntity> getTables() {
		return tables;
	}

	public void setTables(List<TableEntity> tables) {
		this.tables = tables;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	
	
}
