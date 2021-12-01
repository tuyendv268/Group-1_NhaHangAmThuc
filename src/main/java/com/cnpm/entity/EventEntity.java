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
@Table(name = "event")
public class EventEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long eventId;
	
	@Column(name = "event_name")
	private String eventName;
	
	@OneToMany(mappedBy = "event")
	List<BillEntity> bills;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "time_start")
	private LocalDate timeStart;
	
	@Column(name = "time_end")
	private LocalDate timeEnd;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "member_discount_rate")
	private int memberDiscountRate;
	
	@Column(name = "non_member_discount_rate")
	private int nonMemberDiscountRate;

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public List<BillEntity> getBills() {
		return bills;
	}

	public void setBills(List<BillEntity> bills) {
		this.bills = bills;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(LocalDate timeStart) {
		this.timeStart = timeStart;
	}

	public LocalDate getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(LocalDate timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getMemberDiscountRate() {
		return memberDiscountRate;
	}

	public void setMemberDiscountRate(int memberDiscountRate) {
		this.memberDiscountRate = memberDiscountRate;
	}

	public int getNonMemberDiscountRate() {
		return nonMemberDiscountRate;
	}

	public void setNonMemberDiscountRate(int nonMemberDiscountRate) {
		this.nonMemberDiscountRate = nonMemberDiscountRate;
	}
	
	
}
