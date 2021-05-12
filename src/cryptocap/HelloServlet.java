package cryptocap;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

@WebServlet(
	    name = "HelloServlet",
	    urlPatterns = {"/hello"}
	)

public class HelloServlet extends HttpServlet
{

	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Set response content type
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		// Respuesta del servlet
		response.getWriter().println("Hello World! Servlet working");
	}
}

