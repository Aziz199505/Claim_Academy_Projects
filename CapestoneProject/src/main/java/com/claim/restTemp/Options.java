package com.claim.restTemp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Options {
	private String category;
	private double maxPrice;
	private double minPrice;
	private boolean postedToday = true;
	private boolean hasImage;
	private String city;
	public Options() {
		super();
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	public boolean isPostedToday() {
		return postedToday;
	}
	public void setPostedToday(boolean postedToday) {
		this.postedToday = postedToday;
	}
	public boolean isHasImage() {
		return hasImage;
	}
	public void setHasImage(boolean hasImage) {
		this.hasImage = hasImage;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Options [category=" + category + ", maxPrice=" + maxPrice + ", minPrice=" + minPrice + ", postedToday="
				+ postedToday + ", hasImage=" + hasImage + ", city=" + city + "]";
	}
	
	
	
	

}
