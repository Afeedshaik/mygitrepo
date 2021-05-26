<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Employee</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style>
input[type="radio"] {
	position: relative;
}

.note {
	text-align: center;
	height: 80px;
	background: -webkit-linear-gradient(left, #0072ff, #8811c5);
	color: #fff;
	font-weight: bold;
	line-height: 80px;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<h3 class="note">Patient List</h3>

		<div class="row">
			<div class="col-md-8 mx-auto">

				<form action="viewPatient" method="post">
				
					<div class="col-md-8 mx-auto">
				<table class="table table-striped">
					<thead class="thead-dark">
						<tr>
							<th scope="col">ID</th>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">Gender</th>
							<th scope="col">Diagnosis</th>
							<th scope="col">AGE</th>
							<th scope="col">PHONE</th>
							<th scope="col">Email</th>
							<th scope="col">Address</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${patient.patient_id}</td>
							<td>${patient.firstName}</td>
							<td>${patient.lastName}</td>
							<td>${patient.gender}</td>
							<td>${patient.diagnosis}</td>
							<td>${patient.patient_age}</td>
							<td>${patient.phone_number}</td>
							<td>${patient.email}</td>
							<td>${patient.address}</td>

						</tr>


					</tbody>
				</table>
			</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary">view Patient list</button>
					</div>


				</form>
			</div>
			

		</div>

	</div>


</body>
</html>