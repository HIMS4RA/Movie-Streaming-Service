package flix.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	private static String url = "jdbc:mysql://localhost:3306/flix";
	private static String username = "root";
	private static String password = "toyhobby#2003";
	private static Connection con;
	
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			
			
		}
		catch(Exception e) {
			System.out.println("DataBase Connection is not Success");
		}
		
		return con;
		
		
	}
	
	
//
//    String dburl = "jdbc:mysql://localhost:3306/flix";
//    String user = "root";
//    String pass = "Brunomars1.0";
//    
//    try {
//        Class.forName("com.mysql.cj.jdbc.Driver");
	

}
