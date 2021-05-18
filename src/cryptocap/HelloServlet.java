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
        response.setContentType("text/plain");
        String nombre = "BTC";
        //Webscraping w;
        Criptomoneda c;
        c = new Criptomoneda(nombre);
        //w = new Webscraping("BTC");
        //w.Binance("BTC");
        
        response.getWriter().println(c.getAcronimo());
    }

}