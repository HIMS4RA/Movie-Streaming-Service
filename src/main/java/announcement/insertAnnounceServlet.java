package announcement;

import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet("/insertAnnounceServlet")
public class insertAnnounceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String date = request.getParameter("date");
		String category = request.getParameter("category");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		boolean isTrue;
		
		isTrue = announceDBUtil.insertannounce(date,category, title, content);
		
		if(isTrue == true) {
			
         // Successful insertion
            response.sendRedirect(request.getContextPath() + "/Admin/Announcement/display");
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
	}
	}


