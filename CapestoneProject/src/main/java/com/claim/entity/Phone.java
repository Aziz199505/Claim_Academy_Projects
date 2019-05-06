package com.claim.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="notify")
public class Phone extends Notify {

	
	
	@Column(name="name")
	private String name = "phone";

	@OneToMany(fetch = FetchType.EAGER,mappedBy="notify",cascade = CascadeType.ALL)
    private Set<WeekTime> weekTime;
	
	
	
	
	public Set<WeekTime> getWeekTime() {
		return weekTime;
	}

	public void setWeekTime(Set<WeekTime> weekTime) {
		this.weekTime = weekTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
