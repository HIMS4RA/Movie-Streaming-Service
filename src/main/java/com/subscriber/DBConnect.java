package com.subscriber;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	private static String url = "jdbc:mysql://localhost:3306/flix";
	private static String userName="root";
	private static String password="toyhobby#2003";
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection(url,userName, password);
			 
		}
		
		catch(Exception e){
			System.out.println("Database coonection is not success");
			
		}
		return con; 
	}

}
