package announcement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class announceDBUtil {
	
	private static boolean isTrue = false;
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	


	public static boolean insertannounce(String date,String category, String title, String content) {
	    boolean isSuccess = false;

	    try {
	        con = DBConnection.getConnection();
	        stmt = con.createStatement();

	        String sql = "INSERT INTO announcement (id,date, category, title, content) " +
	                     "VALUES (0,CURRENT_TIMESTAMP, '" + category + "', '" + title + "', '" + content + "')";
	        
	        int rs = stmt.executeUpdate(sql);
	        isSuccess = (rs > 0);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (stmt != null) stmt.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return isSuccess;
	}
public static List<Announcement> getAnnounceDetails(String Id){
	
		int convertedID = Integer.parseInt(Id);
		
		ArrayList<Announcement> ann = new ArrayList<>();
		
		try {
			
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			String sql = "select * from announcement where id='"+convertedID+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String date = rs.getString(2);
				String category = rs.getString(3);
			    String title = rs.getString(4);
			    String content = rs.getString(5);
			    
			    Announcement a = new Announcement(id,date,category,title,content);
			    ann.add(a);
			}
			
			
		}catch(Exception e) {
			
		}
		return ann;
	}

public static List<Announcement> getAnnouncements() {

    List<Announcement> announcements = new ArrayList<>();

    try {
        con = DBConnection.getConnection();
        stmt = con.createStatement();
        
        // SQL query to fetch all announcements
        String sql = "SELECT * FROM announcement"; 
        rs = stmt.executeQuery(sql);

        // Loop through the result set to get all rows
        while (rs.next()) {
            int id = rs.getInt(1); // Fetch the announcement id
            String date = rs.getString(2);
            String category = rs.getString(3);
            String title = rs.getString(4);
            String content = rs.getString(5);

            // Create an Announcement object using the fetched details
            Announcement announcement = new Announcement(id, date, category, title, content);
            announcements.add(announcement); // Add each announcement to the list
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

    return announcements; // Return the list containing all announcements
}


public static boolean updateannounce(String id, String date, String category, String title, String content) {
    boolean isSuccess = false; // Declare the variable to store success status

    // Use try-with-resources to automatically close resources
    try (Connection con = DBConnection.getConnection();
         PreparedStatement pstmt = con.prepareStatement("UPDATE announcement SET date=?, category=?, title=?, content=? WHERE id=?")) {

        // Set parameters for the prepared statement
        pstmt.setString(1, date);
        pstmt.setString(2, category);
        pstmt.setString(3, title);
        pstmt.setString(4, content);
        pstmt.setString(5, id);

        // Execute the update
        int rowsAffected = pstmt.executeUpdate();

        // Check if the update was successful
        isSuccess = (rowsAffected > 0);
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return isSuccess; // Return the success status
}




			public static boolean validate(int id) {
				try {
					con = DBConnection.getConnection();
					stmt = con.createStatement();
					String sql = "select * from announcement where id='"+id+"'";
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
			
			public static boolean deleteannounce(String id) {
			    boolean isSuccess = false; // Declare the variable to store success status

			    // Use try-with-resources to automatically close resources
			    try (Connection con = DBConnection.getConnection();
			         PreparedStatement pstmt = con.prepareStatement("DELETE FROM announcement WHERE id = ?")) {

			        // Set the parameter for the prepared statement
			        pstmt.setString(1, id);

			        // Execute the delete
			        int rowsAffected = pstmt.executeUpdate();

			        // Check if the deletion was successful
			        isSuccess = (rowsAffected > 0);
			    } catch (Exception e) {
			        e.printStackTrace();
			    }

			    return isSuccess; // Return the success status
			}
			
			public static List<Announcement> getLastAnnouncements() {
			    List<Announcement> announcements = new ArrayList<>();

			    try {
			        con = DBConnection.getConnection();
			        stmt = con.createStatement();
			        
			        // SQL query to fetch the last 4 announcements
			        String sql = "SELECT * FROM announcement ORDER BY id DESC LIMIT 4"; 
			        rs = stmt.executeQuery(sql);

			        // Loop through the result set to get the last 4 rows
			        while (rs.next()) {
			            int id = rs.getInt(1); // Fetch the announcement id
			            String date = rs.getString(2);
			            String category = rs.getString(3);
			            String title = rs.getString(4);
			            String content = rs.getString(5);

			            // Create an Announcement object using the fetched details
			            Announcement announcement = new Announcement(id, date, category, title, content);
			            announcements.add(announcement); // Add each announcement to the list
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

			    return announcements; // Return the list containing the last 4 announcements
			}
}