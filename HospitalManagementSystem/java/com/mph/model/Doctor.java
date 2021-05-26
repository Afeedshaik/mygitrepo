package com.mph.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity(name = "HMSDOCTOR")

@NamedQueries
(
    {
        @NamedQuery(name="GET_DOC_BYID", query="from HMSDOCTOR e where e.did = :id")
        
    }
)
public class Doctor {
	
	@Id
	private int did;
	
	private String dname;
	
	
	
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	private List<Patient> patient;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(int did, String dname, List<Patient> patient) {
		super();
		this.did = did;
		this.dname = dname;
		
		this.patient = patient;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Doctor [did=" + did + ", dname=" + dname + ", patient=" + patient + "]";
	}
		
			

}
