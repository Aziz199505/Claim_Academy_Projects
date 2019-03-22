<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <c:forEach var = "item" items="${listCategory}">
	<td>
        <p>${item}</p>
    </td>     
    </c:forEach>

<form action="Basic" method="post">
    <table>
        <tr>
            <td><p>Enter your name:</p></td>
            <td><input name="user" face="verdana" size="2px" type="text"></td>
        </tr>
        <tr>
            <td><p>Enter your password:</p></td>
            <td><input face="verdana" size="2px" name="password" type="password"></td>
        </tr>
    </table>

    <input type="submit" value="Login">
    
</form>
</body>
</html>