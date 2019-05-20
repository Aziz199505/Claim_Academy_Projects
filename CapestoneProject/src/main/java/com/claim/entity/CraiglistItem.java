package com.claim.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="craiglistitem")
public class CraiglistItem {
	
	
	@Id @GeneratedValue 
	@Column(name="craigId")
	private long craigId;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="pid")
	private String pid;
	
	@Column(name="price")
	private String price;
	
	
	
	@Column(name = "prefId")
    private Long prefId;
	
	

	public CraiglistItem() {
		super();
	}
	
	



	public Long getPrefId() {
		return prefId;
	}




	public void setPrefId(Long prefId) {
		this.prefId = prefId;
	}








	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}




	public long getCraigId() {
		return craigId;
	}




	public void setCraigId(long craigId) {
		this.craigId = craigId;
	}




	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPid() {
		return pid;
	}

	
	public void setPid(String pid) {
		this.pid = pid;
	}
	
	
	
	
	
}
