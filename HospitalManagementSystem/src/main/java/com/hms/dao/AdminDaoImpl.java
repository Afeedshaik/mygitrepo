package com.hms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.entity.DoctorRegister;
@Repository
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/*@Override
	public void doctorRegistration(DoctorRegister doctorregister) {
		 getSession().saveOrUpdate(doctorregister);
	        System.out.println("Doctor details Stored in DB Successfully !!!");
		
	}*/

}
