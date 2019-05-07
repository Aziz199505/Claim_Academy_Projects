package com.claim.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.joda.time.DateTime;




@Entity
@Table(name="week")
public class WeekTime {
	@Id @GeneratedValue 
	@Column(name="weekId")
	private long weekId;
	
	 @Enumerated(EnumType.STRING)
	 private Week week;
	 
	 @ManyToOne(cascade= CascadeType.ALL)
	 @JoinColumn(name = "notifyId")
	 private Notify notify;
	 
	 
	 
	 @OneToMany(fetch = FetchType.EAGER,mappedBy="week",cascade = CascadeType.ALL)
	 private Set<DateTimeFormat> dateTimeFormat;


	 
	 
	 
	 
	 
	public WeekTime() {
		super();
	}
	


	public long getWeekId() {
		return weekId;
	}


	public void setWeekId(long weekId) {
		this.weekId = weekId;
	}


	public Week getWeek() {
		return week;
	}


	public void setWeek(Week week) {
		this.week = week;
	}


	

	public Notify getNotify() {
		return notify;
	}



	public void setNotify(Notify notify) {
		this.notify = notify;
	}



	public Set<DateTimeFormat> getDateTimeFormat() {
		return dateTimeFormat;
	}



	public void setDateTimeFormat(Set<DateTimeFormat> dateTimeFormat) {
		this.dateTimeFormat = dateTimeFormat;
	}



	 	
	
	 
	 
}
