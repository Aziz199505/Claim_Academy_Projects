package PhoneBook;

public class Contact {
	//Creating variables
	private String telephone,cell,email,home,fax;

	//Creating default and parametize constructor
	public Contact() {}
	
	public Contact(String telephone) {
		this.telephone = telephone;
	}
	
	
	//Getters setters for variables
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	//Formatted string to used output Contact variables
	public String orginalFormat() {
		return String.format("tel:%s|cell:%s|email:%s|home:%s|fax:%s", this.telephone,this.cell,this.email,this.home,this.fax);
	}
	
	//Formatted string to used output Contact variables
	public String toString() {
		return String.format("Telephone:%s Cell Phone:%s Email:%s Home:%s Fax:%s", this.telephone,this.cell,this.email,this.home,this.fax);
		
	}
}
