package com.tcs.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Reusuable {

	public static Connection db_conn() {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "shyamala");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}
	
	public static ResultSet read_db(String query1) {
		
		ResultSet rs=null;
		
		try {
			Statement statement=db_conn().createStatement();
			rs = statement.executeQuery(query1);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
}
