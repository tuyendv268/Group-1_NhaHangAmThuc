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
	
	@Column(name = "description")
	private String description;
	
	@Column
	private int numberOfPeopleRecommend;
	
	@OneToMany(mappedBy = "combo")
	List<DishInComboEntity> dishInComboEntities;
	
	@OneToMany(mappedBy = "combo")
	List<BillDetail> billDetails;
	
	
	@Column
	private Boolean discountRate;
	
	@Column
	private LocalDate createdTime;
	
	@Column
	private LocalDate modifiedTime;
	
	@Column
	private boolean status;
}
