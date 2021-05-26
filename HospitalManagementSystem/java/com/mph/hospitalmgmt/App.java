package com.mph.hospitalmgmt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mph.controller.DoctorController;

import com.mph.model.Doctor;

import com.mph.model.Patient;


public class App 
{
    public static void main( String[] args )
    {
    	
    	

    	DoctorController ec = new DoctorController();
		List<Doctor> dlist = null;
		Scanner sc = new Scanner(System.in);

		String input = null;
		do {
			System.out.println("Enter your Choice");
			System.out.println("1. Add Doctor");
			System.out.println("2. View Doctor");
			System.out.println("3. Update Doctor");
			System.out.println("4. Delete Doctor ");
			System.out.println("5. Select Using Criteria Query");
			System.out.println("6. Select Using Named Query");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				ec.addDoctor();
				break;
			}
			case 2: {
				ec.viewDoctor();
				break;
			}
			case 3: {
				ec.updateDoctor();
				break;
			}
			case 4: {
				ec.deleteDoctor();
				
				break;
			}
			case 5: {
				ec.selectUsingCriteriaQuery();
				break;
			}
			case 6: {
				ec.selectUsingNamedQuery();
				break;
			}

			default: {
				System.out.println("default case");
			}

			}
			System.out.println("Do you want to continue ? Y or y for yes");
			input = sc.next();
		} while (input.equals("Y") || input.equals("y"));
		System.out.println("System Exited..Thanks for using our system !!!");
		
		
		
		
		
		
		
		
		
		
		
    	/*SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	Session session  = sessionFactory.openSession();
    	System.out.println("session : => "+ session);
    	session.beginTransaction();
    	
    	List<Patient> patient = new ArrayList<Patient>();

    	Patient pt = new Patient();
    	pt.setPid(100);
    	pt.setPname("afeed");
    	pt.setAge(25);
    	pt.setAddress("xyz");
    	pt.setDiagnosis("x");
    	pt.setDoctor(new Doctor(25,"rama",patient));
    	Doctor dc = new Doctor();
    	dc.setDid(25);
    	dc.setDname("rama");
    	
    	System.out.println("Pid : " + pt.getPid()+ "    " + "Pname : " + pt.getPname());
    	System.out.println("Did : " + dc.getDid()+ "    " + "Dname : " + dc.getDname());
    	
    	session.save(pt);
    	session.save(dc);
    	session.getTransaction().commit();
    	session.close();
    	*/
    	
    }
}
