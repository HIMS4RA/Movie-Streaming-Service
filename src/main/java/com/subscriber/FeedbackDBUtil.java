package com.subscriber;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDBUtil {
	private static boolean isSuccess;
	private static Connection con=null;
	private static Statement stmt=null;
	private static ResultSet rs=null;
	
 public static List<Feedback> validate (String email){
	 
	 ArrayList<Feedback> fback= new ArrayList<>();
	 
	
	 try {
		 
		 con=DBConnect.getConnection();
		 stmt=con.createStatement();
		 String sql = "select * from feedback where Email='"+email+"'"; 
		 rs=stmt.executeQuery(sql);
		 
		 if(rs.next()) {
			 int FID=rs.getInt(1);
			 String Name=rs.getString(2);
			 String Email=rs.getString(3);
			 String MobileNo=rs.getNString(4);
			 String Subject=rs.getNString(5);
			 String Message=rs.getNString(6);
			 
			 Feedback f=new Feedback(FID, Name, Email, MobileNo, Subject, Message);
			 fback.add(f);
			 
		 }
		 
	 }
	 catch(Exception e){
		 e.printStackTrace();
	 }
	 return fback; 
 }
 
 public static boolean insertfeedback(String Name,String Email,String MobileNo,String Subject,String Message) {
	 
	 
	 
	 boolean isSuccess=false;
	 

	 
	 try {
		   con=DBConnect.getConnection();
		   stmt=con.createStatement();
		   String sql="insert into feedback values (0,'"+Name+"', '"+Email+"','"+MobileNo+"','"+Subject+"','"+Message+"')";
		   int rs = stmt.executeUpdate(sql);
		   
		   
		   if(rs>0) {
			   
			   isSuccess= true; 
		   }
		   
		   else {
			   isSuccess=false;
		   }
	 }
	 
	 catch(Exception e) {
		 
		e.printStackTrace();
		System.out.println("Error");
		 
	 }
	 
	 return isSuccess;	
	 
 }
 
 public static boolean updatefeedback(String FID,String Name,String Email, String MobileNo, String Subject, String Message) {
	 boolean isSuccess=false;
	 
	 try(Connection con=DBConnect.getConnection();
		   PreparedStatement pstmt=con.prepareStatement("update feedback set Name=?, Email=?, MobileNo=?, Subject=?, Message=? where FID=?")){
		   
		 pstmt.setString(1, Name);
		 pstmt.setString(2, Email);
		 pstmt.setString(3, MobileNo);
		 pstmt.setString(4, Subject);
		 pstmt.setString(5, Message);
		 pstmt.setString(6, FID);
		 
		 int rowsAffected = pstmt.executeUpdate();
		   
           isSuccess= (rowsAffected>0); 
	     }catch(Exception e) {
		 e.printStackTrace();
		 
	 }
	 return isSuccess;
	 
 }
 public static List<Feedback> getLastInsertedFeedback(){
	 List<Feedback> fback= new ArrayList<>();
	 try {
		 con=DBConnect.getConnection();
		   stmt=con.createStatement();
		   String sql="select * from feedback order by FID DESC LIMIT 1";
		   rs=stmt.executeQuery(sql);
		   
		   while(rs.next()) {
			   int FID=rs.getInt(1);
			   String Name=rs.getString(2);
			   String Email=rs.getString(3);
			   String MobileNo=rs.getString(4);
			   String Subject=rs.getString(5);
			   String Message=rs.getString(6);
			   
			   Feedback f=new Feedback(FID,Name,Email,MobileNo,Subject,Message);
			   fback.add(f);
			      
		   }
		 
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 
	 return fback;
 }
 

  public static List<Feedback> getFeedbackDetails(String fid){
	  int convertedId=Integer.parseInt(fid);
	  
	  ArrayList<Feedback> fback= new ArrayList<>();
	  try {
	       con=DBConnect.getConnection();
		   stmt=con.createStatement();
		   String sql="select * from feedback where FID='"+convertedId+"'";
		   rs=stmt.executeQuery(sql);
		   
		   while(rs.next()) {
			   int FID=rs.getInt(1);
			   String Name=rs.getString(2);
			   String Email=rs.getString(3);
			   String MobileNo=rs.getString(4);
			   String Subject=rs.getString(5);
			   String Message=rs.getString(6);
			   
			   Feedback f=new Feedback(FID,Name,Email,MobileNo,Subject,Message);
			   fback.add(f);
			      
		   }
	  }
	 catch(Exception e) {
		  e.printStackTrace();
	  }finally {
       try {
    	   if(rs !=null)rs.close();
    	   if(stmt !=null)stmt.close();
    	   if(con !=null)con.close();
       }catch(SQLException e) {
    	   e.printStackTrace();
       }
	  }
	  return fback;
  }
  
  public static boolean deletefeedback(String FID) {
	  
	  //boolean isSuccess=false;
	  boolean isSuccess=false;
		 
		 try(Connection con=DBConnect.getConnection();
			   PreparedStatement pstmt=con.prepareStatement("delete from feedback where FID=?")){
			   
			 
			 pstmt.setString(1, FID);
			 
			 int rowsAffected = pstmt.executeUpdate();
			   
	           isSuccess= (rowsAffected>0); 
		     }catch(Exception e) {
			 e.printStackTrace();
			 
		 }
		 return isSuccess;
  }
  public static List<Feedback> getFeedbacks(){
	  List<Feedback> fback = new ArrayList<>();
	  
	  try( Connection con=DBConnect.getConnection();
		   PreparedStatement pstmt=con.prepareStatement("select * from feedback")){
		   
		  rs=pstmt.executeQuery();
	  
	  while(rs.next())  {
		  int FID = rs.getInt("FID");
          String Name = rs.getString("Name");
          String Email = rs.getString("Email");
          String MobileNo = rs.getString("MobileNo");
          String Subject = rs.getString("Subject");
          String Message = rs.getString("Message");
          
          Feedback f= new Feedback(FID,Name,Email,MobileNo,Subject,Message);
		  fback.add(f);
	  } 
  }catch(Exception e) {
	  e.printStackTrace();
  }finally {
      
      if (rs != null) {
          try {
              rs.close();
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
  }
  
  return fback;
}
  public static List<Feedback> getLatestFeedbacks(int limit) {
      List<Feedback> fback = new ArrayList<>();

      try (Connection con = DBConnect.getConnection();
           PreparedStatement pstmt = con.prepareStatement("SELECT * FROM feedback ORDER BY FID DESC LIMIT ?")) {
           
          pstmt.setInt(1, limit); // Set the limit to 4
          rs = pstmt.executeQuery();

          while (rs.next()) {
              int FID = rs.getInt("FID");
              String Name = rs.getString("Name");
              String Email = rs.getString("Email");
              String MobileNo = rs.getString("MobileNo");
              String Subject = rs.getString("Subject");
              String Message = rs.getString("Message");

              Feedback f = new Feedback(FID, Name, Email, MobileNo, Subject, Message);
              fback.add(f);
          }
      } catch (Exception e) {
          e.printStackTrace();
      }

      return fback;
  }

	}



 
  

