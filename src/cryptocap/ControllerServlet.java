package cryptocap;

import java.io.IOException;
import java.sql.SQLException;

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
    public void init() {
        String jdbcURL = "jdbc:mysql://lmc8ixkebgaq22lo.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/fbj6jfrdn8y5rorn";
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        setCore(new CriptomonedaDAO(jdbcURL, jdbcUsername, jdbcPassword));
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
                case "/coinmarket":
                    main(request, response);
                
                break;
                
                default:
                    main(request, response);
                
                break;
            }
        } catch (SQLException e){
            throw new ServletException(e);
        }
    }

    public void main(HttpServletRequest request, HttpServletResponse response){
        CriptomonedaDAO.test();
    }

    public void setCore(CriptomonedaDAO c){
        this.c = c;
    }
}