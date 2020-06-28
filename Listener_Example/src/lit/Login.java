package lit;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Demo
 */
@WebServlet("/lit.Login")
public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		out.print("<br><hr>Username : "+username);
		out.print("<br><hr>Password : "+password);
		
		if (username.equals(password)) 
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("lit.Welcome");
		}
		else
			out.print("<br>Login Fails");
	}
}
