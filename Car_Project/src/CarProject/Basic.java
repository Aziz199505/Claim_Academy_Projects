package CarProject;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Basic")
public class Basic extends HttpServlet {
	/* 
	 * private String message;
	 * 
	 * public void init() throws ServletException{ message = "Hello World"; }
	 * 
	 * 
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub response.setContentType("text/html");
	 * 
	 * PrintWriter out = response.getWriter(); out.println("<h1>" + message +
	 * "</h1>");
	 * //response.getWriter().append("Served at: ").append(request.getContextPath())
	 * ; }
	 * 
	 * public void destroy() {
	 * 
	 * }
	 */
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		String user = req.getParameter("user");
		String passwrod = req.getParameter("password");
		
		if(user.equals("aziz") && passwrod.equals("fifa1945")) {
			pw.println("Success");
	
		}else {
			pw.println("Failed");
		}
		
		pw.close();
		
		System.out.println(req.getSession().getId());
		
		
	}
	
	

}
