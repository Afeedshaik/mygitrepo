package com.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PatientRegister {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patient_id;
	
	@Column
	private String username;
	@Column
	private String email;
	@Column
	private String password;
	public PatientRegister() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientRegister(int patient_id, String username, String email, String password) {
		super();
		this.patient_id = patient_id;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "PatientRegister [patient_id=" + patient_id + ", username=" + username + ", email=" + email
				+ ", password=" + password + "]";
	}

}
