package com.mph.controller;
import com.mph.dao.EmployeeDao;
import com.mph.model.Employee;
import com.mph.model.Salary;
import com.mph.model.Manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
public class EmployeeController implements EmployeeInterface{
	Employee emp;
	Salary sal;
	Manager m;
	List<Employee> emplist = new ArrayList<Employee>();
	EmployeeDao empdao =new EmployeeDao();
	public List<Employee> addEmployee() {
		emp=new Employee();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter eid");
		int eid=sc.nextInt();
		emp.setEid(eid);
		System.out.println("Enter ename");
		String ename=sc.next();
		emp.setEname(ename);
		sal = new Salary();
		
		System.out.println("Enter basic salary");
		int basic = sc.nextInt();
		sal.setBasic(basic);
		System.out.println("Enter da");
		int da = sc.nextInt();
		sal.setDa(da);
		System.out.println("Enter  hra");
		int hra = sc.nextInt();
		sal.setHra(hra);
		System.out.println("Enter pf");
		int pf = sc.nextInt();
		sal.setPf(pf);
		sal.setGross(basic, da, hra);
		sal.setNet(sal.getGross(), pf);
		emp.setSalary(sal);
		
		//emplist.add(emp);
		empdao.insertEmp(emp);
		System.out.println("Employee"+ eid + "successfully updated");
		return emplist;
	}
	public void viewEmployee(List<Employee> elist) {
		/*Iterator<Employee> i=elist.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}*/
		//elist.forEach(lis->System.out.println(lis));
		empdao.viewEmp();
	
	}
	public void addManager() {
		emp=new Employee();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter eid");
		int eid=sc.nextInt();
		emp.setEid(eid);
		System.out.println("Enter ename");
		String ename=sc.next();
		emp.setEname(ename);
		sal = new Salary();
		
		System.out.println("Enter basic salary");
		int basic = sc.nextInt();
		sal.setBasic(basic);
		System.out.println("Enter da");
		int da = sc.nextInt();
		sal.setDa(da);
		System.out.println("Enter  hra");
		int hra = sc.nextInt();
		sal.setHra(hra);
		System.out.println("Enter pf");
		int pf = sc.nextInt();
		sal.setPf(pf);
		sal.setGross(basic, da, hra);
		sal.setNet(sal.getGross(), pf);
		emp.setSalary(sal);
		m = new Manager();
		System.out.println("Enter the department");
		
		String dept = sc.next();
		m.setDept(dept);
		System.out.println("manager details updated");
	}
	public void viewManager() {
		System.out.println(emp);
		System.out.println(m);
	}
	public void sortEmployee(List<Employee> elist) {
		
			Collections.sort(elist,Employee.nameComparator);
			Iterator i=elist.iterator();
			while(i.hasNext())
			{
				System.out.println(i.next());
			}
			elist.forEach(lis->System.out.println(lis));
			}
	
	
	public void startWithA(List<Employee> elist) {
		
		System.out.println("Names start with A");
		Predicate<Employee> p = emp -> (emp.getEname().toUpperCase().startsWith("A"));
		elist.stream().filter(p)
		.sorted(Comparator.comparing(Employee:: getEname))
		.forEach(System.out::println);
		
		System.out.println("Names start with S");
		Predicate<Employee> p1 = emp1 -> (emp1.getEname().toUpperCase().startsWith("S"));
		elist.stream().filter(p1)
		.sorted(Comparator.comparing(Employee:: getEname))
		.forEach(System.out::println);
		
		System.out.println("Names start with D");
		Predicate<Employee> p2 = emp2 -> (emp2.getEname().toUpperCase().startsWith("D"));
		elist.stream().filter(p2)
		.sorted(Comparator.comparing(Employee:: getEname))
		.forEach(System.out::println);
		
	}
	
	public void serializeData(List<Employee> elist) {
		FileOutputStream fos =null ;
		ObjectOutputStream oos =null;
		try {
			fos= new FileOutputStream("myfile.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(emp);
			
			System.out.println("Data successfully Serialized...");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				fos.close();
				oos.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}
	public void deserializeData(List<Employee> elist) {
		
		try (FileInputStream fis = new FileInputStream("myfile.txt");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			emp =(Employee)ois.readObject();
			fis.close();
			ois.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(emp.getEid());
		System.out.println(emp.getEname());
		System.out.println(emp.getSalary());
		
	}
	
	public void insertUsingProc() {
		Employee e=new Employee();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the eid");
		int eno =sc.nextInt();
		e.setEid(eno);
		System.out.println("Enter the Ename");
		String enam=sc.next();
		e.setEname(enam);
		empdao.insertUsingProcedure(e);
	}
	public void rsmd() {
		empdao.rsmd();
	}
	
	public void type_forward_only_rs() {
		
		empdao.type_forward_only_rs();
	}
	
	public void type_scroll_insensitive_rs() {
	
		empdao.type_scroll_insensitive_rs();
	}
	
	public void type_scroll_sensitive_rs_insert() {
		
		empdao.type_scroll_sensitive_rs_insert();
	}
	@Override
	public void type_scroll_sensitive_rs_update() {
		// TODO Auto-generated method stub
		empdao.type_scroll_sensitive_rs_update();
		
		
	}
	@Override
	public void batchUpdate() {
		// TODO Auto-generated method stub
		empdao.batchUpdate();
		
	}
	

}
