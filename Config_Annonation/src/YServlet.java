

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class YServlet
 */
@WebServlet(
		urlPatterns = { "/y" }, 
		initParams = { 
				@WebInitParam(name = "city", value = "Puri"), 
				@WebInitParam(name = "landmark", value = "Jagannath Temple")
		})
public class YServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YServlet() {
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
		
		ServletConfig config = getServletConfig();
		ServletContext context = getServletContext();
		
		out.println("<br> City : "+config.getInitParameter("city"));
		out.println("<br> landmark : "+config.getInitParameter("landmark"));
		
		out.println("<br> State : "+context.getInitParameter("State"));
		out.println("<br> Country : "+context.getInitParameter("Country"));
	}

}
