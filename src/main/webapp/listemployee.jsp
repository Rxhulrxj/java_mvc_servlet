<%@page import="webMvcStudy.EmployeeDao"%>
<%@page import="webMvcStudy.EmployeeModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" >
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 class="display-4">Employee List</h1>
	<div class="d-flex flex-row-reverse me-5">
	<a href="addemployee.jsp" class="btn btn-primary ">Add Employee</a>
	</div>
	<table class="table">
	<tr>
	<th class="col-1">Id</th>
	<th class="col-5">Name</th>
	<th class="col">Designation</th>
	<th class="col">Salary</th>
	<th class="col">Action</th>
	</tr>
	<%
	EmployeeDao emp = new EmployeeDao();
	List<EmployeeModel> list = emp.getEmployee();
	request.setAttribute("list", list);
	%>
	<c:forEach items="${list}" var="em">
	<tr>
		<td>${em.getId()}</td>
		<td>${em.getEmpname()}</td>
		<td>${em.getDesignation()}</td>
		<td>${em.getSalary()}</td>
		<td><a href="editemployee.jsp?id=${em.getId()}" class="btn btn-primary">Edit</a> <a href="delemp?id=${em.getId()}" class="btn btn-danger">Delete</a></td>
	</tr>
	</c:forEach>
	
</table>
</body>
</html>