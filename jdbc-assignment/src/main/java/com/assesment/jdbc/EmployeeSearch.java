package com.assesment.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeSearch {
	
	public static void main(String[] args) throws SQLException{
		
		 try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/testdb";
			String userName = "postgres";
			String password = "Jaita@1234";
			
			Connection con = DriverManager.getConnection(url, userName, password);
			
			if(con != null) {
				System.out.println("Successfully connected");
			}
			else {
				System.out.println("Connection refused");
			}
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("Select * from Employee2 ");
			
			PreparedStatement ps = con.prepareStatement("Select * from Employee2 where emp_designation = ? and emp_dept = ?");
			
			System.out.println("These are the employee details -----");
			
			while(rs.next()) {
				System.out.println();
				System.out.println("EMP_NO: "+rs.getString("emp_no"));
				System.out.println("EMP_Name: "+rs.getString("emp_name"));
				System.out.println("EMP_SALARY: "+rs.getString("emp_salary"));
				System.out.println("EMP_DESIGNATION: "+rs.getString("emp_designation"));
				System.out.println("EMP_DEPARTMENT: "+rs.getString("emp_dept"));
				System.out.println();
			}
			

				Scanner sc = new Scanner(System.in);
				System.out.println("Enter Employee's Designation You Want To Look For: ");
				String dg=sc.next();
				
				try {
					ps.setString(1, dg);
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Enter Employee's Department You Want To Look For: ");
				String dp=sc1.next();
				
				try {
					ps.setString(2, dp);
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				ResultSet rs1 = ps.executeQuery();
				
				while(rs1.next()) {
					System.out.println();
					System.out.println("EMP_NO: "+rs1.getString("emp_no"));
					System.out.println("EMP_Name: "+rs1.getString("emp_name"));
					System.out.println("EMP_SALARY: "+rs1.getString("emp_salary"));
					System.out.println("EMP_DESIGNATION: "+rs1.getString("emp_designation"));
					System.out.println("EMP_DEPARTMENT: "+rs1.getString("emp_dept"));
					System.out.println();
				}
		 
	}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//		 finally {
//			 con.close();
//			 System.out.println("Connection closed");
//		 }
}

	private static String IgnoreCase(String dg) {
		// TODO Auto-generated method stub
		return null;
	}
}
			
			
			
			
			
			
