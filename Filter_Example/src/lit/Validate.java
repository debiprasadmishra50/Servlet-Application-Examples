package lit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Validate
 */
@WebFilter("/lit.Test")
public class Validate implements Filter {

    /**
     * Default constructor. 
     */
    public Validate() 
    {
        // TODO Auto-generated constructor stub
    	System.out.println("Object Created for Filter");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Destroy : Filter");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		System.out.println("doFilter : Filter");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String roll = request.getParameter("roll");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		if (roll.length() == 0) 
			out.print("<h1>Roll Cannot be empty");
		else if (name.length() == 0) 
			out.print("<h1>name Cannot be empty");
		else if (age.length() == 0)
			out.print("<h1>Please Enter a age, It cannot be blank");
		else if (Integer.parseInt(age) <= 0) 
			out.print("<h1>age Cannot be less than 0");
		else
		{	
			out.print("<h3>");
			chain.doFilter(request, response);
			out.print("</h3");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init : Filter");
	}

}
