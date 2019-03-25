package Servlets;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Student;

/**
 * Servlet implementation class IncomeTax
 */
@WebServlet("/IncomeTaxServlet")
public class IncomeTaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncomeTaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Hello");
		
		int totalIncome = Integer.parseInt(request.getParameter("totalIncome"));
		String status = request.getParameter("status");
		
		System.out.println(status + " " + totalIncome);
		
		String[] listStatus = {"unmarried","married","headsOfHousehold"};
		
		int [][] incomeList = {
				{0,0,0},
				{9700, 19400, 13850},
				{39475 , 78950,52850},
				{84200,168400, 84200},
				{160725, 321450,160700},
				{204100 ,408200,204100},
				{510300,612350,510300}
					
		};
		
		double[] percent = {0.1,0.12,0.22,0.24,0.32,0.35,0.37};
		double getPercent = 0;
		
		
		for(int i = 0 ; i < incomeList.length; i++) {
			//if(list[listStatus[status]])
			// System.out.println(Arrays.asList(list).get(Arrays.asList(listStatus).indexOf(status)))	;
			int[] list = incomeList[i];
			int income = list[Arrays.asList(listStatus).indexOf(status)];
			
			if(i != incomeList.length - 1 && i != 0) {
				//System.out.println(i + " " + Arrays.asList(listStatus).indexOf(status));
				int before = incomeList[i-1][Arrays.asList(listStatus).indexOf(status)];
				int after = incomeList[i+1][Arrays.asList(listStatus).indexOf(status)];

				if(before < totalIncome && totalIncome <= after && totalIncome <= income) {
					System.out.println(before + " " + totalIncome + " " + after + " " + income);
					getPercent = percent[i];
				}
			}else {
				if(totalIncome < incomeList[0][Arrays.asList(listStatus).indexOf(status)]) {
					getPercent = percent[0];
				}
				
				if(totalIncome >= incomeList[incomeList.length-1][Arrays.asList(listStatus).indexOf(status)]) {
					getPercent = percent[percent.length-1];
				}
			}
			
			
			
			//System.out.println(Arrays.asList(listStatus).indexOf(status));		
			
		}
		
		
		HttpSession session = request.getSession(true);
		Student student = (Student)session.getAttribute("student");
			//student.setGpa(gpa);
		student.setTotalIncomeTax(totalIncome * getPercent);
		student.setTaxPercent(getPercent * 100);	
			
		//session.setAttribute("student", student);
			RequestDispatcher rs = request.getRequestDispatcher("account.jsp");
				  rs.forward(request,response);
		
		//doGet(request, response);
	}

}
