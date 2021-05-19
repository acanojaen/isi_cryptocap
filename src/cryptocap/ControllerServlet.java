package cryptocap;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CriptomonedaDAO c;

    /**
	 * Inicializar valores de la base de datos
     * están definidos en web.xml
	 */
    public void init() throws ServletException {
        String jdbcURL = "jdbc:mysql://lmc8ixkebgaq22lo.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/fbj6jfrdn8y5rorn";
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        CriptomonedaDAO c = new CriptomonedaDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String elegido = request.getServletPath();

        try {
            switch(elegido){
                case "/cm":
                    main(request, response);
    	    	                    
                break;
                
                default:
                    response.getWriter().println("hola mundo");
                
                break;
            }
        } catch (SQLException e){
            throw new ServletException(e);
        }
    }

    public void main(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        response.setContentType("text/html");
        try {
            ArrayList<Criptomoneda> lista = new ArrayList<Criptomoneda>();
            Criptomoneda cr = new Criptomoneda("BTC");
            lista.add(cr);
            //lista = c.test();
            for(int i=0; i<lista.size();i++){
                response.getWriter().println(lista.get(i).toString());
            }
        } catch (Throwable theException){
            response.getWriter().println("ERROR:" + theException); 
        }
    
    }
}