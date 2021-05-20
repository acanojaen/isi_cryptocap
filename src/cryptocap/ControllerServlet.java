package cryptocap;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CriptomonedaDAO c;

    /**

	 */
    public void init() throws ServletException {
        String jdbcURL = "jdbc:mysql://lmc8ixkebgaq22lo.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/fbj6jfrdn8y5rorn";
		String jdbcUsername = "go4wfmmyetu3gkvm";
		String jdbcPassword = "e7pnet4zo6qcfwy8";

        setDAO(new CriptomonedaDAO(jdbcURL, jdbcUsername, jdbcPassword));
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
            	
            	case "/test":
            		listString(request, response);
            	break;
            	
                case "/cm":
                    main(request, response);              
                break;
                
                case "/list":
            		list(request, response);
                break;
                
                default:
            		response.sendRedirect("list");
                break;
            }
        } catch (SQLException | URISyntaxException | ClassNotFoundException e){
            throw new ServletException(e);
        }
    }
    
    private void setDAO(CriptomonedaDAO c) {
		this.c = c;
	}
	

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Criptomoneda> list = new ArrayList<>();
		try {
			list = c.list();
		} catch (SQLException e) {
			throw new ServletException("No se han podido recuperar las criptomonedas", e);
		}
		
		request.setAttribute("criptos", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		
		dispatcher.forward(request, response);
	}
	
	private void listString(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Criptomoneda> list = new ArrayList<>();
		try {
			list = c.list();
		} catch (SQLException e) {
			throw new ServletException("No se han podido recuperar las criptomonedas", e);
		}
		
		for(int i=0;i<list.size();i++) {
			response.getWriter().println(list.get(i).toString());
		}
		
	}

    private void main(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException, URISyntaxException, ClassNotFoundException {
        response.setContentType("text/html");
        List<Criptomoneda> lista = new ArrayList<>();
        //Criptomoneda cr = new Criptomoneda("BTC");
        //lista.add(cr);
        lista = c.test();
        
        for(int i=0; i<lista.size();i++){
            response.getWriter().println(lista.get(i).toString());
        }
    
    }
}