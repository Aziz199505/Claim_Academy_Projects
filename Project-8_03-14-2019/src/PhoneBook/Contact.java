package PhoneBook;

public class Contact {
	private String telephone;
	
	public Contact(String telephone) {
		this.telephone = telephone;
	}
	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String toString() {
		return String.format("%s", this.telephone);
		
	}
}
