package com.hms.service;

import java.util.List;


import com.hms.entity.Doctor;
import com.hms.entity.DoctorRegister;



/**
 * Service layer mediates communication between a controller and DAO/repository
 * layer. 
 * This particular interface is used as Service interface of Doctor operations.
 * 
 * @author DEBANJAN
 *
 */

public interface DoctorService {
	public void createDoctor(Doctor doctor);
	public List<Doctor> getDoctorList();
	public Doctor getDoctor(Doctor doctor);
	public List<Doctor> updateDoctor(Doctor doctor);
	public List<Doctor> deleteDoctor(int doctor_id);
	public List<Doctor> getDoctorById(int doctor_id);
	public Doctor search(String name);
	
	//public void doctorRegistration(DoctorRegister doctorregister);
	//public DoctorRegister Login(DoctorRegister doctorregister);


}
