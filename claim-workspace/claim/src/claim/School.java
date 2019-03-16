package claim;

import java.util.ArrayList;
import java.util.List;

public class School {
	private List<Person> people = new ArrayList<>();
	
	public void addPeople(Person p) {
		people.add(p);
	}
}
