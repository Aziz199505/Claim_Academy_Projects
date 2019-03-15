package PhoneBook;

public class Person {
	
	private Address address;
	private Contact contact;
	private String firstName,lastName,middleName;
	
	public Person() {}
	public Person(String firstName, String middleName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
	}
	
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
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
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String fullName() {
		return String.format("%s %s %s", this.firstName,this.middleName != null ? this.middleName : "",this.lastName).trim().replaceAll(" +", " ");

	}

	public String toString() {
		return String.format("|%s %s %s|%s|%s|", this.firstName,this.middleName != null ? this.middleName : "",this.lastName,this.address.toString(),this.contact.toString()).trim().replaceAll(" +", " ");
	}
	
	

}
