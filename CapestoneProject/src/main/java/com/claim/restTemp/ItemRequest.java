package com.claim.restTemp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemRequest {
	private Options options;
	private String  search;
	public ItemRequest() {
		super();
	}
	public Options getOptions() {
		return options;
	}
	public void setOptions(Options options) {
		this.options = options;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	@Override
	public String toString() {
		return "ItemRequest [options=" + options + ", search=" + search + "]";
	}
	
	
	
	
	
}
