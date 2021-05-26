package com.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hms.entity.DoctorRegister;
import com.hms.entity.Patient;
import com.hms.service.DoctorService;
import com.hms.service.PatientService;

@Controller
public class DoctorController {
	
	/*DoctorRegister doctorregister;

	@Autowired
	DoctorService doctorService;
	
	@Autowired
	PatientService patientService;
	
	
	@RequestMapping(value = "/registerDoctor", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("registerDoctor");
	}

	@RequestMapping(value = "/loginDoctor", method = RequestMethod.GET)
	public ModelAndView sigin() {
		return new ModelAndView("loginDoctor");
	}
	
	@RequestMapping(value="/registerDoctor", method=RequestMethod.POST)
	public ModelAndView sigup(@RequestParam("txtusername") String Username,
					@RequestParam("txtpassword") String password,

					@RequestParam("txtemail") String email) {
	 System.out.println(Username + " " + password + email);
	 doctorregister = new DoctorRegister();
	 
	 doctorregister.setUsername(Username);
	 doctorregister.setPassword(password);
	 doctorregister.setEmail(email);
	 
	 doctorService.doctorRegistration(doctorregister);
	 
	 
	 return new ModelAndView("loginDoctor");
	}
	
	
	
	public ModelAndView showHome() {
		
		List<Patient> li = patientService.getPatientList();
		ModelAndView mv= new ModelAndView("home");
		mv.addObject("patientlist", li);
		return mv;
	}
	
	
	@RequestMapping(value = "/signinDoctor", method = RequestMethod.GET)
	public ModelAndView signin(@RequestParam("txtusername") String username, @RequestParam("txtpassword") String password) {
		doctorregister = new DoctorRegister();
		doctorregister.setPassword(password);
		doctorregister.setUsername(username);
		
		DoctorRegister dr =doctorService.Login(doctorregister) ;
		
		if(dr == null) {
			ModelAndView mv = new ModelAndView("loginDoctor");
			mv.addObject("msg", "Doctor Not Found ");
			return mv;
		}
		else {
			return showHome();
		}
			
	}*/
}
