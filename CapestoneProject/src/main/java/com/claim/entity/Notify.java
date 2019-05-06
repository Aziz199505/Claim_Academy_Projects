package com.claim.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@MappedSuperclass
public class Notify {
	@Id @GeneratedValue 
	@Column(name="notifyId")
	private long notifyId;
	
	@ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "prefId")
    private Preference preference;
	
	
	
	


	
	
	
	

	public Notify() {
		super();
	}



	public Notify(long notifyId, Preference preference) {
		super();
		this.notifyId = notifyId;
		this.preference = preference;
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
