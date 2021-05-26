package com.hms.dao;

import java.util.List;


import com.hms.entity.Doctor;
import com.hms.entity.DoctorRegister;



/**
 * This is a interface in Data Access Object(DAO) layer for Doctor which holds specific data operations without exposing details of the database.
 * This particular class is used as a connection between DAO layer and service layer. 
 * Basically the DAO pattern is used to isolate the application layer from persistence layer which has persistence frameworks like JDBC, Hibernate, JPA, etc.
 * @author AFEED
 */
public interface DoctorDao {
//	public DoctorRegister Login(DoctorRegister doctorregister);
	public void createDoctor(Doctor doctor);
	public List<Doctor> getDoctorList();
	public Doctor getDoctor(Doctor Doctor);
	public List<Doctor> updateDoctor(Doctor Doctor);
	public List<Doctor> deleteDoctor(int doctor_id);
	public List<Doctor> getDoctorById(int doctor_id);
	public Doctor search(String name);
	
	

}
