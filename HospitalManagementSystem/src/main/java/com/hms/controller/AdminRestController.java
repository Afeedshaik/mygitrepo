package com.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.entity.Admin;
import com.hms.entity.Doctor;
import com.hms.entity.Patient;
import com.hms.entity.PatientRegister;
import com.hms.service.AdminService;
import com.hms.service.DoctorService;
import com.hms.service.PatientService;



@RestController

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "false", methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE} , allowedHeaders = "*")
public class AdminRestController {
	
	AdminService adminService;
	Admin admin;
	@Autowired
	PatientService patientService; 
	Patient patient;
	PatientRegister patientregister;
	@Autowired
	DoctorService doctorService;
	Doctor doctor;
	
	
	
	
}