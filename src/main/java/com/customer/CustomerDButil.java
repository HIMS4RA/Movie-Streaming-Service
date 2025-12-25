package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import announcement.Announcement;
import announcement.DBConnection;

public class CustomerDButil {
	
	private static boolean isTrue = false;
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	public static boolean validate(String userName, String password) {
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from customer where username='"+userName+"'AND password='"+password+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
			
		}catch(	Exception e) {
			e.printStackTrace();
		}
		
			
		return isSuccess;
	}
	
	
	public static List<Customer> getCustomer(String userName){
		
		ArrayList<Customer> customer = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from customer where username= '"+userName+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
			    String phone = rs.getString(4);
			    String username = rs.getString(5);
			    String password = rs.getString(6);
			    
			    Customer cus = new Customer(id,name,email,phone,username,password);
			    customer.add(cus);
			}
			
			
		}catch(Exception e) {
			
		}
		return customer;
	}
	
	
	
	
	
	
	
	
	
	public static boolean insertcustomer(String name, String email, String phone, String username, String password) {
		
		
		
		try {
		
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into customer values (0, '"+name+"', '"+email+"', '"+phone+"', '"+username+"', '"+password+"' )";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static boolean updatecustomer(String id, String name, String email, String phone, String userName, String password) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "update customer set name='"+name+"',email ='"+email+"',phone='"+phone+"',username= '"+userName+"',password= '"+password+"'"
			+ "where id = '"+id+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	public static List<Customer> getCustomerDetails(String Id){
		
		int convertedID = Integer.parseInt(Id);
		
		ArrayList<Customer> cus = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from customer where id='"+convertedID+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String userName = rs.getString(5);
				String password = rs.getString(6);
				
				Customer c = new Customer(id,name,email,phone,userName,password);
				cus.add(c);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return cus;
	}
	
	public static boolean deleteCustomer(String id)
	{

	    
	    try {
	    	
	    	con = DBConnect.getConnection();
			stmt = con.createStatement();
	    	String sql = "Delete from customer where id='"+id+"'";
	    	int rs = stmt.executeUpdate(sql);
	    	
	    	 
	    	 
	    	 if(rs > 0)
	    	 {
	    		 isTrue = true;
	    	 }else
	    	 {
	    		 isTrue = false;
	    	 }
	    	
	    	
	    	
	    }catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
		
		
		
		return isTrue;
	}
	
	
	public static List<Customer> getCustomerD() {

	    List<Customer> customers = new ArrayList<>();

	    try {
	        con = DBConnection.getConnection();
	        stmt = con.createStatement();
	        
	        //SQL query to fetch all announcements
	        String sql = "SELECT * FROM customer"; 
	        rs = stmt.executeQuery(sql);

	      
	        while (rs.next()) {
	        	int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
			    String phone = rs.getString(4);
			    String username = rs.getString(5);
			    String password = rs.getString(6);

	          
	            Customer customer = new Customer(id,name,email,phone,username,password);
	            customers.add(customer); 
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return customers;
	}
	
	public static List<Customer> getAllCustomers(){
        List<Customer> customers = new ArrayList<>();

        

        try {
        	 con = DBConnection.getConnection();
             stmt = con.createStatement();
             
             // SQL query to fetch all announcements
             String sql = "SELECT * FROM announcement"; 
             rs = stmt.executeQuery(sql);

            // Iterate through the result set and create Customer objects
            while (rs.next()) {
            	int id = rs.getInt(1); // Fetch the announcement id
                String name = rs.getString(2);
                String email = rs.getString(3);
                String phone = rs.getString(4);
                String userName = rs.getString(5);
                String password = rs.getString(6);
                

                // Create a new Customer object and add it to the list
                Customer customer = new Customer(id, name, email, phone, userName, password);
                customers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Ensure resources are closed to prevent memory leaks
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return customers; // Return the list of customers
    }

	public static int getCustomerCount() {
	    int count = 0;
	    Connection con = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    
	    try {
	        con = DBConnection.getConnection();
	        String sql = "SELECT COUNT(*) AS count FROM customer"; // Assuming 'customer' is your table name
	        stmt = con.prepareStatement(sql);
	        rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            count = rs.getInt("count"); // Get the count value
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Close resources
	        try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
	        try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
	        try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
	    }
	    return count; // Return the count
	}
	
}