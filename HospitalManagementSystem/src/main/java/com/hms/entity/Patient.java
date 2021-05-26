package com.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import springfox.documentation.swagger2.annotations.EnableSwagger2;



/**
 * This is a class in entity layer which holds Patient information.
 * @author AFEED
 *
 */
@EnableSwagger2
@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patient_id;
	
	@Column
	private String firstName;
	@Column
	private String lastName;
	
	@Column
	private String gender;
	@Column
	private String diagnosis;
	@Column
	private int patient_age;
	@Column
	private String phone_number;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String address;
	
	
	
	/**
	 * 	Constructor generated from superclass.
	 * 	With super(), the superclass no-argument constructor is called.If a constructor does not
	 *  explicitly invoke a superclass constructor, the Java compiler automatically inserts a call
	 *  to the no-argument constructor of the superclass. If the super class does not have a 
	 *  no-argument constructor, you will get a compile-time error. 
	 *  
	 */
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
	
    /**
	 * Constructor generated using fields.
	 * @param patient_id
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param diagnosis
	 * @param patient_age
	 * @param phone_number
	 * @param email
	 * @param password
	 * @param address
	 * 
	 */


	public Patient(int patient_id, String firstName, String lastName, String gender, String diagnosis, int patient_age,
			String phone_number, String email, String password, String address) {
		super();
		this.patient_id = patient_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.diagnosis = diagnosis;
		this.patient_age = patient_age;
		this.phone_number = phone_number;
		this.email = email;
		this.password = password;
		this.address = address;
	}





	 /**
		 * getter method for patient_id.
		 * Fetches the patient_id value.
		 * @return patient_id
		 */

	public int getPatient_id() {
		return patient_id;
	}

	/**
	 * setter method for patient_id.
	 * Sets the patient_id value.
	 * @param patient_id
	 */
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
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
	 * getter method for diagnosis.
	 * Fetches the diagnosis value.
	 * @return diagnosis
	 */

	public String getDiagnosis() {
		return diagnosis;
	}

	
	/**
	 * setter method for diagnosis.
	 * Sets the diagnosis value.
	 * @param diagnosis
	 */
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	
	
	/**
	 * getter method for patient_age.
	 * Fetches the patient_age value.
	 * @return patient_age
	 */
	public int getPatient_age() {
		return patient_age;
	}

	/**
	 * setter method for patient_age.
	 * Sets the patient_age value.
	 * @param patient_age
	 */
	public void setPatient_age(int patient_age) {
		this.patient_age = patient_age;
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
	 * getter method for password.
	 * Fetches the password value.
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
    
    /**
	 * setter method for password.
	 * Sets the password value.
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

    /**
	 * The toString() method returns the string representation of the object(s).
	 * @return String 
	 */
	@Override
	public String toString() {
		return "Patient [patient_id=" + patient_id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", diagnosis=" + diagnosis + ", patient_age=" + patient_age + ", phone_number="
				+ phone_number + ", email=" + email + ", password=" + password + ", address=" + address + "]";
	}

	
	
}
