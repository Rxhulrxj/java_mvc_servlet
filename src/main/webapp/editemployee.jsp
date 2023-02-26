
<%@page import="webMvcStudy.EmployeeDao"%>
<%@page import="webMvcStudy.EmployeeModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body class="container">
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	out.print(id);
	EmployeeDao emp = new EmployeeDao();
	List<EmployeeModel> list = emp.getEmployeeById(id);
	request.setAttribute("list", list);
	%>
	<c:forEach items="${list}" var="em">

		<form action="editemployee" method="post">
			<div class="mb-3 row">
				<div class="col">
					<label for="empname" class="form-label">Employee Name</label> <input
						type="text" class="form-control" id="empname"
						placeholder="employee Name" name="empname"
						value="${em.getEmpname()}">
				</div>
				<div class="col">
					<label for="designation" class="form-label">Employee
						Designation</label> <input type="text" class="form-control"
						id="designation" placeholder="employee Designation"
						name="designation" value="${em.getDesignation()}">
				</div>
				<div class="col">
					<label for="salary" class="form-label">Employee Salary</label> <input
						type="number" class="form-control" id="salary"
						placeholder="employee Salary" name="salary"
						value="${em.getSalary()}">
				</div>
			</div>
			<div class="row">
			<input type="hidden" value="${em.getId()}" name="empId" />
			<div class="float-end"><input type="submit" value="Update" class="btn btn-primary"></div>
			</div>
		</form>
	</c:forEach>
</body>
</html>