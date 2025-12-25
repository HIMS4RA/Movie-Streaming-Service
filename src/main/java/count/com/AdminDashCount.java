package count.com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AdminDashCount")
public class AdminDashCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try
		{
		
		int movieCount = CountDBUtil.getMovieCount();
		int userCount = CountDBUtil.getUserCount();
		int ancCount = CountDBUtil.getAncCount();
		int feedCount = CountDBUtil.getFeedbackCount();
		int inqCount = CountDBUtil.getContactbackCount();
		
		
		request.setAttribute("inqCount", inqCount); 
		request.setAttribute("feedCount", feedCount); 
		request.setAttribute("userCount", userCount); 
		request.setAttribute("movieCount", movieCount); 
		 request.setAttribute("ancCount", ancCount); 
         RequestDispatcher dis = request.getRequestDispatcher("Admin/AdminDash.jsp");
         dis.forward(request, response);
				
				
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	
}
