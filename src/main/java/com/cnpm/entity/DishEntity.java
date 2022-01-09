package com.cnpm.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dish")
public class DishEntity {
	@Id
	@GeneratedValue()
	@Column(name = "id")
	private Long dishId;
	
	@Column(name = "dish_name")
	private String dishName;
	
	@OneToMany(mappedBy = "dish")
	List<BillDetail> billDetails;
	
	@OneToMany(mappedBy = "dish")
	List<DishInComboEntity> dishInComboEntities;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "ingredient")
	private String ingredient;
	
	@Column(name = "created_time")
	private LocalDate createdTime;
	
	@Column(name = "modified_time")
	private LocalDate modifiedTime;
	
	@Column(name = "status")
	private Boolean status;
	
	@Column(name = "feature_dish")
	private Boolean featureDish;

	@Column(name = "url")
	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getDishId() {
		return dishId;
	}

	public void setDishId(Long dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public List<BillDetail> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(List<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}

	public List<DishInComboEntity> getDishInComboEntities() {
		return dishInComboEntities;
	}

	public void setDishInComboEntities(List<DishInComboEntity> dishInComboEntities) {
		this.dishInComboEntities = dishInComboEntities;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Boolean getFeatureDish() {
		return featureDish;
	}

	public void setFeatureDish(Boolean featureDish) {
		this.featureDish = featureDish;
	}
	
	
}
