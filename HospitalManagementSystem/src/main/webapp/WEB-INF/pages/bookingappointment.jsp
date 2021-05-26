<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Appointment</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head><body>
<h1> Booking Appointment  </h1>
<!---728x90--->
    <div class="bg-agile">
	<div class="book-appointment">
	
			<form action="bookingappointment" method="post">
			<div class="left-agileits-w3layouts same">
			<div class="gaps">
				<p>Select Appointment Date</p>
				<input type="date" name="appointment_date"  /> <i
					class="fas fa-calendar-alt"></i>
			</div>
			<div class="gaps">
				<p>Patient Name</p>
					<input type="text" name="patientname" placeholder="" required=""/>
			</div>	
				<div class="gaps">	
				<p>Phone Number</p>
					<input type="text" name="mobilenumber" placeholder="" required=""/>
				</div>
				<div class="gaps">
				<p>Email</p>
						<input type="text" name="email" placeholder="" required="" />
				</div>	
				<div class="gaps">
				<p>Patient_Age</p>
						<input type="number" name="patientage" placeholder="" required="" />
				</div>
				<div class="gaps">
				<p>Symptoms</p>
						<textarea name="symptoms" placeholder="" required="" ></textarea>
				</div>
			</div>
			
			
			<div class="gaps">
				<p>Gender</p>
				  	
					<select class="form-control" name="gender">
						<option></option>
						<option>Male</option>
						<option>Female</option>
					</select>
			</div>
			
			
			<div class="clear"></div>
						  <input type="submit" value="Make an appointment">
			</form>
	
   </div>

</body>

</html>