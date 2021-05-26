package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.dao.AdminDao;
import com.hms.dao.DoctorDao;

import com.hms.entity.Doctor;
import com.hms.entity.DoctorRegister;



/**
 * Service layer mediates communication between a controller and DAO/repository
 * layer. This particular class is used as implementation for Service interface
 * of Doctor operations.
 * 
 * @author DEBANJAN
 *
 */
@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	DoctorDao doctorDao;
	@Autowired
	AdminDao adminDao;

	
	
	/**
	 * createDoctor() is a user defined method that is used as Create operation in
	 * CRUD operations which registers/adds doctor along with respective details in
	 * the database doctor table.
	 */
	@Override
	public void createDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		doctorDao.createDoctor(doctor);
	}

	
	/**
	 * getDoctorList() is a user defined method that is used to fetch and print the
	 * doctor records like a list in the database to read such as using Read
	 * operation of CRUD operations.
	 */
	@Override
	public List<Doctor> getDoctorList() {
		// TODO Auto-generated method stub
		return doctorDao.getDoctorList();
	}

	
	/**
	 * getDoctor() is a user defined method that is used for fetching individual
	 * records from the database table and print it just like Read operation from
	 * the CRUD operations.
	 */
	@Override
	public Doctor getDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorDao.getDoctor(doctor);
	}

	
	/**
	 * updateDoctor() is a user defined method that is used for updating the values
	 * present in the database doctor table which is used as Update operation from
	 * CRUD operations. After updating, it will return the updated list of doctors.
	 */
	@Override
	public List<Doctor> updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorDao.updateDoctor(doctor);
	}

	
	/**
	 * deleteDoctor() is a user defined method that is used for deleting a whole
	 * record or row in the database doctor table which is used as Delete operation
	 * from CRUD operations. After deleting one row/record, the updated list of
	 * doctors will be returned.
	 */
	@Override
	public List<Doctor> deleteDoctor(int eid) {
		// TODO Auto-generated method stub
		return doctorDao.deleteDoctor(eid);
	}

	
	/**
	 * getDoctorById() is a user defined method that is used for fetching individual
	 * record/row from the database doctor table using the doctor_id value.
	 */
	@Override
	public List<Doctor> getDoctorById(int eid) {
		// TODO Auto-generated method stub
		return doctorDao.getDoctorById(eid);
	}

	
	/**
	 * search() is a user defined method that is used for fetching individual
	 * record/row from the database doctor table using the firstName value.
	 */
	@Override
	public Doctor search(String name) {
		// TODO Auto-generated method stub
		return doctorDao.search(name);
	}

/*	@Override
	public void doctorRegistration(DoctorRegister doctorregister) {
		adminDao.doctorRegistration(doctorregister);
		
	}

	@Override
	public DoctorRegister Login(DoctorRegister doctorregister) {
		// TODO Auto-generated method stub
		return doctorDao.Login(doctorregister);
	}*/

	
}