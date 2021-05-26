package com.hms.service;

import java.util.List;

import com.hms.entity.BookAppointment;
import com.hms.entity.Patient;
import com.hms.entity.PatientRegister;

/**
 * Service layer mediates communication between a controller and DAO/repository
 * layer. 
 * This particular interface is used as Service interface of Patient operations.
 * 
 * @author BRAMHAJI
 *
 */
public interface PatientService {
	//public void patientRegistration(PatientRegister patientregister);
	//public PatientRegister Login(PatientRegister patientregister);
	public void createPatient(Patient patient);
	public List<Patient> getPatientList();
	public Patient getPatient(Patient patient);
	public List<Patient> updatePatient(Patient patient);
	public List<Patient> deletePatient(int patient_id);
	public List<Patient> getPatientById(int patient_id);
	public Patient search(String name);
	

	void createBookAppointment(BookAppointment bookappointment);

	
	public List<BookAppointment> updateAppointment(BookAppointment bookappointment);
	public List<BookAppointment> getBookAppointmentList();
	public List<BookAppointment> getAppointmentById(int booking_id);
	//public List<PatientRegister> getPatientRegisterList();



}
