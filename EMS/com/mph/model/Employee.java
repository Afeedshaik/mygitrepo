package com.mph.model;

import java.io.Serializable;
import java.util.Comparator;

public class Employee implements Comparable<Employee>,Serializable {
	int eid;
	String ename;
	private Salary salary;
	public Employee() {
		System.out.println("from emp constr....");
	}
	public void setEid(int eid) {
		this.eid=eid;
	}
	
	public int getEid() {
		return eid;
	}
	public void setEname(String ename) {
		this.ename=ename;
		
	}
	public String  getEname() {
		return ename;
		
	}
	public Salary getSalary() {
		return salary;
	}
	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + "]";
	}
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public static Comparator<Employee> nameComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {
			// TODO Auto-generated method stub
			return (e1.getEname().compareTo(e2.getEname()));
		}

		
		
	};
	
	
}
