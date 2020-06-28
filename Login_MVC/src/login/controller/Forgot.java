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
import login.service.UsersService;


/**
 * Servlet implementation class Register
 */
@WebServlet("/login.controller.Forgot")
public class Forgot extends HttpServlet 
{
//	Logout request is a hyperlink, so it will return get method
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		Users u = new Users();
		u.setEmail(request.getParameter("email"));
		
		String password = UsersDao.getPassword(u);
		if(password != null)
		{
			u.setPassword(password);
			UsersService.sendPassword(u);
		}
		else
			response.sendRedirect("forgot.jsp?msg=invalid email....:(");
	}

}
