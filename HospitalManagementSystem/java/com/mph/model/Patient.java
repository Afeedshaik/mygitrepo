package com.mph.model;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "patient")

public class Patient {
	@Id
	private int pid;
	private String pname;
	private String address;
	private String diagnosis;
	private int age;
	
	@ManyToOne
	@JoinColumn(name="did",referencedColumnName = "DID")
	private Doctor doctor;

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(int pid, String pname, String address, String diagnosis, int age, Doctor doctor) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.address = address;
		this.diagnosis = diagnosis;
		this.age = age;
		this.doctor = doctor;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", pname=" + pname + ", address=" + address + ", diagnosis=" + diagnosis
				+ ", age=" + age + ", doctor=" + doctor + "]";
	}
	
	
	
}
	
	
	