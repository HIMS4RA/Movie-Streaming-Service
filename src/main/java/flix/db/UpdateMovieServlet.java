package flix.db;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/UpdateMovieServlet")
public class UpdateMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String id = request.getParameter("id");
	        String title = request.getParameter("title");
	        String description = request.getParameter("description");
	        String genre = request.getParameter("genre");
	        String releaseDate = request.getParameter("releaseDate");

	        // Get file parts for image and video
	        Part imagePart = request.getPart("coverImage");
	        Part videoPart = request.getPart("movieVideo");

	        // Parameters to check if the user wants to retain the current files
	        String retainImage = request.getParameter("retainImage");
	        String retainVideo = request.getParameter("retainVideo");

	        // Pass all these details to the MovieDBUtil for updating
	        boolean isTrue = MovieDBUtil.updateMovie(id, title, description, genre, releaseDate, imagePart, videoPart, retainImage, retainVideo);

	        // Forward to success or failure page based on the result
	        if (isTrue) {
	            // Movie update successful
	        	response.sendRedirect(request.getContextPath() + "/Admin/Movies/adminreadMovies");
	        } else {
	            // Movie update failed
	            RequestDispatcher dis = request.getRequestDispatcher("Unsuccess.jsp");
	            dis.forward(request, response);
	        }

}
}
