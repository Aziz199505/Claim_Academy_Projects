package claim;

public class Student {
	private String firstName,lastName,telephone,address;
	private int age;
	private double gpa;
	
	
	public Student() {
		
	}
	
	public Student(String firstName,String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Student(String firstName,String lastName,String telephone,String address,int age,double gpa) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.address = address;
		this.age = age;
		this.gpa = gpa;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	
	
	
}
