package com.cnpm.entity;

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

@Entity
@Table(name = "customer")
public class CustomerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long customerId;

	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "customer_name")
	private String custormerName;
	
	@OneToMany(mappedBy = "customer")
	List<BillEntity> bills;
	
	@Column(name = "point")
	private Long point;
	
	@ManyToOne
	@JoinColumn(name = "membership_id")
	private MembershipEntity membership;
	

	public Long getCustomerId(){
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCustormerName() {
		return custormerName;
	}

	public void setCustormerName(String custormerName) {
		this.custormerName = custormerName;
	}

	public Long getPoint() {
		return point;
	}

	public void setPoint(Long point) {
		this.point = point;
	}

	public MembershipEntity getMembership() {
		return membership;
	}

	public void setMembership(MembershipEntity membership) {
		this.membership = membership;
	}

	public List<BillEntity> getBills() {
		return bills;
	}

	public void setBills(List<BillEntity> bills) {
		this.bills = bills;
	}
	
	
}
