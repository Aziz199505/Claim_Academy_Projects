package com.claim.restTemp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

	private String date;
	private String pid;
	
	
	public Item() {
		super();
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getPid() {
		return pid;
	}


	public void setPid(String pid) {
		this.pid = pid;
	}


	@Override
	public String toString() {
		return "Item [date=" + date + ", pid=" + pid + "]";
	}
	
	
	
	
}
