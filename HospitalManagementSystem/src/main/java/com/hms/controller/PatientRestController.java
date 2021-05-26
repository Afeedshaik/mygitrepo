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

import com.hms.entity.BookAppointment;
import com.hms.entity.Patient;
import com.hms.entity.PatientRegister;
import com.hms.service.PatientService;



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
@RequestMapping({"/api","/patient"})
@CrossOrigin(origins = "*", allowCredentials = "false", methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE} , allowedHeaders = "*")
public class PatientRestController {
	
	@Autowired
	PatientService patientService; 
	Patient patient;
	PatientRegister patientregister;
	
	
	
	
	/**
	 * ResponseEntity is meant to represent the entire HTTP response. You can
	 * control anything that goes into it: status code, headers, and body.
	 * 
	 * getPatientList() is a user defined method that is used to fetch and print the
	 * patient records like a list in the database to view such as using Read
	 * operation of CRUD operations.
	 * 
	 * @GetMapping annotation maps HTTP GET requests onto specific handler methods.
	 *             It is a composed annotation that acts as a shortcut
	 *             for @RequestMapping(method = RequestMethod. GET) .
	 * 
	 * @return status code 200 with the list of patients if the list is not empty.
	 * @return status code 205 if the list object is empty.
	 */
	@GetMapping("/allpatient")
	public ResponseEntity<List<Patient>> allPatient() {
		List<Patient> li = patientService.getPatientList();
		System.out.println("Patient list : "+li);
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Patient>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Patient>>(li,HttpStatus.OK);
	}
	
	
	
	
	/**
	 * ResponseEntity is meant to represent the entire HTTP response. You can
	 * control anything that goes into it: status code, headers, and body.
	 * 
	 * getPatientById() is a user defined method that is used for fetching
	 * individual record/row from the database patient table using the patient_id
	 * value.
	 * 
	 * @GetMapping annotation maps HTTP GET requests onto specific handler methods.
	 *             It is a composed annotation that acts as a shortcut
	 *             for @RequestMapping(method = RequestMethod. GET) .
	 * 
	 * @param id that is patient_id
	 * @return status code 200 with the list of patients if the list is not empty.
	 * @return status code 205 if the list object is empty.
	 */
	@GetMapping("/getPatient/{patient_id}")
	public ResponseEntity<List<Patient>> getPatientById(@PathVariable("patient_id") int id) {
		List<Patient>  li = patientService.getPatientById(id);
		if(li.isEmpty()) {
			return new ResponseEntity<List<Patient>>(HttpStatus.NO_CONTENT);
			
		}
		return new ResponseEntity<List<Patient>>(li,HttpStatus.OK);
	}
	
	
	
	/**
	 * ResponseEntity is meant to represent the entire HTTP response. You can
	 * control anything that goes into it: status code, headers, and body.
	 * 
	 * createPatient() is a user defined method that is used as Create of CRUD
	 * operations, that is used to register and store patient details in a secured
	 * database.
	 * 
	 * @PostMapping is specialized version of @RequestMapping annotation that acts
	 *              as a shortcut for @RequestMapping(method = RequestMethod. POST)
	 *              . @PostMapping annotated methods handle the HTTP POST requests
	 *              matched with given URI expression.
	 * 
	 * @PathVariable is a Spring annotation which indicates that a method parameter
	 *               should be bound to a URI template variable.
	 * @param patient Object of Patient class.
	 * @return patient Object of Patient class.
	 */
	@PostMapping("/createPatient")
	public Patient createPatient(@RequestBody Patient patient)
	{
		patientService.createPatient(patient);
		return patient;
	}
	
	
	
	/**
	 * ResponseEntity is meant to represent the entire HTTP response. You can
	 * control anything that goes into it: status code, headers, and body.
	 * 
	 * deletePatient() is a user defined method that is used for deleting a whole
	 * record or row in the database patient table which is used as Delete operation
	 * from CRUD operations approach. After deleting one row/record, the updated
	 * list of patients will be returned.
	 * 
	 * @DeleteMapping is a composed annotation that acts as a shortcut
	 *                for @RequestMapping(method = RequestMethod.DELETE).
	 * 
	 * @PathVariable is a Spring annotation which indicates that a method parameter
	 *               should be bound to a URI template variable.
	 * @param ptid Variable assigned to the value of patient_id.
	 * @return status code 200 with the list of patients if the list is not empty.
	 * @return status code 205 if the list object is empty.
	 */
	@DeleteMapping("/deletePatient/{patient_id}")
	public  ResponseEntity<List<Patient>> deletePatient(@PathVariable("patient_id") int ptid) {
		
		List<Patient> li = patientService.deletePatient(ptid);
		System.out.println("Patient List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Patient>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Patient>>(li,HttpStatus.OK);
		
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
	 * @param patient
	 * @return status code 200 with the list of patients if the list is not empty.
	 * @return status code 205 if the list object is empty.
	 */
	@PutMapping("/updatePatient")
	public  ResponseEntity<List<Patient>> updatePatient(@RequestBody Patient patient) {
		
		List<Patient> li = patientService.updatePatient(patient);
		System.out.println("Patient List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<Patient>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Patient>>(li,HttpStatus.OK);
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
	 * @return status code 200 with the particular Patient if the variable patient is not null.
	 * @return status code 205 if the variable patient is null.
	 */
	@GetMapping("/validate/email={email}&password={password}")
	private ResponseEntity<Patient> validatPatient(@PathVariable("email") String email, @PathVariable("password") String password) {
		Patient p=new Patient();
		p.setEmail(email);
		p.setPassword(password);
		Patient patient = patientService.getPatient(p);
		System.out.println(patient);
		
		if(patient  ==  null) {
			return new ResponseEntity<Patient>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	/*@GetMapping("/allpatientregister")
	public ResponseEntity<List<PatientRegister>> allPatientRegister() {
		List<PatientRegister> li = patientService.getPatientRegisterList();
		System.out.println("Patient list : "+li);
		if(li.isEmpty())
		{
			return new ResponseEntity<List<PatientRegister>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<PatientRegister>>(li,HttpStatus.OK);
	}*/
	
	
	@PostMapping("/bookAppointment")
	public BookAppointment createBookAppointment(@RequestBody BookAppointment book)
	{
		patientService.createBookAppointment(book);
		return book;
	}
	
	
	
	@GetMapping("/booklist")
	public ResponseEntity<List<BookAppointment>> allBookList() {
		List<BookAppointment> li = patientService.getBookAppointmentList();
		System.out.println("Patient list : "+li);
		if(li.isEmpty())
		{
			return new ResponseEntity<List<BookAppointment>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BookAppointment>>(li,HttpStatus.OK);
	}
	
	@PutMapping("/updateAppointment")
	public  ResponseEntity<List<BookAppointment>> updateAppointment(@RequestBody BookAppointment book) {
		
		List<BookAppointment> li = patientService.updateAppointment(book);
		System.out.println("Appointment List : " + li);
		
		if(li.isEmpty())
		{
			return new ResponseEntity<List<BookAppointment>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BookAppointment>>(li,HttpStatus.OK);
	}
	
	@GetMapping("/getAppointment/{booking_id}")
	public ResponseEntity<List<BookAppointment>> getAppointmentById(@PathVariable("booking_id") int id) {
		List<BookAppointment>  li = patientService.getAppointmentById(id);
		if(li.isEmpty()) {
			return new ResponseEntity<List<BookAppointment>>(HttpStatus.NO_CONTENT);
			
		}
		return new ResponseEntity<List<BookAppointment>>(li,HttpStatus.OK);
	}

}
