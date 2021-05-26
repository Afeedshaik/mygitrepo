package com.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * This is a class in entity layer which holds Patient information.
 * @author AFEED
 *
 */
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int admin_id;
	
	@Column
	private String username;
	@Column
	private String password;
	
	/**
	 * 	Constructor generated from superclass.
	 * 	With super(), the superclass no-argument constructor is called.If a constructor does not
	 *  explicitly invoke a superclass constructor, the Java compiler automatically inserts a call
	 *  to the no-argument constructor of the superclass. If the super class does not have a 
	 *  no-argument constructor, you will get a compile-time error. 
	 *  
	 */
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor generated using fields.
	 * @param admin_id
	 * @param username
	 * @param password
	 */
	public Admin(int admin_id, String username, String password) {
		super();
		this.admin_id = admin_id;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * getter method for admin_id.
	 * Fetches the admin_id value.
	 * @return admin_id
	 */
	public int getAdmin_id() {
		return admin_id;
	}
	
	/**
	 * setter method for admin_id.
	 * Sets the admin_id value.
	 * @param admin_id
	 */
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	
	/**
	 * getter method for username.
	 * Fetches the username value.
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * setter method for username.
	 * Sets the username value.
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
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
		return "Admin [admin_id=" + admin_id + ", username=" + username + ", password=" + password + "]";
	}
	

}