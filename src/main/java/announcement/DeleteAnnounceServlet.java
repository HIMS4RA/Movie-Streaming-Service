package announcement;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/DeleteAnnounceServlet")
public class DeleteAnnounceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Retrieve parameters from the request
	    String id = request.getParameter("id");

	    boolean isDeleted = false;

	    // Call the method to delete the announcement in the database
	    try {
	        isDeleted = announceDBUtil.deleteannounce(id); // Use the delete method
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception
	        request.setAttribute("errorMessage", "An error occurred while deleting the announcement.");
	        RequestDispatcher dis = request.getRequestDispatcher("Unsuccess.jsp");
	        dis.forward(request, response);
	        return; // Exit the method after forwarding
	    }

	    // If the deletion was successful, fetch updated announcements and forward to announcement dashboard
	    if (isDeleted) {
	        List<Announcement> annDetails = announceDBUtil.getAnnouncements();
	        request.setAttribute("annDetails", annDetails);
	        
	        response.sendRedirect(request.getContextPath() + "/Admin/Announcement/display");
	    //    RequestDispatcher ann = request.getRequestDispatcher("/Admin/Announcement/display");
	    //    ann.forward(request, response);
	    } else {
	        // In case of unsuccessful deletion, forward to an error page
	        List<Announcement> annDetails = announceDBUtil.getAnnouncements();
	        request.setAttribute("annDetails", annDetails);
	        RequestDispatcher dis = request.getRequestDispatcher("Unsuccess.jsp");
	        dis.forward(request, response);
	    }
	}

	

}
