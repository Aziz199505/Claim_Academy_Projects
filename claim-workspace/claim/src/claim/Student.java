package claim;

public class Student extends Person {

	public Student(String firstName, String lastName) {
		super(firstName, lastName);
		// TODO Auto-generated constructor stub
	}


	@Override
	public double taxes(double amount) {
		// TODO Auto-generated method stub
		return amount * 0.02;
	}
	
	
	public String toString() {
		return String.format("%s %s", this.firstName, this.lastName);
	}


	@Override
	public double gasBill(double amount) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean carInsurance(boolean exist) {
		// TODO Auto-generated method stub
		return false;
	}

}
