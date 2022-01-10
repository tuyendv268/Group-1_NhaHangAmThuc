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
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "exp")
	private int exp;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	
	
}
