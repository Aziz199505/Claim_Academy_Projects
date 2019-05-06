package com.claim.entity;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="dateTime")
public class DateTime {
	@Id @GeneratedValue 
	@Column(name="timeId")
	private long timeId;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date timeFrom;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date timeTo;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "weekId")
	private WeekTime weekTime;

	public long getTimeId() {
		return timeId;
	}

	public void setTimeId(long timeId) {
		this.timeId = timeId;
	}

	public Date getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(Date timeFrom) {
		this.timeFrom = timeFrom;
	}

	public Date getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(Date timeTo) {
		this.timeTo = timeTo;
	}

	public WeekTime getWeekTime() {
		return weekTime;
	}

	public void setWeekTime(WeekTime weekTime) {
		this.weekTime = weekTime;
	}
	
	
	
	
}
