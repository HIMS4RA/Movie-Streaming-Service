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
@WebServlet("/InsertServlet")

public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("in do post method of add image servlet");
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String genre = request.getParameter("genre");
		String date = request.getParameter("releaseDate");
		Part imagePart = request.getPart("coverImage");
        Part videoPart = request.getPart("movieVideo");
        
        boolean isTrue;
        
        isTrue = MovieDBUtil.insertMovie(title, description, genre, date, imagePart, videoPart);
        
        if(isTrue == true)
		{ 
        	response.sendRedirect(request.getContextPath() + "/Admin/Movies/adminreadMovies");
		}
        else
		{
			RequestDispatcher dis = request.getRequestDispatcher("Unsuccess.jsp");
			dis.forward(request, response);
		}
        
        
		
		
	}

}
