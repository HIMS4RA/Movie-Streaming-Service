package flix.db;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import com.customer.DBConnect;

public class MovieDBUtil {
	private static boolean isTrue = false;
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static boolean insertMovie(String title, String description, String genre, String date, Part imagePart, Part videoPart) {
	    
	    // For image
	    String imageFileName = imagePart.getSubmittedFileName();
	    System.out.println("Selected image file name: " + imageFileName);
	    
	    // For video
	    String videoFileName = videoPart.getSubmittedFileName();
	    System.out.println("Selected video file name: " + videoFileName);
	    
	    // Upload paths
	    String ImguploadPath = "C:/Projects/MovieFlix/src/main/webapp/Admin/Movies/media/" + imageFileName;
	    String ViduploadPath = "C:/Projects/MovieFlix/src/main/webapp/Admin/Movies/media/" + videoFileName;
	    
	    System.out.println("Image Upload Path: " + ImguploadPath);
	    System.out.println("Video Upload Path: " + ViduploadPath);
	    
	    // Save image file
	    try {
	        FileOutputStream fos = new FileOutputStream(ImguploadPath);
	        InputStream is = imagePart.getInputStream();
	        
	        byte[] data = new byte[is.available()];
	        is.read(data);
	        fos.write(data);
	        fos.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    // Save video file
	    try {
	        FileOutputStream fos = new FileOutputStream(ViduploadPath);
	        InputStream is = videoPart.getInputStream();
	        
	        byte[] data = new byte[is.available()];
	        is.read(data);
	        fos.write(data);
	        fos.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    boolean isSuccess = false;
	    
	   
	    
	    try {
	    	con = DBConnect.getConnection();
			stmt = con.createStatement();	        
	        // Use placeholders for parameters in the SQL query
	        String sql = "INSERT INTO media (id, title, description, genre, ReleaseDate,imageFileName, videoFileName) VALUES (0, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement stmt = con.prepareStatement(sql);
	        
	        // Set the parameters
	        stmt.setString(1, title);
	        stmt.setString(2, description);
	        stmt.setString(3, genre);
	        stmt.setString(4, date);
	        stmt.setString(5, imageFileName);
	        stmt.setString(6, videoFileName);
	        
	        // Execute the update without passing the SQL string again
	        int rs = stmt.executeUpdate();
	        
	        if (rs > 0) {
	            System.out.println("Image and video added to database successfully");
	            isSuccess = true;
	        } else {
	            System.out.println("Failed to upload image and video");
	            isSuccess = false;
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return isSuccess;
	}

	
	
	public static List<Movie> getMovieDetails() {
	    ArrayList<Movie> movies = new ArrayList<>();
	    
//	    String dburl = "jdbc:mysql://localhost:3306/flix";
//	    String user = "root";
//	    String pass = "Brunomars1.0";
	    
	    try {
	        // Load MySQL JDBC Driver
//	        Class.forName("com.mysql.cj.jdbc.Driver");
//	        System.out.println("Driver loaded successfully.");
	    	
	    	con = DBConnect.getConnection();
			stmt = con.createStatement();	
	        
	        // Establish a connection to the database
	    //    Connection con = DriverManager.getConnection(dburl, user, pass);
	        System.out.println("Database connection established.");
	        
	        Statement stmt = con.createStatement();
	        
	        // SQL query to fetch all movie details
	        String sql = "SELECT id, title, description, genre, ReleaseDate, imageFileName, videoFileName FROM media";
	        System.out.println("Executing query: " + sql);
	        
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        // Iterate through the result set
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String title = rs.getString("title");
	            String description = rs.getString("description");
	            String genre = rs.getString("genre");
	            String date = rs.getString("ReleaseDate");
	            String imageFileName = rs.getString("imageFileName");
	            String videoFileName = rs.getString("videoFileName");
	            
	            // Create the Movie object with the fetched data
	            Movie movie = new Movie(id, title, description, genre, date, imageFileName, videoFileName);
	            movies.add(movie);
	            
	            System.out.println("Added movie: " + title);
	        }
	        
	        rs.close();
	        stmt.close();
	        con.close();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error fetching movie details.");
	    }
	    
	    return movies;
	}
	
	public static boolean updateMovie(String id, String title, String description, String genre, String date, Part imagePart, Part videoPart, String retainImage, String retainVideo) {
		
		 String[] currentFiles = getCurrentFileNames(id);
		 String currentImageFile = currentFiles[0];
		 String currentVideoFile = currentFiles[1];

	    System.out.println("Starting updateMovie method");

	    String imageFileName = null;
	    String videoFileName = null;

	    // Process image upload
	    if (retainImage == null && imagePart != null && imagePart.getSize() > 0) {
	        imageFileName = imagePart.getSubmittedFileName();
	        System.out.println("New image file uploaded: " + imageFileName);
	        String ImguploadPath = "C:/Projects/MovieFlix/src/main/webapp/Admin/Movies/media/" + imageFileName;
	        try (FileOutputStream fos = new FileOutputStream(ImguploadPath); InputStream is = imagePart.getInputStream()) {
	            byte[] data = new byte[is.available()];
	            is.read(data);
	            fos.write(data);
	            System.out.println("Image uploaded successfully to: " + ImguploadPath);
	        } catch (Exception e) {
	            System.out.println("Error while uploading image file: " + e.getMessage());
	            e.printStackTrace();
	        }
	    } else {
	        imageFileName = currentImageFile; 
	        System.out.println("Retaining the current image: " + imageFileName);
	    }

	    // Process video upload
	    if (retainVideo == null && videoPart != null && videoPart.getSize() > 0) {
	        videoFileName = videoPart.getSubmittedFileName();
	        System.out.println("New video file uploaded: " + videoFileName);
	        String ViduploadPath = "C:/Projects/MovieFlix/src/main/webapp/Admin/Movies/media/" + videoFileName;
	        try (FileOutputStream fos = new FileOutputStream(ViduploadPath); InputStream is = videoPart.getInputStream()) {
	            byte[] data = new byte[is.available()];
	            is.read(data);
	            fos.write(data);
	            System.out.println("Video uploaded successfully to: " + ViduploadPath);
	        } catch (Exception e) {
	            System.out.println("Error while uploading video file: " + e.getMessage());
	            e.printStackTrace();
	        }
	    } else {
	        videoFileName = currentVideoFile;
	        System.out.println("Retaining the current video: " + videoFileName);
	    }

	    boolean isSuccess = false;
	    try {
	    	con = DBConnect.getConnection();
			stmt = con.createStatement();	
	        System.out.println("Database connection established successfully.");

	        String sql = "UPDATE media SET Title=?, Description=?, Genre=?, ReleaseDate=?, imageFileName=?, videoFileName=? WHERE id=?";
	        PreparedStatement stmt = con.prepareStatement(sql);

	        stmt.setString(1, title);
	        stmt.setString(2, description);
	        stmt.setString(3, genre);
	        stmt.setString(4, date);
	        stmt.setString(5, imageFileName);
	        stmt.setString(6, videoFileName);
	        stmt.setString(7, id);

	        System.out.println("Executing the SQL update statement...");
	        int rs = stmt.executeUpdate();

	        if (rs > 0) {
	            System.out.println("Movie updated successfully.");
	            isSuccess = true;
	        } else {
	            System.out.println("Failed to update movie in the database.");
	            isSuccess = false;
	        }

	    } catch (SQLException e) {
	        System.out.println("SQL Exception occurred: " + e.getMessage());
	        e.printStackTrace();
	    } catch (Exception e) {
	        System.out.println("General Exception occurred: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        // Attempt to delete temporary files
	        if (imagePart != null) {
	            try {
	                imagePart.delete();
	                System.out.println("Temporary image file deleted.");
	            } catch (IOException e) {
	                System.out.println("Error deleting temporary image file: " + e.getMessage());
	            }
	        }
	        if (videoPart != null) {
	            try {
	                videoPart.delete();
	                System.out.println("Temporary video file deleted.");
	            } catch (IOException e) {
	                System.out.println("Error deleting temporary video file: " + e.getMessage());
	            }
	        }
	    }

	    System.out.println("Exiting updateMovie method.");
	    return isSuccess;
	}
	
	private static String[] getCurrentFileNames(String id) {
	    String[] fileNames = new String[2]; // [0] = imageFileName, [1] = videoFileName
	    try {
	    	con = DBConnect.getConnection();
			stmt = con.createStatement();	
	        String sql = "SELECT imageFileName, videoFileName FROM media WHERE id=?";
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setString(1, id);

	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            fileNames[0] = rs.getString("imageFileName");
	            fileNames[1] = rs.getString("videoFileName");
	        }
	    } catch (SQLException e) {
	        System.out.println("SQL Exception occurred while retrieving current file names: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return fileNames;
	}

	
	
	public static boolean deleteMovie(String id)
	{
		boolean isTrue = false;
		
		
	    
	    try {
	    	con = DBConnect.getConnection();
			stmt = con.createStatement();	
	    	
	    	
	    	
	    	
	    	String sql = "Delete from media where id='"+id+"'";
	    	
	    	PreparedStatement stmt = con.prepareStatement(sql);
	    	
	    	 int rs = stmt.executeUpdate();
	    	 
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

	public static Movie getSpecificMovieDetails(String id) {
	    Movie movie = null; // Use a single Movie object instead of a list
	  

	    try {
	        // Load MySQL JDBC Driver
	    	con = DBConnect.getConnection();
			stmt = con.createStatement();	
	        System.out.println("Database connection established.");

	        // Use a prepared statement to fetch the specific movie
	        String sql = "SELECT id, title, description, genre, ReleaseDate, imageFileName, videoFileName FROM media WHERE id = ?";
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, id); // Set the ID parameter

	        System.out.println("Executing query: " + pstmt);
	        ResultSet rs = pstmt.executeQuery();

	        // Check if a movie was found
	        if (rs.next()) {
	            int movieId = rs.getInt("id");
	            String title = rs.getString("title");
	            String description = rs.getString("description");
	            String genre = rs.getString("genre");
	            String date = rs.getString("ReleaseDate");
	            String imageFileName = rs.getString("imageFileName");
	            String videoFileName = rs.getString("videoFileName");

	            // Create the Movie object with the fetched data
	            movie = new Movie(movieId, title, description, genre, date, imageFileName, videoFileName);
	            System.out.println("Fetched movie: " + title);
	        } else {
	            System.out.println("No movie found with ID: " + id);
	        }

	        rs.close();
	        pstmt.close();
	        con.close();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error fetching movie details.");
	    }

	    return movie; // Return the single Movie object
	}


}
