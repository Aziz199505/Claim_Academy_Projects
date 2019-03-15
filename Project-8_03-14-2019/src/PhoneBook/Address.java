package PhoneBook;

public class Address {
	
	private String street,state,city,zipcode;

	public Address(String street, String city,String state,String zipcode) {
		super();
		this.street = street;
		this.state = state;
		this.zipcode = zipcode;
		this.city = city;
	}

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
	public String  getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String toString() {
		return String.format("%s, %s, %s, %s",street,city,state,zipcode);
	}
	
	
}
