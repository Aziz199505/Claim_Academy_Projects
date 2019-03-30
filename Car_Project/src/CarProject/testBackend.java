package CarProject;

import com.inventory.Inventory;

public class testBackend {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Car toyota = new Car("Toyota","Carrola",2014,10000,5500.50);
		//Car bwm = new Car("Bwn","X5",2005,500,1200);
		
		//Date date = new Date();
		//toyota.setDateOfAdded(new Date());
		//bwm.setDateOfAdded(new Date());
		//List<Car> cars = new ArrayList<>();
		
		//cars.add(toyota);
		//cars.add(bwm);
		
		//System.out.println(toyota);
		/*
		 * System.out.println("Hello"); User seller = new Seller(new
		 * Address("1443  Woodcrest Manor Ct","Ballwin","MO","63021") ,new
		 * Contact("aziz199505@gmail.com","6366340941"),"Aziz","Sobirov");
		 * 
		 * 
		 * seller.addCar(toyota); seller.addCar(bwm);
		 */
		
		
		
		//Users users = new Users();
		
		//System.out.println(users.getUsers().size());
		
		//users.getUsers().get(0).removeCar(toyota);
		//System.out.println(users.getUsers().get(0));
		
		//users.getUsers().get(0).removeCar(bwm);
		//users.getUsers().remove(0);
		//users.addUser(seller);
		
		
		//users.getUsers().get(0).getCars();

		//seller.removeCar(toyota);
		
		
		//users.addUser(seller);
		//System.out.println(users);
		
		/*
		 * Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
		 * 
		 * public void run() { users.override();// Do what you want when the application
		 * is stopping } }));
		 */
		
		Inventory inventory = new Inventory();
		
		inventory.addCarTypes();
		
		
		
		
		
	}

}
