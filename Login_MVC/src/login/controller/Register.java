package login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.db.Users;
import login.model.UsersDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/login.controller.Register")
public class Register extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		Users u = new Users();
		u.setUsername(request.getParameter("username"));
		u.setEmail(request.getParameter("email"));
		u.setPassword(request.getParameter("password"));
		u.setRegdno(request.getParameter("regdno"));
		u.setPhone(request.getParameter("phone"));
		u.setCollege(request.getParameter("college"));
		
		int status = UsersDao.doRegister(u);
		if (status > 0) 
			response.sendRedirect("register.jsp?msg1=Successfully Registered...:)");
		else
			response.sendRedirect("register.jsp?msg1=Error in Registration...:(");
	}

}
