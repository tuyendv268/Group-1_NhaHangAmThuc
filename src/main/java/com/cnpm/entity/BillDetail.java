package com.cnpm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "bill_detail")
public class BillDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "dish_id")
	private DishEntity dish;
	
	@Column(name = "quatity")
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "bill_id")
	private BillEntity bill;
	
	@Column(name = "total")
	private Integer total;
	
	@Column(name = "modify_time",columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyTime;
	
	@ManyToOne
	@JoinColumn(name = "combo_id")
	private ComboEntity combo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DishEntity getDish() {
		return dish;
	}

	public void setDish(DishEntity dish) {
		this.dish = dish;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BillEntity getBill() {
		return bill;
	}

	public void setBill(BillEntity bill) {
		this.bill = bill;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public ComboEntity getCombo() {
		return combo;
	}

	public void setCombo(ComboEntity combo) {
		this.combo = combo;
	}
	
	
}
