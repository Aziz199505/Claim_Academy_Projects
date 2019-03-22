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


<table border ="1" width="800" align="center">
	<thead  style="font-weight:bold;"  >
		<td>First Name</td>
		<td>Last Name </td>
		<td>Email</td>
		<td>School Name</td>
		<td>Address</td>
	 </thead>
	<tbody>
		
			<% 
            Student student = (Student) session.getAttribute("student");
			%>
			<tr  bgcolor="00FF7F"> 
            <td><%=student.getFirstName()%></td> 
            <td><%=student.getLastName()%></td> 
            <td><%=student.getEmail()%></td>
            <td><%=student.getSchoolName()%></td> 
            <td><%=student.getAddress()%></td>  
        	</tr> 
        	<%
			%>
		
	</tbody>

</table>

</body>
</html>

