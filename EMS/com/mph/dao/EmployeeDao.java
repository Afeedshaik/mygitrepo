package com.mph.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.mph.model.Employee;
import com.mph.util.MyDBConnection;

public class EmployeeDao {
	Connection con;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;
	
	public void insertEmp(Employee emp) {
		con = MyDBConnection.getDBConncetion();
		try {
			ps = con.prepareStatement("insert into mphemp(eid,ename) values(?,?)");
			ps.setInt(1, emp.getEid());
			ps.setString(2, emp.getEname());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + "inserted successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void viewEmp() {
		// TODO Auto-generated method stub
		con = MyDBConnection.getDBConncetion();
		
		try {
			
			st =con.createStatement();
			rs =st.executeQuery("Select * from mphemp");
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertUsingProcedure(Employee emp)
	{
		con = MyDBConnection.getDBConncetion();
		try {
			CallableStatement cs = con.prepareCall("{call insertRecord(?,?)}");
			cs.setInt(1, emp.getEid());
			cs.setString(2, emp.getEname());
			cs.execute();
			System.out.println("Procedure successfully Executed and record inserted !!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void rsmd()
	{
		con = MyDBConnection.getDBConncetion();
		HashMap<Long, HashMap<String, Object>> hmap = new HashMap<Long, HashMap<String,Object>>();
		try {
			st = con.createStatement();
			rs =st.executeQuery("select * from mphemp");
			
			ResultSetMetaData md = rs.getMetaData();
			System.out.println(md.getColumnCount());
			while(rs.next())
			{
				HashMap<String, Object> row = new HashMap<String, Object>();
				for(int i=1 ; i<=md.getColumnCount();i++)
				{
					row.put(md.getColumnName(i), rs.getObject(i));
					hmap.put(rs.getLong("eid"), row);
					
				}
			}
			System.out.println(hmap);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void type_forward_only_rs()
	{
		
		con = MyDBConnection.getDBConncetion();
		try {
			ps = con.prepareStatement("select * from mphemp",ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();
			

			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
			}
			System.out.println(rs.getType());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void type_scroll_insensitive_rs()
	{
		con = MyDBConnection.getDBConncetion();
		try {
			ps = con.prepareStatement("select * from mphemp",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();
			

			while (rs.next()) {
				
				System.out.println(rs.getString(2));
			}
			System.out.println(rs.getType());
			
			System.out.println("Move Cursor to Ist position");
			rs.first();
			System.out.println(rs.getString("ename"));
			
			System.out.println("Move Cursor to Last position");
			rs.last();
			System.out.println(rs.getString("ename"));
			
			System.out.println("Move Cursor to previous position");
			rs.previous();
			System.out.println(rs.getString("ename"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void type_scroll_sensitive_rs_insert()
	{
		con = MyDBConnection.getDBConncetion();
		try {
			ps = con.prepareStatement("select eid,ename from mphemp",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();
			
			System.out.println("Before Insert ==>");
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
			}
			
			
			rs.moveToInsertRow();
			rs.updateInt("eid",10);
			rs.updateString("ename", "Ram");
			rs.insertRow();
			
			System.out.println("Inserted ...");
			System.out.println("After Insert ==>");
			
			
			System.out.println(rs.getInt("eid"));
			System.out.println(rs.getString("ename"));
			
			System.out.println(rs.getType());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void type_scroll_sensitive_rs_update()
	{
		con = MyDBConnection.getDBConncetion();
		try {
			ps = con.prepareStatement("select eid,ename from mphemp where eid=166",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();
			
			System.out.println("Before Update ==>");
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				rs.updateInt("eid",99);
				
				rs.updateString("ename", "Rajesh");
				
				rs.updateRow();
			}
			
			
			//rs.moveToInsertRow();
			
			
			System.out.println("Updated ...");
			System.out.println("After Update ==>");
			
			
				//System.out.println(rs.getInt("eid"));
				//System.out.println(rs.getString("ename"));
			
			System.out.println(rs.getType());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void batchUpdate()
	{
		con = MyDBConnection.getDBConncetion();
		
		try {
			st = con.createStatement();
			st.addBatch("update mphemp set ename ='Mohan' where eid=96");
			st.addBatch("update mphemp set eid=13 where ename ='afeed'");
			st.addBatch("update mphemp set ename ='Varun' where eid=77");
			st.addBatch("update mphemp set ename ='Sarikaa' where eid=568");
			st.addBatch("update mphemp set ename ='Rajaa' where eid=99");
			
			int[] count =st.executeBatch();
			for(int i=0;i<count.length ;i++)
			{
				System.out.println(i + "  "+ count [i] + " times. ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
