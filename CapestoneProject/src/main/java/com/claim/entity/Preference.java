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
@Table(name="preference")
public class Preference {
	@Id @GeneratedValue 
	@Column(name="prefId")
	private long prefId;
	
	
	@Column(name="city")
	private String city;
	
	@Column(name="maxPrice")
	private double maxPrice;
	
	@Column(name="minPrice")
	private double minPrice;
	
	@Column(name="category")
	private String category;
	
	@Column(name="postal")
	private String postal;
	
	@Column(name="hasPic")
	private boolean hasPic;
	
	@Column(name="notify")
	private boolean notify;
	
	@Column(name="notifyEmail")
	private boolean notifyEmail;
	
	@Column(name="notifyPhone")
	private boolean notifyPhone;
	
	@Column(name="searchNearby")
	private boolean searchNearby;
	
	@Column(name="search")
	private String search;
	
	@Column(name="descp")
	private String descp;
	
	@Column(name="state")
	private String state;
	

	@ManyToOne
    @JoinColumn(name = "userId")
    private User user;
	
	
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="preference",cascade = CascadeType.ALL)
    private Set<Notify> notifyDetail;
	
	

	public Preference() {
		super();
	}
	
	
	public Preference(long prefId, String city, double maxPrice, double minPrice, String category, String postal,
			boolean hasPic, boolean notify, boolean notifyEmail, boolean notifyPhone, boolean searchNearby,
			String search, String descp, String state, User user, Set<Notify> notifyDetail) {
		super();
		this.prefId = prefId;
		this.city = city;
		this.maxPrice = maxPrice;
		this.minPrice = minPrice;
		this.category = category;
		this.postal = postal;
		this.hasPic = hasPic;
		this.notify = notify;
		this.notifyEmail = notifyEmail;
		this.notifyPhone = notifyPhone;
		this.searchNearby = searchNearby;
		this.search = search;
		this.descp = descp;
		this.state = state;
		this.user = user;
		this.notifyDetail = notifyDetail;
	}







	public Set<Notify> getNotifyDetail() {
		return notifyDetail;
	}

	public void setNotifyDetail(Set<Notify> notifyDetail) {
		this.notifyDetail = notifyDetail;
	}

	
	
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getDescp() {
		return descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getPrefId() {
		return prefId;
	}

	public void setPrefId(long prefId) {
		this.prefId = prefId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public boolean isHasPic() {
		return hasPic;
	}

	public void setHasBic(boolean hasPic) {
		this.hasPic = hasPic;
	}

	public boolean isNotify() {
		return notify;
	}

	public void setNotify(boolean notify) {
		this.notify = notify;
	}

	public boolean isNotifyEmail() {
		return notifyEmail;
	}

	public void setNotifyEmail(boolean notifyEmail) {
		this.notifyEmail = notifyEmail;
	}

	public boolean isNotifyPhone() {
		return notifyPhone;
	}

	public void setNotifyPhone(boolean notifyPhone) {
		this.notifyPhone = notifyPhone;
	}

	public boolean isSearchNearby() {
		return searchNearby;
	}

	public void setSearchNearby(boolean searchNearby) {
		this.searchNearby = searchNearby;
	}


	@Override
	public String toString() {
		return "Preference [prefId=" + prefId + ", city=" + city + ", maxPrice=" + maxPrice + ", minPrice=" + minPrice
				+ ", category=" + category + ", postal=" + postal + ", hasBic=" + hasPic + ", notify=" + notify
				+ ", notifyEmail=" + notifyEmail + ", notifyPhone=" + notifyPhone + ", searchNearby=" + searchNearby
				+ ", search=" + search + ", descp=" + descp + ", state=" + state + ", user=" + user + "]";
	}


	
	

}
