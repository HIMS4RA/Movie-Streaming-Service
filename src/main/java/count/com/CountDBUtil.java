package count.com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class CountDBUtil {
	
	private static boolean isTrue = false;
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static  int getMovieCount() {
        
		int count = 0;
		
		try
		{
		con = DBConnect.getConnection();
         stmt = con.createStatement();
         System.out.println("Connection success");
         
         String sql = "SELECT COUNT(*) AS count FROM media;";
         
     
         rs = stmt.executeQuery(sql);
         
         
         if(rs.next())
         {
        	 count = rs.getInt("count");
         }
         
         
         
         
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return count;
		
		
    }
	
public static  int getUserCount() {
        
		int count = 0;
		
		try
		{
		con = DBConnect.getConnection();
         stmt = con.createStatement();
         System.out.println("Connection success");
         
         String sql = "SELECT COUNT(*) AS count FROM customer;";
         
     
         rs = stmt.executeQuery(sql);
         
         
         if(rs.next())
         {
        	 count = rs.getInt("count");
         }
         
         
         
         
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return count;
		
		
    }

public static  int getAncCount() {
    
	int count = 0;
	
	try
	{
	con = DBConnect.getConnection();
     stmt = con.createStatement();
     System.out.println("Connection success");
     
     String sql = "SELECT COUNT(*) AS count FROM announcement;";
     
 
     rs = stmt.executeQuery(sql);
     
     
     if(rs.next())
     {
    	 count = rs.getInt("count");
     }
     
     
     
     
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return count;
	
	
}

public static  int getFeedbackCount() {
    
	int count = 0;
	
	try
	{
	con = DBConnect.getConnection();
     stmt = con.createStatement();
     System.out.println("Connection success");
     
     String sql = "SELECT COUNT(*) AS count FROM feedback;";
     
 
     rs = stmt.executeQuery(sql);
     
     
     if(rs.next())
     {
    	 count = rs.getInt("count");
     }
     
     
     
     
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return count;
	
	
}

public static  int getContactbackCount() {
    
	int count = 0;
	
	try
	{
	con = DBConnect.getConnection();
     stmt = con.createStatement();
     System.out.println("Connection success");
     
     String sql = "SELECT COUNT(*) AS count FROM contactForms;";
     
 
     rs = stmt.executeQuery(sql);
     
     
     if(rs.next())
     {
    	 count = rs.getInt("count");
     }
     
     
     
     
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return count;
	
	
}



}
