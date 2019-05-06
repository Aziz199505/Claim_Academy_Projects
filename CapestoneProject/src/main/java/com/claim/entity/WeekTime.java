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
	 private Email email;
	 
	 @ManyToOne(cascade= CascadeType.ALL)
	 @JoinColumn(name = "notifyId")
	 private Phone phone;
	 
	 
	 @OneToMany(fetch = FetchType.EAGER,mappedBy="week",cascade = CascadeType.ALL)
	 private Set<DateTime> dateTime;


	 
	 
	 
	 
	 
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


	





	public Email getEmail() {
		return email;
	}





	public void setEmail(Email email) {
		this.email = email;
	}





	public Phone getPhone() {
		return phone;
	}





	public void setPhone(Phone phone) {
		this.phone = phone;
	}





	public Set<DateTime> getDateTime() {
		return dateTime;
	}


	public void setDateTime(Set<DateTime> dateTime) {
		this.dateTime = dateTime;
	}
	 	
	
	 
	 
}
