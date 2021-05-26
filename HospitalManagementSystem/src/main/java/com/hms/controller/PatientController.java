package com.hms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hms.entity.BookAppointment;
import com.hms.entity.PatientRegister;
import com.hms.service.PatientService;




@Controller
public class PatientController {
	
	
	/*
	PatientRegister patientregister;
	
	BookAppointment bookappointment;
	
	@Autowired
	PatientService patientService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView sigin() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView sigup(@RequestParam("txtusername") String Username,
					@RequestParam("txtpassword") String password,

					@RequestParam("txtemail") String email) {
	 System.out.println(Username + " " + password + email);
	 patientregister = new PatientRegister();
	 
	 patientregister.setUsername(Username);
	 patientregister.setPassword(password);
	 patientregister.setEmail(email);
	 
	 patientService.patientRegistration(patientregister);
	 
	 
	 return new ModelAndView("login");
	}
	
	
	
	public ModelAndView allPatient() {
		
		return new ModelAndView("home");
	}
	
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signin(@RequestParam("txtusername") String username, @RequestParam("txtpassword") String password) {
		patientregister = new PatientRegister();
		patientregister.setPassword(password);
		patientregister.setUsername(username);
		
		PatientRegister pr =patientService.Login(patientregister) ;
		
		if(pr == null) {
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("msg", "Patient Not Found ");
			return mv;
		}
		else {
			return allPatient();
		}
			
	}
	
	
	
	
	
	@RequestMapping(value = "/bookingappointment", method = RequestMethod.GET)
	public ModelAndView book() {
		return new ModelAndView("bookingappointment");
		
	}
	@RequestMapping(value = "/bookingappointment", method = RequestMethod.POST)
	public ModelAndView bookingappointment(@RequestParam("appointment_date")@DateTimeFormat(pattern="dd-mm-yyyy") Date appointment_date,@RequestParam("patientname") String patientname,
			 @RequestParam("gender") String gender,@RequestParam("mobilenumber") int mobilenumber,@RequestParam("patientage") int patientage,
			@RequestParam("email") String email,@RequestParam("symptoms") String symptoms) {

		System.out.println(patientname + " " + mobilenumber + email + patientage + symptoms + gender);
		bookappointment = new BookAppointment();
		bookappointment.setAppointment_date(appointment_date);
		bookappointment.setPatientname(patientname);
		bookappointment.setMobilennumber(mobilenumber);
		bookappointment.setEmail(email);
		bookappointment.setGender(gender);
		bookappointment.setPatientage(patientage);
		bookappointment.setSymptoms(symptoms);
		patientService.createBookAppointment(bookappointment);

		return allBookAppointmentList();
	}
	public ModelAndView allBookAppointmentList() {
		List<BookAppointment> li = patientService.getBookAppointmentList();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("appointmentlist", li);
		return mv;
	}

	*/
	
	
	
	
	
	

}
