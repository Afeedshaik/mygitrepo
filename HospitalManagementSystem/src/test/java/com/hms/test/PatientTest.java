package com.hms.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hms.dao.DoctorDao;
import com.hms.dao.DoctorDaoImpl;
import com.hms.dao.PatientDao;
import com.hms.dao.PatientDaoImpl;
import com.hms.entity.Doctor;
import com.hms.entity.Patient;

public class PatientTest {
	static PatientDao patientDao;
	static DoctorDao doctorDao;
	@BeforeClass
	public static void setup() {
		ApplicationContext context = new ClassPathXmlApplicationContext("patient-test.xml");
		patientDao = (PatientDaoImpl)context.getBean("patientDao");
		doctorDao=(DoctorDaoImpl)context.getBean("doctorDao");
	}
	@Test
	public void getPatientList() {
		List<Patient> patients = patientDao.getPatientList();
		assertTrue((patientDao.getPatientList()).size() >= 1);
	}
	@Test
	public void getDoctorList() {
		List<Doctor> doctors = doctorDao.getDoctorList();
		assertTrue((doctorDao.getDoctorList()).size() >= 1);
	}


}