package com.cnpm.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "combo")
public class ComboEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long comboId;
	
	@Column(name = "combo_name")
	private String comboName;
	
	@Column(name="price")
	private int price;
	
	@Column(name = "description")
	private String description;
	
	@Column
	private int numberOfPeopleRecommend;
	
	@OneToMany(mappedBy = "combo")
	List<DishInComboEntity> dishInComboEntities;
	
	@OneToMany(mappedBy = "combo")
	List<BillDetail> billDetails;
	
	
	@Column
	private int discountRate;
	
	@Column
	private LocalDate createdTime;
	
	@Column
	private LocalDate modifiedTime;
	
	@Column
	private boolean status;
	
	@Column(name = "url")
	private String url;

	
	public ComboEntity() {
		super();
	}

	public ComboEntity(String comboName, int price, String description, int numberOfPeopleRecommend,
			int discountRate, boolean status, String url) {
		super();
		this.comboName = comboName;
		this.price = price;
		this.description = description;
		this.numberOfPeopleRecommend = numberOfPeopleRecommend;
		this.discountRate = discountRate;
		this.status = status;
		this.url = url;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getComboId() {
		return comboId;
	}

	public void setComboId(Long comboId) {
		this.comboId = comboId;
	}

	public String getComboName() {
		return comboName;
	}

	public void setComboName(String comboName) {
		this.comboName = comboName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumberOfPeopleRecommend() {
		return numberOfPeopleRecommend;
	}

	public void setNumberOfPeopleRecommend(int numberOfPeopleRecommend) {
		this.numberOfPeopleRecommend = numberOfPeopleRecommend;
	}

	public List<DishInComboEntity> getDishInComboEntities() {
		return dishInComboEntities;
	}

	public void setDishInComboEntities(List<DishInComboEntity> dishInComboEntities) {
		this.dishInComboEntities = dishInComboEntities;
	}

	public List<BillDetail> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(List<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	public LocalDate getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDate createdTime) {
		this.createdTime = createdTime;
	}

	public LocalDate getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDate modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
