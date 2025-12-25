package flix.db;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class homeMovieRead
 */
@WebServlet("/homeMovieRead")
public class homeMovieRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  try {
	            
	        	System.out.println("In do post method Display image Servlet");
	        	String id = request.getParameter("id");
	        	
	            Movie movieDetails = MovieDBUtil.getSpecificMovieDetails(id);
	            
	            System.out.println("Fetched movie details:");
	          
	            request.setAttribute("movieDetails", movieDetails);
	            
	          
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	       
	        RequestDispatcher dis = request.getRequestDispatcher("MoviePage.jsp");
	        dis.forward(request, response);
	    }
	

}
