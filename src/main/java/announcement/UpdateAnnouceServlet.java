package announcement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateAnnouceServlet")
public class UpdateAnnouceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Retrieve parameters from the request
	    String id = request.getParameter("id");
	    String date = request.getParameter("date");
	    String category = request.getParameter("category");
	    String title = request.getParameter("title");
	    String content = request.getParameter("content");
	    
	    boolean isUpdated = false;

	    // Call the method to update the announcement in the database
	    try {
	        isUpdated = announceDBUtil.updateannounce(id, date, category, title, content);
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception
	        request.setAttribute("errorMessage", "An error occurred while updating the announcement.");
	        RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
	        dis.forward(request, response);
	        return; // Exit the method after forwarding
	    }

	    // If the update was successful, fetch updated announcements and forward to update page
	    if (isUpdated) {
	        List<Announcement> annDetails = announceDBUtil.getAnnouncements();
	        request.setAttribute("annDetails", annDetails);
	      //  RequestDispatcher ann = request.getRequestDispatcher("announcedash.jsp");
	      //  ann.forward(request, response);
	        response.sendRedirect(request.getContextPath() + "/Admin/Announcement/display");
	    } else {
	        // In case of unsuccessful update, forward to an error page
	        List<Announcement> annDetails = announceDBUtil.getAnnouncements();
	        request.setAttribute("annDetails", annDetails);
	        RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
	        dis.forward(request, response);
	    }
	}

}
