package com.contactus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDBUtill {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	
	public static boolean insertmessage(String firstName, String lastName, String email, String phone, String subject, String message) {
		
		boolean isSuccess = false;
		
	
			try {
				
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				
				
				
				String sql = "insert into contactForms values (0,'"+firstName+"','"+lastName+"','"+email+"','"+phone+"','"+subject+"','"+message+"')";
				int rs = stmt.executeUpdate(sql);	
				
				
				if(rs>0) {
					
					isSuccess = true;
				}
				else {
					
					isSuccess = false;
				}
				
				
				
			}
			
			catch(Exception e){
				
				e.printStackTrace();
			}
			
		
		
		return isSuccess;
		
	
	}
	

    public static List<Customer> getCustomerDetails(String Id) {
    	
    	int convertedID = Integer.parseInt(Id);
    	
    	ArrayList<Customer> cus = new ArrayList<>();
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "select * from contactForms where id='"+convertedID+"'";
    		rs = stmt.executeQuery(sql);
    		
    		while(rs.next()) {
    			int id = rs.getInt(1);
    			String firstName = rs.getString(2);
    			String lastName = rs.getString(3);
    			String email = rs.getString(4);
    			String phone = rs.getString(5);
    			String subject = rs.getString(6);
    			String message = rs.getString(7);
    			
    			Customer c = new Customer(id,firstName,lastName, email,phone,subject,message);
    			cus.add(c);
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}	
    	return cus;	
    }
	
	
	public static List<Customer> getLastInsertedMessage(){
		 List<Customer> CusMsg= new ArrayList<>();
		 try {
			 con=DBConnect.getConnection();
			   stmt=con.createStatement();
			   String sql="select * from contactForms order by id DESC LIMIT 1";
			   rs=stmt.executeQuery(sql);
			   
			   while(rs.next()) {
				   int id=rs.getInt(1);
				   String firstName=rs.getString(2);
				   String lastName=rs.getString(3);
				   String email=rs.getString(4);
				   String phone=rs.getString(5);
				   String subject=rs.getString(6);
				   String message=rs.getString(7);
				   
				   Customer c = new Customer(id,firstName,lastName,email,phone,subject,message);
				   CusMsg.add(c);
				      
			   }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 return CusMsg;
	 }
	
	
	
		public static boolean updatemessage(String id, String firstName, String lastName, String email, String phone, String subject, String message) {
	
	
		
			 
			 try(Connection con=DBConnect.getConnection();
				   PreparedStatement pstmt=con.prepareStatement("update contactForms set firstName=?,lastName=? , email=?, phone=?, subject=?, message=? where id=?")){
				   
				 pstmt.setString(1, firstName);
				 pstmt.setString(2, lastName);
				 pstmt.setString(3, email);
				 pstmt.setString(4, phone);
				 pstmt.setString(5, subject);
				 pstmt.setString(6, message);
				 pstmt.setString(7, id);
				 
				 int rowsAffected = pstmt.executeUpdate();
				   
		           isSuccess= (rowsAffected>0); 
			     }catch(Exception e) {
				 e.printStackTrace();
				 
			 }
			 return isSuccess;
			 

		}


		public static boolean deleteMessage(String id) {
	        boolean isSuccess = false;

	        try {
	            // Establish connection
	            con = DBConnect.getConnection();
	            stmt = con.createStatement();

	            // SQL query to delete a contact message where the id matches
	            String sql = "DELETE FROM contactForms WHERE id = '" + id + "'";

	            // Execute the delete query
	            int rs = stmt.executeUpdate(sql);

	            // If the query affected at least one row, it was successful
	            if (rs > 0) {
	                isSuccess = true;
	            } else {
	                isSuccess = false;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close the database connection
	            try {
	                if (stmt != null) {
	                    stmt.close();
	                }
	                if (con != null) {
	                    con.close();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	        return isSuccess;
	    }
		
		public static List<Customer> getMessages(){
			  List<Customer> msg = new ArrayList<>();
			  
			  try( Connection con=DBConnect.getConnection();
				   PreparedStatement pstmt=con.prepareStatement("select * from contactForms")){
				   
				  rs=pstmt.executeQuery();
			  
			  while(rs.next())  {
				  int id = rs.getInt("id");
		          String firstName = rs.getString("firstName");
		          String lastName = rs.getString("lastName");
		          String email = rs.getString("email");
		          String phone = rs.getString("phone");
		          String subject = rs.getString("subject");
		          String message = rs.getString("message");
		          
		          Customer c = new Customer(id,firstName,lastName,email,phone,subject,message);
				  msg.add(c);
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
		  
		  return msg;
		}
		
		public static boolean admindelete(String FID) {
			  
			  //boolean isSuccess=false;
			  boolean isSuccess=false;
				 
				 try(Connection con=DBConnect.getConnection();
					   PreparedStatement pstmt=con.prepareStatement("delete from contactForms where id =?")){
					   
					 
					 pstmt.setString(1, FID);
					 
					 int rowsAffected = pstmt.executeUpdate();
					   
			           isSuccess= (rowsAffected>0); 
				     }catch(Exception e) {
					 e.printStackTrace();
					 
				 }
				 return isSuccess;
		  }
		
		
}
	

	

