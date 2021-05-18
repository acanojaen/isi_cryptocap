package cryptocap;

import java.io.IOException;
import com.google.gson.Gson;
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
        response.setContentType("application/json");
        Webscraping w;
        Criptomoneda c;
        w = new Webscraping("BTC");
        c = new Criptomoneda(w.Binance("BTC"));
        Gson gson = new Gson();
        String json = gson.toJson(c);

        response.getWriter().println(json);
    }

}