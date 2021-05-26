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

import com.hms.entity.Doctor;
import com.hms.entity.Patient;
import com.hms.service.DoctorService;



/**
 * Spring RestController takes care of mapping request data to the defined
 * request handler method.
 * 
 * @RestController annotation is used to define the RESTful web services. It
 *                 serves JSON, XML and custom response.
 * 
 * @RequestMapping annotation is used to define the Request URI to access the
 *                 REST Endpoints. We can define Request method to consume and
 *                 produce object. The default request method is GET.
 * 
 * @CrossOrigin enables cross-origin resource sharing only for this specific
 *              method. By default, its allows all origins, all headers, and the
 *              HTTP methods specified in the @RequestMapping annotation.
 * 
 * @author DEBANJAN
 *
 */
@RestController
@RequestMapping({"/api","/doctor"})
@CrossOrigin(origins = "*", allowCredentials = "false", methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE} , allowedHeaders = "*")
public class DoctorRestController {
	
	
	@Autowired
	DoctorService doctorService;
	Doctor doctor;
	
	
	
	
	/**
	 * ResponseEntity is meant to represent the entire HTTP response. You can
	 * control anything that goes into it: status code, headers, and body.
	 * 
	 * getDoctorList() is a user defined method that is used to fetch and print the
	 * patient records like a list in the database to view such as using Read
	 * operation of CRUD operations.
	 * 
	 * @GetMapping annotation maps HTTP GET requests onto specific handler methods.
	 *             It is a composed annotation that acts as a shortcut
	 *             for @RequestMapping(method = RequestMethod. GET) .
	 * 
	 * @return status code 200 with the list of doctors if the list is not empty.
	 * @return status code 204 if the list is empty.
	 */
	@GetMapping("/alldoctor")
	public ResponseEntity<List<Doctor>> allDoctor() {
		List<Doctor> li = doctorService.getDoctorList();
		System.out.println("Doctor list : "+li);
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Doctor>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Doctor>>(li,HttpStatus.OK);
	}
	
	
	
	/**
	 * ResponseEntity is meant to represent the entire HTTP response. You can
	 * control anything that goes into it: status code, headers, and body.
	 * 
	 * getDoctorById() is a user defined method that is used for fetching
	 * individual record/row from the database patient table using the doctor_id
	 * value.
	 * 
	 * @GetMapping annotation maps HTTP GET requests onto specific handler methods.
	 *             It is a composed annotation that acts as a shortcut
	 *             for @RequestMapping(method = RequestMethod. GET) .
	 * 
	 * @param id that is doctor_id
	 * @return status code 200 with the list of doctors if the list is not empty.
	 * @return status code 204 if the list is empty.
	 */
	@GetMapping("/getDoctor/{doctor_id}")
	public ResponseEntity<List<Doctor>> getDoctorById(@PathVariable("doctor_id") int id) {
		List<Doctor>  li = doctorService.getDoctorById(id);
		if(li.isEmpty()) {
			return new ResponseEntity<List<Doctor>>(HttpStatus.NO_CONTENT);
			
		}
		return new ResponseEntity<List<Doctor>>(li,HttpStatus.OK);
	}
	
	
	
	/**
	 * ResponseEntity is meant to represent the entire HTTP response. You can
	 * control anything that goes into it: status code, headers, and body.
	 * 
	 * createDoctor() is a user defined method that is used as Create of CRUD
	 * operations, that is used to register and store doctor details in a secured
	 * database.
	 * 
	 * @PostMapping is specialized version of @RequestMapping annotation that acts
	 *              as a shortcut for @RequestMapping(method = RequestMethod. POST)
	 *              . @PostMapping annotated methods handle the HTTP POST requests
	 *              matched with given URI expression.
	 * 
	 * @PathVariable is a Spring annotation which indicates that a method parameter
	 *               should be bound to a URI template variable.
	 * @param doctor Variable of Doctor class type.
	 * @return doctor Variable of Doctor class type.
	 */
	@PostMapping("/createDoctor")
	public Doctor create(@RequestBody Doctor doctor)
	{
		doctorService.createDoctor(doctor);
		return doctor;
	}
	
	
	
	/**
	 * ResponseEntity is meant to represent the entire HTTP response. You can
	 * control anything that goes into it: status code, headers, and body.
	 * 
	 * deleteDoctor() is a user defined method that is used for deleting a whole
	 * record or row in the database doctor table which is used as Delete operation
	 * from CRUD operations approach. After deleting one row/record, the updated
	 * list of doctors will be returned.
	 * 
	 * @DeleteMapping is a composed annotation that acts as a shortcut
	 *                for @RequestMapping(method = RequestMethod.DELETE).
	 * 
	 * @PathVariable is a Spring annotation which indicates that a method parameter
	 *               should be bound to a URI template variable.
	 * @param ptid Variable assigned to the value of doctor_id.
	 * @return status code 200 with the list of doctors if the list is not empty.
	 * @return status code 204 if the list is empty.
	 */
	@DeleteMapping("/deleteDoctor/{doctor_id}")
	public  ResponseEntity<List<Doctor>> deleteDoctor(@PathVariable("doctor_id") int docid) {
		
		List<Doctor> li = doctorService.deleteDoctor(docid);
		System.out.println("Doctor List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Doctor>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Doctor>>(li,HttpStatus.OK);
		
	}
	
	
	
	/**
	 * ResponseEntity is meant to represent the entire HTTP response. You can
	 * control anything that goes into it: status code, headers, and body.
	 * 
	 * updatePatient() is a user defined method that is used for updating the values
	 * present in the database patient table which is used as Update operation from
	 * CRUD operations approach. After updating, it will return the updated list of
	 * patients.
	 * 
	 * @PutMapping annotation for mapping HTTP PUT requests onto specific handler
	 *             methods. Specifically, @PutMapping is a composed annotation that
	 *             acts as a shortcut for @RequestMapping(method = RequestMethod.
	 * 
	 * @param doctor	Variable of Doctor class type.
	 * @return status code 200 with the list of doctors if the list is not empty.
	 * @return status code 204 if the list is empty.
	 */
	@PutMapping("/updateDoctor")
	public  ResponseEntity<List<Doctor>> updateDoctor(@RequestBody Doctor doctor) {
		
		List<Doctor> li = doctorService.updateDoctor(doctor);
		System.out.println("Doctor List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Doctor>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Doctor>>(li,HttpStatus.OK);
	}
	
	
	
	/**
	 * ResponseEntity is meant to represent the entire HTTP response. You can
	 * control anything that goes into it: status code, headers, and body.
	 * 
	 * getPatient() is a user defined method that is used for fetching individual
	 * record/row from the database table for viewing it just like Read operation
	 * from the CRUD operations.
	 * 
	 * @GetMapping annotation maps HTTP GET requests onto specific handler methods.
	 *             It is a composed annotation that acts as a shortcut
	 *             for @RequestMapping(method = RequestMethod. GET) .
	 * 
	 * @PathVariable is a Spring annotation which indicates that a method parameter
	 *               should be bound to a URI template variable.
	 * @param email
	 * @param password
	 * @return status code 200 with the particular doctor if the variable doctor is not null.
	 * @return status code 204 if the variable doctor is null.
	 */
	@GetMapping("/validate/email={email}&password={password}")
	private ResponseEntity<Doctor> validatDoctor(@PathVariable("email") String email, @PathVariable("password") String password) {
		Doctor d=new Doctor();
		d.setEmail(email);
		d.setPassword(password);
		Doctor doctor = doctorService.getDoctor(d);
		System.out.println(doctor);
		
		if(doctor  ==  null) {
			return new ResponseEntity<Doctor>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
	}

}
