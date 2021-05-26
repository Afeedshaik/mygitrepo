package com.hms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue
	public long addressId;

	public String street;

	public String city;

	public int pincode;
	
	@ManyToOne
	@JoinColumn(name = "doctor_id", referencedColumnName = "DOCTOR_ID")
	private Doctor doctor;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(long addressId, String street, String city, int pincode, Doctor doctor) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
		this.doctor = doctor;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", pincode=" + pincode
				+ ", doctor=" + doctor + "]";
	}
	
	
}
