package com.mph.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.mph.model.Doctor;

public class DoctorController {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction txn;

	public void addDoctor() {
		txn = session.beginTransaction();
		Doctor dc = new Doctor();
    	dc.setDid(25);
    	dc.setDname("rama");
    	Doctor dc1 = new Doctor();
    	dc1.setDid(96);
    	dc1.setDname("ravi");
    	
    	session.save(dc);
    	session.save(dc1);
		
		// session.getTransaction().commit();
		txn.commit();
		System.out.println("Doctor Successfully saved !!!");
		
	}
	public void viewDoctor() {

		// Query qry = session.createSQLQuery("select * from AMPHEMPLOYEE");
		System.out.println("----------------------------------");

		Query q = session.createQuery("FROM HMSDOCTOR");
		List<Doctor> elist = q.list();
		Iterator itr = elist.iterator();
		while (itr.hasNext()) {

			System.out.println(itr.next());
		}
		// txn.commit();
	}
	public void updateDoctor() {
		txn = session.beginTransaction();
		Query q = session.createQuery("update HMSDOCTOR set dname=:ln where did=96").setString("ln", "kumar");

		int noofrows = q.executeUpdate();
		txn.commit();
		System.out.println("Update Success !!!");
	}
	public void selectUsingCriteriaQuery() {
		txn = session.beginTransaction();
		Criteria c = session.createCriteria(Doctor.class); // select * from EMployee
		c.add(Restrictions.eq("did", 96)); // where eid=200
		Doctor d = (Doctor) c.uniqueResult();

		System.out.println("Doctor Retrived --> " + d);
	}

	public void selectUsingNamedQuery() {
		Query query = session.getNamedQuery("GET_DOC_BYID").setInteger("id", 25);
		Doctor dc = (Doctor) query.uniqueResult();
		System.out.println("Docter fetched using Named Query" + dc);
	}
	
	public void deleteDoctor() {
		txn = session.beginTransaction();
		Query query = session.createQuery("delete HMSDOCTOR where id = :ID");
		query.setParameter("ID", new Integer(96));
		 
		int result = query.executeUpdate();
		 
		txn.commit();
		if (result > 0) {
		    System.out.println("DOCTOR was removed");
		}
	
	}
}