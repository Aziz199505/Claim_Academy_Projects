package com.claim.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="notify")
public class Notify {
	@Id @GeneratedValue 
	@Column(name="notifyId")
	private long notifyId;
	
	@ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "prefId")
    private Preference preference;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="notify",cascade = CascadeType.ALL)
    private Set<WeekTime> weekTime;
	
	


	
	
	
	

	public Notify() {
		super();
	}



	


	public Notify(long notifyId, Preference preference, String name, Set<WeekTime> weekTime) {
		super();
		this.notifyId = notifyId;
		this.preference = preference;
		this.name = name;
		this.weekTime = weekTime;
	}






	public String getName() {
		return name;
	}






	public void setName(String name) {
		this.name = name;
	}






	public Set<WeekTime> getWeekTime() {
		return weekTime;
	}






	public void setWeekTime(Set<WeekTime> weekTime) {
		this.weekTime = weekTime;
	}






	public long getNotifyId() {
		return notifyId;
	}



	public void setNotifyId(long notifyId) {
		this.notifyId = notifyId;
	}



	public Preference getPreference() {
		return preference;
	}


	
	

	public void setPreference(Preference preference) {
		this.preference = preference;
	}




	
	 
	 
	
	
	
	
}
