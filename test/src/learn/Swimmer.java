package learn;

public class Swimmer extends Athelete {
	String position;
	Swimmer(int age, String name,String position) {
		super(age, name);
	}
	
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
}
