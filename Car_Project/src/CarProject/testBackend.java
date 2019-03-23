package CarProject;

import java.util.ArrayList;
import java.util.List;

import com.car.Car;
import com.user.Address;
import com.user.Contact;
import com.user.Seller;
import com.user.User;
import com.users.Users;

public class testBackend {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car toyota = new Car("Toyota","Carrola",2014,10000,5500.50);
		Car bwm = new Car("Bwn","X5",2005,500,1200);
		
		List<Car> cars = new ArrayList<>();
		
		cars.add(toyota);
		cars.add(bwm);
		
		//System.out.println(toyota);
		
		User seller = new Seller(cars,new Address("1443  Woodcrest Manor Ct","Ballwin","MO","63021")
				,new Contact("aziz199505@gmail.com","6366340941"),"Aziz","Sobirov");
		
		
		Users users = new Users();
		users.addUser(seller);
		
		System.out.println(users);
		
	}

}
