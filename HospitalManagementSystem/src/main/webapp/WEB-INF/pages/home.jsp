<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Home Page .....

	
	<a href="search" class="btn btn-success">Search patient</a>
	
	<input type="submit" value="Add Patient"
		onclick="window.location.href='register'" />
	<br>
	<br>
	<br> ${NOTIFICATION}
	
	
	<div>
		<table class="table">
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
				<c:forEach var="patient" items="${patientlist}">
					<tr>
						<td><c:out value="${patient.patient_id}"></c:out></td>
						<td><c:out value="${patient.firstName}"></c:out></td>
						<td><c:out value="${patient.lastName}"></c:out></td>
						<td><c:out value="${patient.gender}"></c:out></td>
						<td><c:out value="${patient.diagnosis}"></c:out></td>
						<td><c:out value="${patient.patient_age}"></c:out></td>
						<td><c:out value="${patient.phone_number}"></c:out></td>
						<td><c:out value="${patient.email}"></c:out></td>
						<td><c:out value="${patient.address}"></c:out></td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>