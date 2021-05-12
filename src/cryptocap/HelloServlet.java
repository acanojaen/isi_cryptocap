package cryptocap;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*; 

public class HelloServlet extends HttpServlet
{

	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Set response content type
		response.setContentType("text/html");
		// Respuesta del servlet
		PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1>");
	}
}

