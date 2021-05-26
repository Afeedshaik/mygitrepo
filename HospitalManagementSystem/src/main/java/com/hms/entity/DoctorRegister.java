package com.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DoctorRegister {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int doctor_id;
	
	@Column
	private String username;
	@Column
	private String email;
	@Column
	private String password;
	public DoctorRegister() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DoctorRegister(int doctor_id, String username, String email, String password) {
		super();
		this.doctor_id = doctor_id;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
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
		return "DoctorRegister [doctor_id=" + doctor_id + ", username=" + username + ", email=" + email + ", password="
				+ password + "]";
	}
	
	

}
