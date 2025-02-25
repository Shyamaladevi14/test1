package com.tcs.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sample {
	
	public static void main(String[] args) {
		db_conn();
	}
	
	public static void db_conn() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306","root","shyamala");
				
				Statement statement = conn.createStatement();
				String query="select * from world.customers;";
				ResultSet rs = statement.executeQuery(query);
				
				while(rs.next()) {
					int id = rs.getInt("id");
					String cusname = rs.getString("cusname");
					String city = rs.getString("city");
					String state = rs.getString("state");
					String country = rs.getString("country");
					
					System.out.println("id: "+ id + ", customer name: "+ cusname +", city: "+ city +
							", state: "+ state +", country: "+country);
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
