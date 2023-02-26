<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="container">
	<form action="getdata">
		<div class="mb-3 row">
			<div class="col-5">
				<label for="empname" class="form-label">Employee Name</label> <input
					type="text" class="form-control" id="empname"
					placeholder="employee Name" name="empname">
			</div>
		</div>
		<div class="mb-3 row">
			<div class="col-5">
				<label for="designation" class="form-label">Employee
					Designation</label> <input type="text" class="form-control"
					id="designation" placeholder="employee Designation"
					name="designation">
			</div>
		</div>
		<div class="mb-3 row">
			<div class="col-5">
				<label for="salary" class="form-label">Employee Salary</label> <input
					type="text" class="form-control" id="salary"
					placeholder="employee salary" name="salary">
			</div>
		</div>
		<div class="mb-3 row text-center">
			<div class="col">
				<input type="submit" value="Add" class="btn btn-primary">
			</div>
		</div>

	</form>
</body>
</html>