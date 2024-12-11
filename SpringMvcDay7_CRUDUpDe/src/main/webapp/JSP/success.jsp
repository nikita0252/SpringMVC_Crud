<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="right">
<a href="logout">LOGOUT</a>
</div>
<form action="">
	
	<table border="2">
	<tr>
	<th>ROLL NO</th>
	<th>NAME</th>
	<th>USERNAME</th>
	<th>PASSWORD</th>
	<th>ACTION</th>
	</tr>

<c:forEach items="${data }" var="s">
	
	<tr>
	<td>${s.rollno }</td>
	<td>${s.name }</td>
	<td>${s.username }</td>
	<td>${s.password }</td>
	<td><a href="delete?rollno=${s.rollno }">DELETE</a>||<a href="edit?rollno=${s.rollno }">EDIT</a></td>
	</tr>
	
	
	</c:forEach>
	</table>

</form>
</body>
</html>