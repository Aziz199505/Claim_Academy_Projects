package com.claim.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.codec.digest.DigestUtils;

@Entity
@Table(name="user")
public class User {
	
	
    @Id @GeneratedValue 
	@Column(name="userId")
    private long userId;
		
    @Column(name="username")
	private String username;
	
	@Column(name="email")
	private String email;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	
	@Column(name="cellPhone")
	private String cellPhone;
	

	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy="user",cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval=true)
    private Set<Preference> preference;

	
	

	public User() {
		super();
	}


	public User(long userId, String username, String email, String firstName, String lastName, String cellPhone,
			String password, Set<Preference> preference) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cellPhone = cellPhone;
		this.password = password;
		this.preference = preference;
	}

	
	

	public Set<Preference> getPreference() {
		return preference;
	}


	public void setPreference(Set<Preference> pref) {
		preference.clear();
		preference.addAll(pref);
	}
	
	public void newPreference(Set<Preference> preference) {
		this.preference.clear();
		this.preference.addAll(preference);
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getCellPhone() {
		return cellPhone;
	}


	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		String salt = "----$$$$$@@@##!#!#$199sasClaimAcademy";
		this.password = getMD5Hash(String.valueOf(password)+salt);
	}
	
	public String getMD5Hash(String data) {
		String md5 = DigestUtils.md5Hex(data);
		return md5;
	}


	
	
	
	
}
