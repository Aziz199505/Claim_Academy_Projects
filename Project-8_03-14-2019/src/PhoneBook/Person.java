package PhoneBook;

public class Person {
	//Creating variables

	private Address address;
	private Contact contact;
	private String firstName,lastName,middleName;
	private String Birthday,Aniversary;
	
	
	//Creating default and parametize constructor with overload constructors to handle middle name

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
	//Getters setters for variables

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
	
	public String getBirthday() {
		return Birthday;
	}

	public void setBirthday(String birthday) {
		Birthday = birthday;
	}

	public String getAniversary() {
		return Aniversary;
	}

	public void setAniversary(String aniversary) {
		Aniversary = aniversary;
	}
	
	//Returns full name string used for sorting
	public String fullName() {
		return String.format("%s %s %s", this.firstName,this.middleName != null ? this.middleName : "",this.lastName).trim().replaceAll(" +", " ");

	}
	
	public String originalFormat() {
		return String.format("|%s %s %s|%s|%s|%s|%s", this.firstName,this.middleName != null ? this.middleName : "",this.lastName,this.address.toString(),this.Birthday,this.Aniversary,this.contact.toString()).trim().replaceAll(" +", " ");
	}

	public String toString() {
		return String.format(" FirstName: %s Middle Name:%s Last Name: %s %s Birthday: %s Aniversary: %s %s", this.firstName,this.middleName != null ? this.middleName : "",this.lastName,this.address.toString(),this.Birthday,this.Aniversary,this.contact.toString()).trim().replaceAll(" +", " ");
	}

	
	
	

}
