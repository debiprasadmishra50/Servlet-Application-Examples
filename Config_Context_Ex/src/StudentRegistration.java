

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo
 */

public class StudentRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		int roll = Integer.parseInt(request.getParameter("roll"));
		String name = request.getParameter("name");
		double cgpa = Double.parseDouble(request.getParameter("cgpa"));
		
		out.print("<br><hr>Roll : "+roll);
		out.print("<br><hr>Name : "+name);
		out.print("<br><hr>Cgpa : "+cgpa);
		
		try 
		{
			ServletContext context = getServletContext();
			ServletConfig config = getServletConfig();
			
			String driver = context.getInitParameter("driver");
			String url = context.getInitParameter("url");
			
			String username = config.getInitParameter("username");
			String password = config.getInitParameter("password");
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,username,password);
			String sql = "insert into Student values (?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, roll);
			pst.setString(2, name);
			pst.setDouble(3, cgpa);
			
			int status = pst.executeUpdate();
			if(status > 0)
				out.println("<h1>Student Records inserted Successfully</h1>");
			else
				out.println("<h1>Error insertion in StudentRegistration</h1>");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
