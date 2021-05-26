package com.hms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hms.entity.Doctor;
import com.hms.entity.DoctorRegister;
import com.hms.entity.Patient;
import com.hms.entity.PatientRegister;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Transactional
@EnableSwagger2
@Repository

/**
 * This is a class in Data Access Object(DAO) layer for Doctor which holds specific data operations without exposing details of the database.
 * This particular class is used as implementation for DAO interface. 
 * Basically the DAO pattern is used to isolate the application layer from persistence layer which has persistence frameworks like JDBC, Hibernate, JPA, etc.
 * @author AFEED
 */
public class DoctorDaoImpl implements DoctorDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	

    /**
	 * getSession() method returns the current session associated with the request, or create a new one if the request doesn't have a session.
	 * getCurrentSession() it creates a new Session if not exists , else use same session which is in current hibernate context.
	 * @return reference of the session object or null 
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	
	 /**
		 * createDoctor() is a user defined method that is used as Create operation in CRUD operations which registers/adds doctor along 
		 * with respective details in the database doctor table.
		 * saveOrUpdate() is used to INSERT or UPDATE depending upon whether an object(here that is doctor) exists in the database or not.
		 * @param doctor    Object of Doctor class.
		 * 
		 */
	@Override
	public void createDoctor(Doctor doctor) {
		getSession().saveOrUpdate(doctor);
		System.out.println("Doctor details stored successfully");
		
	}
	
	
	
	 /**
		 * getDoctorList() is a user defined method that is used to fetch and print the doctor records like a list in the 
		 * database to read such as using Read operation of CRUD operations.
		 * createQuery() method is used to create dynamic queries, which are queries defined directly 
		 * within an application’s business logic.
		 * list() method of java. util. Collections class is used to return an array list containing 
		 * the elements returned by the specified enumeration in the order they are returned by the enumeration.
		 * @return doctorList  List of the doctors records/rows.
		 */

	@Override
	public List<Doctor> getDoctorList() {
		Query query = getSession().createQuery("select me from Doctor me");
		List<Doctor> doctorList = query.list();

		return doctorList;
	}

	
	
	
	/**
	 * getDoctor() is a user defined method that is used for fetching individual records from the database table and print 
	 * it just like Read operation from the CRUD operations.
	 * createCriteria() method is used to create a Criteria object that returns instances of the 
	 * persistence object's class when your application executes a criteria query.
	 * uniqueResult() method returns single instance of a persistence object.
	 * @param doctor	Object of Doctor class.
	 * @return doc	Individual record/row from the Doctor table.   
	 */
	@Override
	public Doctor getDoctor(Doctor doctor) {
		Criteria c = getSession().createCriteria(Doctor.class);
		c.add(Restrictions.eq("email", doctor.getEmail()));
		c.add(Restrictions.eq("password", doctor.getPassword()));
		//)
		Doctor doc = (Doctor) c.uniqueResult();
		return doc;
	}
	
	
	
	/**
	 * updateDoctor() is a user defined method that is used for updating the values present in the database doctor table which 
	 * is used as Update operation from CRUD operations. After updating, it will return the updated 
	 * list of doctors.
	 * createQuery() method is used to create dynamic queries, which are queries defined directly 
	 * within an application’s business logic.
	 * setParameter() bind a value to a named parameter.
	 * executeUpdate() execute the update or delete statement.
	 * @param doctor	Object of Doctor class.
	 * @return getDoctorList	The updated list of records/rows from Doctor table.
	 */

	@Override
	public List<Doctor> updateDoctor(Doctor doctor) {
		Query query = getSession().createQuery("update Doctor me set firstName=:firstName,"
				+ "lastName=:lastName,gender=:gender,specialization=:specialization,doctor_dob=:doctor_dob,"
				+ "phone_number=:phone_number,email=:email,address=:address,password=:password where doctor_id=:doctor_id");

		query.setParameter("firstName", doctor.getFirstName());
		query.setParameter("lastName", doctor.getLastName());
		query.setParameter("gender", doctor.getGender());
		query.setParameter("doctor_dob", doctor.getDoctor_dob());
		query.setParameter("email", doctor.getEmail());
		query.setParameter("specialization", doctor.getSpecialization());
		query.setParameter("phone_number", doctor.getPhone_number());
		query.setParameter("address", doctor.getAddress());
		query.setParameter("password", doctor.getPassword());
		
		
		query.setParameter("doctor_id", doctor.getDoctor_id());
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Updated" + noofrows + "rows");
		}
		return getDoctorList();
		
	}
	
	
	 /**
		 * deleteDoctor() is a user defined method that is used for deleting a whole record or row in the database doctor table which 
		 * is used as Delete operation from CRUD operations. After deleting one row/record, the updated 
		 * list of doctors will be returned.
		 * createQuery() method is used to create dynamic queries, which are queries defined directly 
		 * within an application’s business logic.
		 * setParameter() bind a value to a named parameter.
		 * executeUpdate() execute the update or delete statement.
		 * @param doctor_id	Doctor ID.
		 * @return getDoctorList	The updated list of records/rows from the Doctor table.
		 */

	@Override
	public List<Doctor> deleteDoctor(int doctor_id) {
		Query query = getSession().createQuery("delete Doctor me where doctor_id =:doctor_id");
		query.setParameter("doctor_id", doctor_id);
		int noofrows = query.executeUpdate();
		if(noofrows > 0) {
			System.out.println("Deleted" + noofrows + "rows");
		}
		return getDoctorList();
	}

	
	
	/**
	 * getDoctorById() is a user defined method that is used for fetching individual record/row from the database doctor table 
	 * using the doctor_id value.
	 * createQuery() method is used to create dynamic queries, which are queries defined directly 
	 * within an application’s business logic.
	 * setParameter() bind a value to a named parameter.
	 * isEmpty() method checks whether a string is empty or not which returns true if the string 
	 * is empty (length() is 0), and false if not.
	 * @param doctor_id	Doctor ID
	 * @return li	Object of the list of doctors. 
	 */
	@Override
	public List<Doctor> getDoctorById(int doctor_id) {
		Query query = getSession().createQuery("from Doctor me where doctor_id =:doctor_id");
		query.setParameter("doctor_id", doctor_id);
		List<Doctor> li = query.list();
		if (!li.isEmpty()) {
			System.out.println("Doctor Found ");
		}
		return li;
	}

	/**
	 * search() is a user defined method that is used for fetching individual record/row from the database doctor table 
	 * using the firstName value.
	 * createQuery() method is used to create dynamic queries, which are queries defined directly 
	 * within an application’s business logic.
	 * setParameter() bind a value to a named parameter.
	 * uniqueResult() method returns single instance of a persistence object.
	 * @param name	First name of the doctor.
	 * @return doc	Object of the Doctor class. 
	 */
	@Override
	public Doctor search(String name) {
	Query query = getSession().createQuery("select me Doctor me where firstName =:firstName");
		query.setParameter("firstName", name);
		Doctor doc = (Doctor) query.uniqueResult();
		return doc;
	}

	/*@Override
	public DoctorRegister Login(DoctorRegister doctorregister) {
		Criteria c = getSession().createCriteria(DoctorRegister.class);
		c.add(Restrictions.eq("username", doctorregister.getUsername()));
		DoctorRegister dr = (DoctorRegister) c.uniqueResult();
		return dr;
	}*/

	

}
