package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.car.Car;
import com.inventory.Inventory;
import com.user.Address;
import com.user.Contact;
import com.user.Seller;
import com.user.User;
import com.users.Users;

/**
 * Servlet implementation class initServlet
 */
public class initServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public initServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("Servlet");
		
		HttpSession session = request.getSession(true);
		if(session.getAttribute("inventory") == null) {
			/*
			 * System.out.println("inside");
			 */
			Inventory inventory = new Inventory();
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
			 * System.out.println("Hello"); 
			 * 
			 */
			 User seller = new Seller(new
			 Address("1443  Woodcrest Manor Ct","Ballwin","MO","63021") ,new
			 Contact("aziz199505@gmail.com","6366340941"),"Aziz","Sobirov");
			 
				
			//seller.addCar(toyota);
			//seller.addCar(bwm);
			
			 Users users = new Users();
			 
			 //System.out.println(users.getUsers().size());
			
			
			//users.getUsers().get(0).removeCar(toyota);
			//System.out.println(users.getUsers().get(0));
			
			//users.getUsers().get(0).removeCar(bwm);
			//users.getUsers().remove(0);
			/*
			 * users.addUser(seller); inventory.setUsers(users);
			 */
			//users.getUsers().get(0).getCars();
			//users.addUser(seller);
			
			inventory.setUsers(users);

			inventory.addSeller();
			inventory.addCars();
			inventory.addCarTypes();
			//seller.removeCar(toyota);
			
			
			//System.out.println(users);
			
			//session.setAttribute("selectedMakeName", "aston martin");
			session.setAttribute("inventory", inventory);
		}
		
		
		// TODO Auto-generated method stub
		RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
		rs.forward(request,response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
