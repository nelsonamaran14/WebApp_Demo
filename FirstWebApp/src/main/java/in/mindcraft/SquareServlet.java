package in.mindcraft;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/square")
public class SquareServlet extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		//int c=(int)request.getAttribute("c");
		//int c=Integer.parseInt(request.getParameter("c"));
		
		int c=0;
		Cookie[]  cookies=request.getCookies();
		for(Cookie ck:cookies)
		{
			if(ck.getName().equals("c")) {
				c=Integer.parseInt(ck.getValue());
			}
		}
		
		int square=c*c;
	
		HttpSession session=request.getSession();
		session.setAttribute("square", square);
		response.sendRedirect("result.jsp");
		
		//int c = (int)session.getAttribute("c");
		
		
	
		
		response.getWriter().println("Square of addition - "+square);
		
		
	}

}
