<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List of users</title>
</head>
<body>
	<h1>List of users</h1>
	<p style='color: red'>Here you can see the list of the users, edit
		them or update.</p>
	<table border="1px" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th width="5%">id</th>
				<th width="15%">name</th>
				<th width="15%">email</th>
				<th width="10%">mobile</th>
				<th width="10%">age</th>
				<th width="10%">days</th>
				<th width="10%">months</th>
				<th width="10%">years</th>
				<th width="10%">actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
				<tr align="center">
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.mobileNo}</td>
					<td>${user.dob}</td>
					<td>${user.days}</td>
					<td>${user.months}</td>
					<td>${user.years}</td>
					<td><a
						href="${pageContext.request.contextPath}/user/edit/${user.id}.html">Edit</a><br />
						<a
						href="${pageContext.request.contextPath}/user/delete/${user.id}.html">Delete</a><br />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<a href="${pageContext.request.contextPath}/index.html">Home page</a>
	</p>

</body>
</html>