package claim;

public class Employee extends Person{

	public Employee(String firstName, String lastName) {
		super(firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double taxes(double amount) {
		// TODO Auto-generated method stub
		return amount * 0.2;
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
