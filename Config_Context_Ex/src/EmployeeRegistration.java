

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

public class EmployeeRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeRegistration() {
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
		
		int empid = Integer.parseInt(request.getParameter("empid"));
		String ename = request.getParameter("ename");
		double salary = Double.parseDouble(request.getParameter("salary"));
		
		out.print("<br><hr>Roll : "+empid);
		out.print("<br><hr>Name : "+ename);
		out.print("<br><hr>Cgpa : "+salary);
		
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
			String sql = "insert into Employee values (?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, empid);
			pst.setString(2, ename);
			pst.setDouble(3, salary);
			
			int status = pst.executeUpdate();
			if(status > 0)
				out.println("<h1>Employee Records inserted Successfully</h1>");
			else
				out.println("<h1>Error insertion in Employee Registration</h1>");
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

//In SQL
// 	conn system/sipusipu18
// 	Create table Student
// 	(
// 		roll Number(4),
// 		name varchar2(20),
// 		cgpa Number(3,1)
// 	);
// 	conn system/sipusipu18
// 	Create user bbsr identified by smartcity;
// 	grant dba to bbsr;
// 	conn bbsr/smartcity
// 	Create table Employee
// 	(
// 		empid Number(4),
// 		ename varchar(20),
// 		salary Number(7,1)
// 	);
 
