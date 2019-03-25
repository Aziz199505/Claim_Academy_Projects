<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.user.Student" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css" src="./styles/styles.css"></style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>


<% 
            Student student = (Student) session.getAttribute("student");
%>



<nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          Welcome To <%  out.print(student.getSchoolName());  %>
        </div>
        <div class="collapse navbar-collapse" id="navbarNav"> 
        	<ul class="navbar-nav">
		      <li class="nav-item">
		        <a class="nav-link" href="./BMI.jsp">BMI</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="./account.jsp">Account</a>
		      </li>
		    </ul>    
        </div><!--/.navbar-collapse -->
      </div>
    </nav>
<!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>Hello, <%  out.print(student.getFirstName());  %></h1>
        <p>This is a simple java servlet program for a functional website. </p>
      </div>
    </div>
    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>My GPA </h2>
          <p><%  out.print(student.getGpa());  %></p>
			<!--  	<p><a class="btn btn-default" href="GpaServlet" role="button">View GPA </a></p>
        --> </div>        
        <div class="col-md-4">
          <h2>Enter Grades </h2>
           <form action="GpaServlet" method="post">
           <div class="form-group">
    <label for="gradeOne">GradeOne</label>
    <input type="text" class="form-control" name="gradeOne" id="gradeOne" placeholder="Grade One">
  </div>
  <div class="form-group">
    <label for="gradeTwo">Grade Two</label>
    <input type="text" class="form-control" name="gradeTwo" id="gradeTwo" placeholder="Grade Two">
  </div>
  <div class="form-group">
    <label for="gradeThree">Grade Three</label>
    <input type="text" class="form-control" name="gradeThree" id="gradeThree" placeholder="Grade Three">
  </div>           
             <button type="submit" class="btn btn-default">Submit</button>           
           </form>       
         </div>        
      <hr>
      <footer>
        <p>&copy; 2017 Company, Inc.</p>
      </footer>
    </div>
    
    <div class="row">
        <div class="col-md-4">
          <h2>My BMI </h2>
          <p><%  out.print(String.format("%.2f",student.getBmi()));  %></p>
			<!--  	<p><a class="btn btn-default" href="GpaServlet" role="button">View GPA </a></p>
        --> </div>        
        <div class="col-md-4">
          <h2>Enter Height & Weight </h2>
           <form action="BMIServlet" method="post">
           <div class="form-group">
    <label for="height">Enter Height</label>
    <input type="text" class="form-control" name="height" id="height">
  </div>
  <div class="form-group">
    <label for="weight">Enter Weight</label>
    <input type="text" class="form-control" name="weight" id="weight">
  </div>
           
             <button type="submit" class="btn btn-default">Submit</button>           
           </form>       
         </div>        
      <hr>
      <footer>
        <p>&copy; 2017 Company, Inc.</p>
      </footer>
    </div>
    
    
    <div class="row">
        <div class="col-md-4">
          <h2>My Income Tax </h2>
          <p><%  out.print(String.format("%.2f",student.getTotalIncomeTax()));  %></p>
          <h2>My Income Percent </h2>
          <p><%  out.print(String.format("%.2f",student.getTaxPercent()));  %></p>
			<!--  	<p><a class="btn btn-default" href="GpaServlet" role="button">View GPA </a></p>
        --> </div>        
        <div class="col-md-4">
          <h2>Enter the Infos For Tax </h2>
           <form action="IncomeTaxServlet" method="post">
           <div class="form-group">
    <label for="totalIncome">Enter Total Income</label>
    <input type="number" class="form-control" name="totalIncome" id="totalIncome">
  </div>
  <div class="form-group">
    <label for="status">Select Status</label>
    <select name="status">
	  <option value="unmarried">Unmarried Individuals</option>
	  <option value="married">Married Individuals Filing Joint Returns</option>
	  <option value="headsOfHousehold">For Heads of Households</option>
</select>
  </div>
           
             <button type="submit" class="btn btn-default">Submit</button>           
           </form>       
         </div>        
      <hr>
      <footer>
        <p>&copy; 2017 Company, Inc.</p>
      </footer>
    </div>
    
    
     <!-- /container -->
    </div>


</body>
</html>

