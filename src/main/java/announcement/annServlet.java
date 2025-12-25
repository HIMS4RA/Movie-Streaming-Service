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



@WebServlet("/annServlet")
public class annServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
       
        // Fetch announcement details
        List<Announcement> annDetails = announceDBUtil.getAnnouncements();

        if (annDetails != null && !annDetails.isEmpty()) {
            request.setAttribute("annDetails", annDetails);
            RequestDispatcher ann = request.getRequestDispatcher("announcedash.jsp");
            ann.forward(request, response);
        } else {
            out.println("<script type='text/javascript'>");
            out.println("alert('No announcement data found');");
            out.println("location='unsuccess.jsp';");
            out.println("</script>");
        }
    }
}