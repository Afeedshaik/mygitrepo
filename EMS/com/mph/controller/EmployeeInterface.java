package com.mph.controller;

import java.util.List;

import com.mph.model.Employee;

public interface EmployeeInterface {
	public List<Employee> addEmployee();
	public void viewEmployee(List<Employee> elist);
	public void addManager();
	public void viewManager();
	public void sortEmployee(List<Employee> elist);
	public void startWithA(List<Employee> elist);
	public void serializeData(List<Employee> elist);
	public void deserializeData(List<Employee> elist);
	public void insertUsingProc();
	public void rsmd();
	public void type_forward_only_rs();
	public void type_scroll_insensitive_rs();
	public void type_scroll_sensitive_rs_insert();
	public void type_scroll_sensitive_rs_update();
	public void batchUpdate();
	


}
