package cryptocap;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

@WebServlet(name="HelloServlet", value = "/hello") 
public class HelloServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plan");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println("Hello App working!\r\n");
        
        Webscraping w;
        w = new Webscraping("BTC");

        Criptomoneda c = new Criptomoneda(w.Binance("BTC"));
        response.getWriter().println(c.toString());
    }
}