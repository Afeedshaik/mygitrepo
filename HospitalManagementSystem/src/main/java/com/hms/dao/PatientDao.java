package com.hms.dao;

import java.util.List;

import com.hms.entity.BookAppointment;
import com.hms.entity.Patient;
import com.hms.entity.PatientRegister;


/**
 * This is a interface in Data Access Object(DAO) layer for Patient which holds specific data operations without exposing details of the database.
 * This particular class is used as connection between DAO layer and service layer. 
 * Basically the DAO pattern is used to isolate the application layer from persistence layer which has persistence frameworks like JDBC, Hibernate, JPA, etc.
 * @author AFEED
 */
public interface PatientDao {
	//public void patientRegistration(PatientRegister patientregister);
	//public PatientRegister Login(PatientRegister patientregister);
	public void createBookAppointment(BookAppointment bookappointment);
	public List<BookAppointment> getBookAppointmentList();
	public List<BookAppointment> updateAppointment(BookAppointment book);
	public List<BookAppointment> getAppointmentById(int booking_id);
	
	public void createPatient(Patient patient);
	public List<Patient> getPatientList();
	public Patient getPatient(Patient patient);
	public List<Patient> updatePatient(Patient patient);
	public List<Patient> deletePatient(int patient_id);
	public List<Patient> getPatientById(int patient_id);
	public Patient search(String name);
	//public List<PatientRegister> getPatientRegisterList();

}
