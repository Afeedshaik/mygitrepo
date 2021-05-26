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

import com.hms.entity.BookAppointment;
import com.hms.entity.Patient;
import com.hms.entity.PatientRegister;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Transactional
@EnableSwagger2
@Repository

/**
 * This particular class is used as implementation for DAO interface.
 * Basically the Data Access Object(DAO) layer is used to isolate the application layer from persistence layer which has persistence frameworks like JDBC, Hibernate, JPA, etc.
 * @author AFEED
 */
public class PatientDaoImpl implements PatientDao {

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
	 * createPatient() is a user defined method that is used as Create of CRUD operations approach, that is used to register and store patient details in a secured database.
	 * saveOrUpdate() is used to INSERT or UPDATE depending upon whether an object(here that is patient) exists in the database or not.
	 * @param patient   Object of Patient class.
	 * 
	 */
	@Override
	public void createPatient(Patient patient) {
		getSession().saveOrUpdate(patient);
		System.out.println("Patient details stored successfully");

	}

	
	 /**
		 * getPatientList() is a user defined method that is used to fetch and print the patient records like a list in the 
		 * database to view such as using Read operation of CRUD operations approach.
		 * createQuery() method is used to create dynamic queries, which are queries defined directly 
		 * within an application’s business logic.
		 * list() method of java. util. Collections class is used to return an array list containing 
		 * the elements returned by the specified enumeration in the order they are returned by the enumeration.
		 * @return patientList  List of the patients records/rows.
		 */
	@Override
	public List<Patient> getPatientList() {
		Query query = getSession().createQuery("select me from Patient me");
		List<Patient> patientList = query.list();

		return patientList;
	}

	
	
	
	/**
	 * getPatient() is a user defined method that is used for fetching individual record/row from the database table for viewing 
	 * it just like Read operation from the CRUD operations approach.
	 * createCriteria() method is used to create a Criteria object that returns instances of the 
	 * persistence object's class when your application executes a criteria query.
	 * uniqueResult() method returns single instance of a persistence object.
	 * @param patient	Object of Patient class.
	 * @return pat	Individual record/row from the Patient table.   
	 */
	@Override
	public Patient getPatient(Patient patient) {
		Criteria c = getSession().createCriteria(Patient.class);
		c.add(Restrictions.eq("email", patient.getEmail()));
		c.add(Restrictions.eq("password", patient.getPassword()));
		//)
		Patient pat = (Patient) c.uniqueResult();
		return pat;
	}
	
	
	
	/**
	 * updatePatient() is a user defined method that is used for updating the values present in the database patient table which 
	 * is used as Update operation from CRUD operations approach. After updating, it will return the updated 
	 * list of patients.
	 * createQuery() method is used to create dynamic queries, which are queries defined directly 
	 * within an application’s business logic.
	 * setParameter() bind a value to a named parameter.
	 * executeUpdate() execute the update or delete statement.
	 * @param patient	Object of Patient class.
	 * @return getPatientList	The updated list of records/rows from Patient table.
	 */

	@Override
	public List<Patient> updatePatient(Patient patient) {
		Query query = getSession().createQuery("update Patient me set firstName=:firstName,"
				+ "lastName=:lastName,gender=:gender,diagnosis=:diagnosis,patient_age=:patient_age,"
				+ "phone_number=:phone_number,email=:email,address=:address,password=:password where patient_id=:patient_id");

		query.setParameter("firstName", patient.getFirstName());
		query.setParameter("lastName", patient.getLastName());
		query.setParameter("gender", patient.getGender());
		query.setParameter("diagnosis", patient.getDiagnosis());
		query.setParameter("patient_age", patient.getPatient_age());
		query.setParameter("phone_number", patient.getPhone_number());
		query.setParameter("email", patient.getEmail());
		query.setParameter("address", patient.getAddress());
		query.setParameter("password", patient.getPassword());
		
		query.setParameter("patient_id", patient.getPatient_id());
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Updated" + noofrows + "rows");
		}
		return getPatientList();
	}

	
	/**
	 * deletePatient() is a user defined method that is used for deleting a whole record or row in the database patient table which 
	 * is used as Delete operation from CRUD operations approach. After deleting one row/record, the updated 
	 * list of patients will be returned.
	 * createQuery() method is used to create dynamic queries, which are queries defined directly 
	 * within an application’s business logic.
	 * setParameter() bind a value to a named parameter.
	 * executeUpdate() execute the update or delete statement.
	 * @param patient_id	Patient ID
	 * @return getPatientList	The updated list of records/rows from the Patient table.
	 */
	@Override
	public List<Patient> deletePatient(int patient_id) {
		Query query = getSession().createQuery("delete Patient me where patient_id =:patient_id");
		query.setParameter("patient_id", patient_id);
		int noofrows = query.executeUpdate();
		if(noofrows > 0) {
			System.out.println("Deleted" + noofrows + "rows");
		}
		return getPatientList();
	}
	
	/**
	 * getPatientById() is a user defined method that is used for fetching individual record/row from the database patient table 
	 * using the patient_id value.
	 * createQuery() method is used to create dynamic queries, which are queries defined directly 
	 * within an application’s business logic.
	 * setParameter() bind a value to a named parameter.
	 * isEmpty() method checks whether a string is empty or not which returns true if the string 
	 * is empty (length() is 0), and false if not.
	 * @param patient_id	Patient ID
	 * @return li	Object of the list of patients. 
	 */

	@Override
	public List<Patient> getPatientById(int patient_id) {
		Query query = getSession().createQuery("from Patient me where patient_id =:patient_id");
		query.setParameter("patient_id", patient_id);
		List<Patient> li = query.list();
		if (!li.isEmpty()) {
			System.out.println("Patient Found ");
		}
		return li;
	}

	
	/**
	 * search() is a user defined method that is used for fetching individual record/row from the database patient table 
	 * using the firstName value.
	 * createQuery() method is used to create dynamic queries, which are queries defined directly 
	 * within an application’s business logic.
	 * setParameter() bind a value to a named parameter.
	 * uniqueResult() method returns single instance of a persistence object.
	 * @param name	First name of the patient.
	 * @return pat	Object of the Patient class. 
	 */
	@Override
	public Patient search(String name) {
		Query query = getSession().createQuery("select me Patient me where firstName =:firstName");
		query.setParameter("firstName", name);
		Patient pat = (Patient) query.uniqueResult();
		return pat;
	}

	/*
	@Override
	public void patientRegistration(PatientRegister patientregister) {
		// TODO Auto-generated method stub
		 getSession().saveOrUpdate(patientregister);
	        System.out.println("Patient details Stored in DB Successfully !!!");
			
		
	}
	
	@Override
	public List<PatientRegister> getPatientRegisterList() {
		Query query = getSession().createQuery("select me from PatientRegister me");
		List<PatientRegister> patientRegisterList = query.list();

		return patientRegisterList;
	}

	@Override
	public PatientRegister Login(PatientRegister patientregister) {
		Criteria c = getSession().createCriteria(PatientRegister.class);
		c.add(Restrictions.eq("username", patientregister.getUsername()));
		PatientRegister pr = (PatientRegister) c.uniqueResult();
		return pr;
	}
	*/
	
	
	
	/**
	 * createBookAppointment() is a user defined method that is used as Create operation which is one of the CRUD 
	 * operations approach that is being used for booking appointments into the respective database.
	 * saveOrUpdate() is used to INSERT or UPDATE depending upon whether an 
	 * object(here that is patient) exists in the database or not.
	 * @param bookappointment Object of the BookAppointment class
	 * 
	 */
	@Override
	public void createBookAppointment(BookAppointment bookappointment) {
		getSession().saveOrUpdate(bookappointment);
		System.out.println("Patient details stored successfully");

	}

	
	/**
	 * getBookAppointmentList() is a user defined method that is used to fetch and print the booked appointment records, like a list, in the 
	 * database to read such as using Read operation of CRUD operations approach.
	 * createQuery() method is used to create dynamic queries, which are queries defined directly 
	 * within an application’s business logic.
	 * list() method of java.util.Collections class is used to return an array list containing 
	 * the elements returned by the specified enumeration in the order they are returned by the enumeration.
	 * @return appointmentList
	 */
	@Override
	public List<BookAppointment> getBookAppointmentList() {
		
			Query query = getSession().createQuery("select me from BookAppointment me");
			List<BookAppointment> appointmentList = query.list();
			return appointmentList;
		
	}

	
	/**
	 * updateAppointment() is a user defined method that is used for updating the values present in the database BookAppointment table which 
	 * is used as Update operation from CRUD operations approach. After updating, it will return the updated 
	 * list of appointments.
	 * createQuery() method is used to create dynamic queries, which are queries defined directly 
	 * within an application’s business logic.
	 * setParameter() bind a value to a named parameter.
	 * executeUpdate() execute the update or delete statement.
	 * @param book	Object of BookAppointment class.
	 * @return getBookAppointmentList	The updated list of records/rows from BookAppointment table.
	 */
	@Override
	public List<BookAppointment> updateAppointment(BookAppointment book) {
		Query query = getSession().createQuery("update BookAppointment me set vaccine_status=:vaccine_status,vaccine_type=:vaccine_type,covid_symptoms=:covid_symptoms,appointment_date=:appointment_date, firstName=:firstName,"
				+ "lastName=:lastName,gender=:gender,age=:age,symptoms=:symptoms,"
				+ "phone_number=:phone_number,email=:email,address=:address,approval_status=:approval_status where booking_id=:booking_id");

		query.setParameter("vaccine_status", book.getVaccine_status());
		query.setParameter("vaccine_type", book.getVaccine_type());
		query.setParameter("covid_symptoms", book.getCovid_symptoms());
		query.setParameter("appointment_date", book.getAppointment_date());
		query.setParameter("firstName", book.getFirstName());
		query.setParameter("lastName", book.getLastName());
		query.setParameter("gender", book.getGender());
		query.setParameter("age", book.getAge());
		query.setParameter("symptoms", book.getSymptoms());
		query.setParameter("phone_number", book.getPhone_number());
		query.setParameter("email", book.getEmail());
		query.setParameter("address", book.getAddress());
		query.setParameter("approval_status", book.getApproval_status());
		
		query.setParameter("booking_id", book.getBooking_id());
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Updated" + noofrows + "rows");
		}
		return getBookAppointmentList();
	}

	
	
	/**
	 * getAppointmentById() is a user defined method that is used for fetching individual record/row from the database BookAppointment table 
	 * using the booking_id value.
	 * createQuery() method is used to create dynamic queries, which are queries defined directly 
	 * within an application’s business logic.
	 * setParameter() bind a value to a named parameter.
	 * isEmpty() method checks whether a string is empty or not which returns true if the string 
	 * is empty (length() is 0), and false if not.
	 * @param booking_id	Booking ID
	 * @return li	Object of the list of appointments. 
	 */
	
	@Override
	public List<BookAppointment> getAppointmentById(int booking_id) {
		Query query = getSession().createQuery("from BookAppointment me where booking_id =:booking_id");
		query.setParameter("booking_id", booking_id);
		List<BookAppointment> li = query.list();
		if (!li.isEmpty()) {
			System.out.println("record not Found ");
		}
		return li;
	}

	

	

}
