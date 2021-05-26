package com.hms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * This is a class in entity layer which holds BookAppointment information.
 * @author AFEED
 *
 */
@EnableSwagger2
@Entity
public class BookAppointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int booking_id;
	@Column
	private String vaccine_status;
	@Column
	private String vaccine_type;
	@Column
	private String covid_symptoms;
	
	
	
	@Column
	private String appointment_date;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String email;
	@Column
	private String gender;
	@Column
	private int age;
	@Column
	private String phone_number;
	@Column
	private String symptoms;
	@Column
	private String address;
	@Column
	private String approval_status;
	
	
	/**
	 * 	Constructor generated from superclass.
	 * 	With super(), the superclass no-argument constructor is called.If a constructor does not
	 *  explicitly invoke a superclass constructor, the Java compiler automatically inserts a call
	 *  to the no-argument constructor of the superclass. If the super class does not have a 
	 *  no-argument constructor, you will get a compile-time error. 
	 *  
	 */
	public BookAppointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
	 * Constructor generated using fields.
	 * @param booking_id
	 * @param vaccine_status
	 * @param vaccine_type
	 * @param covid_symptoms
	 * @param appointment_date
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param age
	 * @param gender
	 * @param phone_number
	 * @param symptoms
	 * @param address
	 * @param approval_status
	 */

	public BookAppointment(int booking_id, String vaccine_status, String vaccine_type, String covid_symptoms,
			String appointment_date, String firstName, String lastName, String email, String gender, int age,
			String phone_number, String symptoms, String address, String approval_status) {
		super();
		this.booking_id = booking_id;
		this.vaccine_status = vaccine_status;
		this.vaccine_type = vaccine_type;
		this.covid_symptoms = covid_symptoms;
		this.appointment_date = appointment_date;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.age = age;
		this.phone_number = phone_number;
		this.symptoms = symptoms;
		this.address = address;
		this.approval_status = approval_status;
	}



	/**
	 * getter method for booking_id.
	 * Fetches the booking_id value.
	 * @return booking_id
	 */

	public int getBooking_id() {
		return booking_id;
	}

	
	
	/**
	 * setter method for booking_id.
	 * Sets the booking_id value.
	 * @param booking_id
	 */
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	
	/**
	 * getter method for vaccine_status.
	 * Fetches the vaccine_status value.
	 * @return vaccine_status
	 */
	public String getVaccine_status() {
		return vaccine_status;
	}

	
	/**
	 * setter method for vaccine_status.
	 * Sets the vaccine_status value.
	 * @param vaccine_status
	 */
	public void setVaccine_status(String vaccine_status) {
		this.vaccine_status = vaccine_status;
	}

	
	
	/**
	 * getter method for vaccine_type.
	 * Fetches the vaccine_type value.
	 * @return vaccine_type
	 */
	public String getVaccine_type() {
		return vaccine_type;
	}

	
	/**
	 * setter method for vaccine_type.
	 * Sets the vaccine_type value.
	 * @param vaccine_type
	 */
	public void setVaccine_type(String vaccine_type) {
		this.vaccine_type = vaccine_type;
	}

	
	/**
	 * getter method for covid_symptoms.
	 * Fetches the covid_symptoms value.
	 * @return covid_symptoms
	 */
	public String getCovid_symptoms() {
		return covid_symptoms;
	}

	
	/**
	 * setter method for covid_symptoms.
	 * Sets the covid_symptoms value.
	 * @param covid_symptoms
	 */
	public void setCovid_symptoms(String covid_symptoms) {
		this.covid_symptoms = covid_symptoms;
	}

	
	
	/**
	 * getter method for appointment_date.
	 * Fetches the appointment_date value.
	 * @return appointment_date
	 */
	public String getAppointment_date() {
		return appointment_date;
	}

	/**
	 * setter method for appointment_date.
	 * Sets the appointment_date value.
	 * @param appointment_date
	 */
	public void setAppointment_date(String appointment_date) {
		this.appointment_date = appointment_date;
	}

	
	/**
	 * getter method for firstName.
	 * Fetches the firstName value.
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	
	/**
	 * setter method for firstName.
	 * Sets the firstName value.
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	
	/**
	 * getter method for lastName.
	 * Fetches the lastName value.
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	
	
	 /**
		 * setter method for lastName.
		 * Sets the lastName value.
		 * @param lastName
		 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	
	 /**
		 * getter method for email.
		 * Fetches the email value.
		 * @return email
		 */
	public String getEmail() {
		return email;
	}

	
	/**
	 * setter method for email.
	 * Sets the email value.
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	
	
	/**
	 * getter method for gender.
	 * Fetches the gender value.
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}

	
	/**
	 * setter method for gender.
	 * Sets the gender value.
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	
	
	/**
	 * getter method for phone_number.
	 * Fetches the phone_number value.
	 * @return phone_number
	 */
	public String getPhone_number() {
		return phone_number;
	}

	
	/**
	 * setter method for phone_number.
	 * Sets the phone_number value.
	 * @param phone_number
	 */
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	
	
	/**
	 * getter method for symptoms.
	 * Fetches the symptoms value.
	 * @return symptoms
	 */
	public String getSymptoms() {
		return symptoms;
	}

	
	/**
	 * setter method for symptoms.
	 * Sets the symptoms value.
	 * @param symptoms
	 */
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	/**
	 * getter method for address.
	 * Fetches the address value.
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	
	/**
	 * setter method for address.
	 * Sets the address value.
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	
	/**
	 * getter method for approval_status.
	 * Fetches the approval_status value.
	 * @return approval_status
	 */
	public String getApproval_status() {
		return approval_status;
	}


	/**
	 * setter method for approval_status.
	 * Sets the approval_status value.
	 * @param approval_status
	 */
	public void setApproval_status(String approval_status) {
		this.approval_status = approval_status;
	}


	/**
	 * getter method for age.
	 * Fetches the age value.
	 * @return age
	 */
	public int getAge() {
		return age;
	}




	/**
	 * setter method for age.
	 * Sets the age value.
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}



	/**
	 * The toString() method returns the string representation of the object(s).
	 * @return String 
	 */
	@Override
	public String toString() {
		return "BookAppointment [booking_id=" + booking_id + ", vaccine_status=" + vaccine_status + ", vaccine_type="
				+ vaccine_type + ", covid_symptoms=" + covid_symptoms + ", appointment_date=" + appointment_date
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender
				+ ", age=" + age + ", phone_number=" + phone_number + ", symptoms=" + symptoms + ", address=" + address
				+ ", approval_status=" + approval_status + "]";
	}



	
		
}