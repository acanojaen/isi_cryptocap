package cryptocap;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

@WebServlet(
	    name = "HelloWorld",
	    urlPatterns = {"/hello"}
	)

public class HelloServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		// Set response content type
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		// Respuesta del servlet
		response.getWriter().println("Hello World! Servlet working");
	}
}

