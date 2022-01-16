package com.cnpm.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@Column(name = "time_start",columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStart;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@Column(name = "time_end",columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeEnd;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "discount_rate")
	private int discountRate;
	
	@Column(name ="is_displayed")
	private boolean isDisplayed;
	
	public EventEntity() {
		
	}
	
	public EventEntity(Long id, String eventName, String description, Date timeStart, Date timeEnd, int discountRate) {
		this.eventName = eventName;
		this.eventId = id;
		this.description = description;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.discountRate = discountRate;
	}

	public EventEntity(String eventName, String description, Date timeStart, Date timeEnd, int discountRate) {
		this.eventName = eventName;
		this.description = description;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.discountRate = discountRate;
	}
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

	
	public boolean isDisplayed() {
		return isDisplayed;
	}

	public void setDisplayed(boolean isDisplayed) {
		this.isDisplayed = isDisplayed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

	public Date getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public int getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	public boolean isAvailable() {
		java.util.Date date=new java.util.Date();  
		if(date.after(this.timeEnd) || date.before(this.timeStart)) {
			return false;
		}
		return true;
	}
}
