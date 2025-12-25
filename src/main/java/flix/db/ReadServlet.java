package flix.db;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);  // Call the same logic for both GET and POST
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Movie> movieDetails = MovieDBUtil.getMovieDetails();
            request.setAttribute("movieDetails", movieDetails);

            String servletPath = request.getServletPath();

            String targetPage = "";
            if (servletPath.equals("/Admin/Movies/adminreadMovies")) {
                targetPage = "/Admin/Movies/MovieRead.jsp";  // Admin page
            } else if (servletPath.equals("/homereadMovies")) {
                targetPage = "HomePage.jsp";  // Home page
            }

            RequestDispatcher dis = request.getRequestDispatcher(targetPage);
            dis.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
