package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Course;
import com.user.WeekDay;

/**
 * Servlet implementation class SchedulerServlet
 */
@WebServlet("/SchedulerServlet")
public class SchedulerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchedulerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		if(session.getAttribute("courseList") == null) session.setAttribute("courseList", new ArrayList<Course>());
		
		Course course = new Course();
		
		
		
		
		String[] weekdays = request.getParameterValues("weekday");
		
		String professor = request.getParameter("professorName");
		String courseName = request.getParameter("courseName");
		
		System.out.println(request.getParameter("courseName"));
		System.out.println(request.getParameter("professorName"));

		String date =  request.getParameter("date");
		String time = request.getParameter("time");
		int roomNum = Integer.parseInt(request.getParameter("roomNum"));
		
		 
		for(String weekday : weekdays) {
			WeekDay weekdayEnum = WeekDay.valueOf(weekday.toUpperCase());
				 
			course.getWeekdays().add(weekdayEnum);
			System.out.println(weekdayEnum.name());

				
		}
		 
		 
		 //System.out.println(date + );
		// System.out.println(time);
		 
		 course.setCourseName(courseName);
		 course.setProfessor(professor);
		
		 course.setStartDate(date);
		 course.setTime(time);
		 course.setRoomNum(roomNum);
		 
		List<Course> courseList = (ArrayList<Course>)session.getAttribute("courseList");

		 
		courseList.add(course);
		
		
		RequestDispatcher rs = request.getRequestDispatcher("course.jsp");
		rs.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//List<Course> courseList = new ArrayList<>();
		

		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
