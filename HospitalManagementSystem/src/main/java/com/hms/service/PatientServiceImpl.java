package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.dao.PatientDao;
import com.hms.entity.BookAppointment;
import com.hms.entity.Patient;
import com.hms.entity.PatientRegister;



/**
 * Service layer mediates communication between a controller and DAO/repository
 * layer. 
 * This particular class is used as implementation for Service interface of Patient operations.
 * 
 * @author BRAMHAJI
 *
 */
@Service
@Transactional
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientDao patientDao;
	/*@Override
	public void patientRegistration(PatientRegister patientregister) {
		// TODO Auto-generated method stub
		patientDao.patientRegistration(patientregister);
	}*/

	
	/**
	 * createPatient() is a user defined method that is used as Create of CRUD
	 * operations, that is used to register and store patient details in a secured
	 * database.
	 */
	@Override
	public void createPatient(Patient patient) {
		// TODO Auto-generated method stub
		patientDao.createPatient(patient);
		
	}

	
	/**
	 * getPatientList() is a user defined method that is used to fetch and print the
	 * patient records like a list in the database to view such as using Read
	 * operation of CRUD operations.
	 */
	@Override
	public List<Patient> getPatientList() {
		// TODO Auto-generated method stub
		return patientDao.getPatientList();
	}

	
	/**
	 * getPatient() is a user defined method that is used for fetching individual
	 * record/row from the database table for viewing it just like Read operation
	 * from the CRUD operations.
	 */
	@Override
	public Patient getPatient(Patient Patient) {
		// TODO Auto-generated method stub
		return patientDao.getPatient(Patient);
	}

	
	/**
	 * updatePatient() is a user defined method that is used for updating the values
	 * present in the database patient table which is used as Update operation from
	 * CRUD operations approach. After updating, it will return the updated list of
	 * patients.
	 */
	@Override
	public List<Patient> updatePatient(Patient Patient) {
		// TODO Auto-generated method stub
		return patientDao.updatePatient(Patient);
	}
	
	
	/**
	 * deletePatient() is a user defined method that is used for deleting a whole
	 * record or row in the database patient table which is used as Delete operation
	 * from CRUD operations approach. After deleting one row/record, the updated
	 * list of patients will be returned.
	 */
	@Override
	public List<Patient> deletePatient(int patient_id) {
		// TODO Auto-generated method stub
		return patientDao.deletePatient(patient_id);
	}

	
	
	/**
	 * getPatientById() is a user defined method that is used for fetching
	 * individual record/row from the database patient table using the patient_id
	 * value.
	 */
	@Override
	public List<Patient> getPatientById(int patient_id) {
		// TODO Auto-generated method stub
		return patientDao.getPatientById(patient_id);
	}

	
	
	/**
	 * search() is a user defined method that is used for fetching individual
	 * record/row from the database patient table using the firstName value.
	 */
	@Override
	public Patient search(String name) {
		// TODO Auto-generated method stub
		return patientDao.search(name);
	}

	/*@Override
	public PatientRegister Login(PatientRegister patientregister) {
		// TODO Auto-generated method stub
		return patientDao.Login(patientregister);
	}*/

	
	
	/**
	 * createBookAppointment() is a user defined method that is used as Create
	 * operation which is one of the CRUD operations approach that is being used for
	 * booking appointments into the respective database.
	 */
	@Override
	public void createBookAppointment(BookAppointment bookappointment) {
		// TODO Auto-generated method stub
		patientDao.createBookAppointment(bookappointment);
		
	}

	
	
	/**
	 * getBookAppointmentList() is a user defined method that is used to fetch and
	 * print the booked appointment records, like a list, in the database to read
	 * such as using Read operation of CRUD operations approach.
	 */
	@Override
	public List<BookAppointment> getBookAppointmentList() {
		// TODO Auto-generated method stub
		return patientDao.getBookAppointmentList();
	}

	
	/**
	 * updateAppointment() is a user defined method that is used for updating the values
	 * present in the database BookAppointment table which is used as Update operation from
	 * CRUD operations approach. After updating, it will return the updated list of
	 * Appointments.
	 */
	@Override
	public List<BookAppointment> updateAppointment(BookAppointment bookappointment) {
		// TODO Auto-generated method stub
		return patientDao.updateAppointment(bookappointment);
	}

	
	
	/**
	 * getAppointmentById() is a user defined method that is used for fetching
	 * individual record/row from the database BookAppointment table using the booking_id
	 * value.
	 */
	@Override
	public List<BookAppointment> getAppointmentById(int booking_id) {
		// TODO Auto-generated method stub
		return patientDao.getAppointmentById(booking_id);
	}

	/*@Override
	public List<PatientRegister> getPatientRegisterList() {
		// TODO Auto-generated method stub
		return patientDao.getPatientRegisterList();
	}*/

}
