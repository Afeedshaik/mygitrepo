package com.mph.view;
import com.mph.model.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;

import com.mph.controller.EmployeeController;
import com.mph.controller.EmployeeInterface;
import com.mph.exception.UserNotFoundException;

public class MainClass {
	
	public static void main(String [] args) throws IOException {
		EmployeeInterface ec=new EmployeeController();
		List<Employee> elist=null;
		Scanner sc=new Scanner(System.in);
		String input=null;
		try{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String un,pw;
			System.out.println("Enter UserName");
			un=br.readLine();
			System.out.println("Enter Pasword");
			pw =br.readLine();
			BiPredicate<String, String> pred = (un1,pw1)->un1.equals("afeed")&&pw1.equals("pass");
			//System.out.println(pred.test(un,pw));
			if(pred.test(un,pw))
			{
				
				System.out.println("Welcome " +  un + "  !!!" );
				try{
					System.out.println("Please wait.....");
					Thread.sleep(2000);
				}
				catch(InterruptedException ie){
					ie.printStackTrace();
				}
				
			
				do {
					System.out.println("Enter your Choice");
					System.out.println("1.Add employee");
					System.out.println("2.View employee");
					System.out.println("3.Add manager");
					System.out.println("4.view manager");
					System.out.println("5.sort employee");
					System.out.println("6.starting with A");
					System.out.println("7.serialize the data");
					System.out.println("8.deserialize the data");
					System.out.println("9.Procedure insert");
					System.out.println("10. Get ResultSet MetaData Info");
					System.out.println("11.RS Forward only");
					System.out.println("12.RS scroll insensitive");
					System.out.println("13.RS scroll sensitive ");
					System.out.println("14.RS Update");
					System.out.println("15.Batch Update");
					int choice=sc.nextInt();
					switch(choice) {
					case 1:{
						elist = ec.addEmployee();
						break;
					}
					case 2:{
						ec.viewEmployee(elist);
						break;
					}
					case 3:{
						ec.addManager();
						break;
					}
					case 4:{
						ec.viewManager();
						break;
					}
					case 5:{
						ec.sortEmployee(elist);
						break;
					}
					case 6:{
						ec.startWithA(elist);
						break;
					}
					case 7:{
						ec.serializeData(elist);
						break;
					}
					case 8:{
						ec.deserializeData(elist);
						break;
					}
					case 9:{
						ec.insertUsingProc();
						break;
					}
					case 10:{
						ec.rsmd();
						break;
					}
					case 11:{
						ec.type_forward_only_rs();
						break;
					}
					case 12:{
						ec.type_scroll_insensitive_rs();
						break;
					}
					case 13:{
						ec.type_scroll_sensitive_rs_insert();
						break;
					}
					case 14:{
						ec.type_scroll_sensitive_rs_update();
						break;
					}
					case 15:{
						ec.batchUpdate();
						break;
					}
					default:{
					}
					}
					System.out.println("Do you want to continue enter Y or y");
					input=sc.next();
				}while(input.equals("Y")|| input.equals("y"));
				System.out.println("System exited thanks for using ");
				System.exit(0);
			}
			else
			{
				throw new UserNotFoundException();
			}

			
			}
			
			catch(UserNotFoundException unfe)
			{
				System.out.println(unfe);
				
			}		
			catch(Exception e)
			{
				System.out.println("Exception Raised");
				e.printStackTrace();
			}

}
}
