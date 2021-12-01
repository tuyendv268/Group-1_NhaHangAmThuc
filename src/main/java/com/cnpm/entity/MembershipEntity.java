package com.cnpm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "membership")
public class MembershipEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long Id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "discount_rate")
	private int discountRate;

	@OneToMany(mappedBy = "membership")
	private List<CustomerEntity> customerEntitys;
	
	public List<CustomerEntity> getCustomerEntitys() {
		return customerEntitys;
	}

	public void setCustomerEntitys(List<CustomerEntity> customerEntitys) {
		this.customerEntitys = customerEntitys;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	
	
}
