package com.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.hms.entity.DoctorRegister;
import com.hms.entity.Patient;
import com.hms.service.DoctorService;
import com.hms.service.PatientService;



@Controller
public class AdminController {
	
DoctorRegister doctorregister;
	
	
	@Autowired
	DoctorService doctorService;
	@Autowired
	PatientService patientService;
	
	
	
	
	
	@RequestMapping(value = "/loginAdmin", method = RequestMethod.GET)
	public ModelAndView siginAdmin() {
		return new ModelAndView("loginAdmin");
	}
	
	@RequestMapping(value = "/signinAdmin", method = RequestMethod.POST)
	public ModelAndView signinAdmin(@RequestParam("txtusername") String username, @RequestParam("txtpassword") String password) {
		if(password.equals("admin")&&username.equals("admin")) {
			return new ModelAndView("home");
		}
		else {
			return new ModelAndView("loginAdmin");
		}
	}
	
	/*@RequestMapping(value = "/viewPatient", method = RequestMethod.GET)
	public ModelAndView viewPage(@ModelAttribute("patient") Patient patient) {

		return new ModelAndView("list");
	}

	@RequestMapping(value = "/viewPatient", method = RequestMethod.POST)
	public ModelAndView viewResult(@ModelAttribute("patient") Patient patient) {

		return new ModelAndView("list", "patient", patientService.getPatientList());
	}*/
	

}
