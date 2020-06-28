

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String roll = request.getParameter("roll");
		String name = request.getParameter("name");
		String cgpa = request.getParameter("cgpa");
		
		out.print("<br><hr>Roll : "+roll);
		out.print("<br><hr>Name : "+name);
		out.print("<br><hr>Cgpa : "+cgpa);
		
		out.print("<form action='Demo'>");
		out.println("<input type='hidden' name='roll' value="+roll+">");
		out.println("<input type='hidden' name='name' value="+name+">");
		out.println("<input type='hidden' name='cgpa' value="+cgpa+">");
		
		out.println("<br>Branch : <input type='text' name='branch'>");
		out.println("<br>College : <input type='text' name='college'>");
		out.println("<br><input type='submit' value='SUBMIT'>");
		
		out.print("</form>");
		
		
	}
}
