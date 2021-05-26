package com.hms.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import springfox.documentation.swagger2.annotations.EnableSwagger2;




/**
 * This is a class in entity layer which holds Doctor information.
 * @author AFEED
 *
 */
@EnableSwagger2
@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int doctor_id;
	
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String specialization;
	@Column	 
	
	private String doctor_dob;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String gender;
	@Column
	private String phone_number;
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
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}





	/**
	 * Constructor generated using fields.
	 * @param doctor_id
	 * @param firstName
	 * @param lastName
	 * @param specialization
	 * @param doctor_dob
	 * @param email
	 * @param password
	 * @param gender
	 * @param phone_number
	 * @param address
	 */
	public Doctor(int doctor_id, String firstName, String lastName, String specialization, String doctor_dob,
			String email, String password, String gender, String phone_number, String address) {
		super();
		this.doctor_id = doctor_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialization = specialization;
		this.doctor_dob = doctor_dob;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.phone_number = phone_number;
		this.address = address;
	}



	/**
	 * getter method for doctor_id.
	 * Fetches the doctor_id value.
	 * @return doctor_id
	 */
	public int getDoctor_id() {
		return doctor_id;
	}

    /**
	 * setter method for doctor_id.
	 * Sets the doctor_id value.
	 * @param doctor_id
	 */
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
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
	 * getter method for specialization.
	 * Fetches the specialization value.
	 * @return specialization
	 */
	public String getSpecialization() {
		return specialization;
	}
    
    /**
	 * setter method for specialization.
	 * Sets the specialization value.
	 * @param specialization
	 */
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

    /**
	 * getter method for doctor_dob.
	 * Fetches the doctor_dob value.
	 * @return doctor_dob
	 */
	public String getDoctor_dob() {
		return doctor_dob;
	}

    /**
	 * setter method for doctor_dob.
	 * Sets the doctor_dob value.
	 * @param doctor_dob
	 */
	public void setDoctor_dob(String doctor_dob) {
		this.doctor_dob = doctor_dob;
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
		return "Doctor [doctor_id=" + doctor_id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", specialization=" + specialization + ", doctor_dob=" + doctor_dob + ", email=" + email
				+ ", password=" + password + ", gender=" + gender + ", phone_number=" + phone_number + ", address="
				+ address + "]";
	}








}
