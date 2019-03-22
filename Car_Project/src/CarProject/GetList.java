package CarProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GetList extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

            List<String> listCatagory = new ArrayList<>();
            listCatagory.add("Alex");
            listCatagory.add("Aziz");
            req.setAttribute("listCategory", listCatagory);

 
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req, res);
    		System.out.println(req.getSession().getId());

        
    }
}
