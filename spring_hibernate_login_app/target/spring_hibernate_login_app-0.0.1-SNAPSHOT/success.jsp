<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success Page</title>
</head>
<body>
<table border="1">
<tr>
<th>Name</th>
<th>RollNo.</th>
<th>Username</th>
<th>Password</th>
<th>Actions</th>
</tr>

<c:forEach items="${data}" var="s">
<tr>

<td>${s.rollno}</td>
<td>${s.name}</td>
<td>${s.username}</td>
<td>${s.password}</td>
<td><a href="edit?rollno=${s.rollno}"> Edit </a> || <a href="delete?rollno=${s.rollno}"> Delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>