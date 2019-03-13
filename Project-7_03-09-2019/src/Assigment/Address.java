package Assigment;

public class Address {
	public Address(String street, String state, int zipcode) {
		super();
		this.street = street;
		this.state = state;
		this.zipcode = zipcode;
	}
	private String street,state;
	private int zipcode;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	public String toString() {
		return String.format("Address: %s %s %d",street,state,zipcode);
	}
	
	
}
