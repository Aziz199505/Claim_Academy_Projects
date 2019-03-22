package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Address;
import com.user.Student;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		Student student = new Student();
		Address address = new Address();
		
		student.setEmail(req.getParameter("email"));
		student.setFirstName(req.getParameter("firstName"));
		student.setLastName(req.getParameter("lastName"));
		student.setPassword(req.getParameter("password"));
		student.setSchoolName("Claim Academy");
		
		address.setStreet(req.getParameter("street"));
		address.setCity(req.getParameter("city"));
		address.setState(req.getParameter("state"));
		address.setZipCode(req.getParameter("zipCode"));
		
		student.setAddress(address);
		
		HttpSession session = req.getSession(true);
		session.setAttribute("student", student);
		
		RequestDispatcher rs = req.getRequestDispatcher("account.jsp");
		rs.forward(req,res);

		
		/*
		 * if(user.equals("aziz") && passwrod.equals("fifa1945")) {
		 * pw.println("Success");
		 * 
		 * }else { pw.println("Failed"); }
		 */
		
		pw.close();
		
		//System.out.println(req.getSession().getId());
		
		
	}

}
