package com.tcs.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBExecution {
	
	public static void main(String[] args) {
		
		ResultSet rs1 = Reusuable.read_db(Queries.query);
		
		try {
			while(rs1.next()) {
				String empname = rs1.getString("employeename");
				System.out.println("Employee Name: "+empname);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
