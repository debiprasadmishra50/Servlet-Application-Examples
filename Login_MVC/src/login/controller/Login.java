package login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.db.Users;
import login.model.UsersDao;


/**
 * Servlet implementation class Register
 */
@WebServlet("/login.controller.Login")
public class Login extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		Users u = new Users();
		u.setEmail(request.getParameter("email"));
		u.setPassword(request.getParameter("password"));
		
		boolean result = UsersDao.doValidate(u);
		if(result == true)
		{
			HttpSession session = request.getSession();
			session.setAttribute("email", u.getEmail());
			response.sendRedirect("welcome.jsp");
		}
		else
			response.sendRedirect("login.jsp?msg=Please re-enter details correctly");
	}

}
