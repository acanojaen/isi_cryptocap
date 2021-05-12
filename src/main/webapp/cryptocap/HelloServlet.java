package main.webapp.cryptocap;

import java.io.IOException;

import javax.servlet.ServletException;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		// Set response content type
		response.setContentType("text/html");
		// Respuesta del servlet
		response.getWriter().println("Hello World! Servlet working");
	}
}

