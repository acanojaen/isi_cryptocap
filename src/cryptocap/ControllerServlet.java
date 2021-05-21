package cryptocap;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServlet;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CriptomonedaDAO criptomonedaDAO;

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
                case "/coinranking":
                	coinranking(request, response);              
                break;
                
                case "/investing":
                	investing(request, response);              
                break;
                
                case "/list":
            		list(request, response);
                break;

                case "/ficha":
            		list(request, response);
                break;
                
                case "/eliminar":
                	delete(request, response);
                break;
                
                case "/test":
                	test(request, response);
                break;
                
                case "/config":
                	config(request, response);
                break;
                
                case "/currency":
                	insertCurrency(request, response);
                break;
            }
        } catch (SQLException | URISyntaxException | ClassNotFoundException e){
            throw new ServletException(e);
        }
    }
    
    private void insertCurrency(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
    	String acron = request.getParameter("acr");
    	    	
    	criptomonedaDAO.addCurrency(acron);
		response.sendRedirect("config");
    }

	private void setDAO(CriptomonedaDAO c) {
		this.criptomonedaDAO = c;
	}
	
    private void config(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
    	List<Criptomoneda> list = new ArrayList<>();
		
    	list = criptomonedaDAO.queryconfig();

		request.setAttribute("criptos", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("config.jsp");
		
		dispatcher.forward(request, response);
    }

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Criptomoneda> list = new ArrayList<>();
		try {
			list = criptomonedaDAO.list();
		} catch (SQLException e) {
			throw new ServletException("No se han podido recuperar las criptomonedas", e);
		}

		request.setAttribute("criptos", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		
		dispatcher.forward(request, response);
	}
	
    private void ficha(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
        String acron= request.getParameter("acronimo");
        Criptomoneda crip= criptomonedaDAO.getCriptomoneda(acron);

        request.setAttribute("criptos", crip);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ficha.jsp");
        
        dispatcher.forward(request, response);
    }

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String acron = request.getParameter("id");
		String entity = request.getParameter("entity");
		Criptomoneda crip = new Criptomoneda(acron);
		
		if(entity.equals("criptomoneda")) {
			criptomonedaDAO.remove(crip, entity);
			response.sendRedirect("list");
		} else if(entity.equals("currency")) {
			criptomonedaDAO.remove(crip, entity);
			response.sendRedirect("config");
		}
		
	}
	

	

    private void coinranking(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException, URISyntaxException, ClassNotFoundException, ServletException {
        List<Criptomoneda> criptos = new ArrayList<>();
        criptos = criptomonedaDAO.coinranking();
        
		request.setAttribute("criptos", criptos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		
		dispatcher.forward(request, response);
    }

    private void investing(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException, URISyntaxException, ClassNotFoundException, ServletException {
        List<Criptomoneda> criptos = new ArrayList<>();
        criptos = criptomonedaDAO.investing();
        
		request.setAttribute("criptos", criptos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		
		dispatcher.forward(request, response);
    }
    
    private void test(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException, URISyntaxException, ClassNotFoundException, ServletException {
        List<Criptomoneda> criptos = new ArrayList<>();
        criptos = criptomonedaDAO.investing();
        
        for(int i=0;i<criptos.size();i++) {
        	response.getWriter().println(criptos.get(i).toString());
        }
    }
    
}