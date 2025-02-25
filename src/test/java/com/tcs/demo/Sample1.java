package com.tcs.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sample1 {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306","root","shyamala");
				
				Statement statement = conn.createStatement();
				String query="select avg(employeesalary) from world.employee;";
				ResultSet rs = statement.executeQuery(query);
				
				while(rs.next()) {
					String avgsal = rs.getString("avg(employeesalary)");
					System.out.println("Average of employee salary is: "+ avgsal);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
