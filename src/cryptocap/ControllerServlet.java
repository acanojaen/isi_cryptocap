package cryptocap;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            	// Webscraping en Coinraking.com
                case "/coinranking":
                	coinranking(request, response);              
                break;
                
                // Webscraping en Investing.com
                case "/investing":
                	investing(request, response);              
                break;
                
                // Página listar
                case "/list":
            		list(request, response);
                break;

                // Ficha criptomoneda
                case "/ficha":
            		ficha(request, response);
                break;
                
                // Eliminar (Criptomoneda/Currency)
                case "/eliminar":
                	delete(request, response);
                break;
                
                // Página de Configuración
                case "/config":
                	config(request, response);
                break;
                
                // Añadir una Moneda (Configuración)
                case "/currency":
                	insertCurrency(request, response);
                break;
                
                // Obtener las currencys
                case "/compare":
                	compare(request, response);
                break;
                
                case "/compare2":
                	compare2(request, response);
                break;
                
                case "/market":
                	market(request, response);
                break;
                
                case "/apiprices":
                	refreshMarket(request, response);
                break;
                	
            }
        } catch (SQLException | URISyntaxException | ClassNotFoundException e){
            throw new ServletException(e);
        }
    }
    
    private void market(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
    	List<Criptomoneda> data = new ArrayList<>();
		
    	data = criptomonedaDAO.listMarket();
    	
		request.setAttribute("criptos", data);
		RequestDispatcher dispatcher = request.getRequestDispatcher("market.jsp");
		
		dispatcher.forward(request, response);
	}
    
    private void refreshMarket(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Criptomoneda> criptos = new ArrayList<>();
        
        criptos = criptomonedaDAO.refreshMarket();
        
		request.setAttribute("criptos", criptos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("market.jsp");
		
		dispatcher.forward(request, response);
    }

	private void compare2(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
    	List<Criptomoneda> data = new ArrayList<>();
    	String[] notcriptos = new String[]{"USD","ALL","DZD"}; 
    	
    	data = criptomonedaDAO.list();
    	String amount = request.getParameter("cantidad");
    	String acron1 = request.getParameter("compIzq");
    	String acron2 = request.getParameter("compDer");
    	
    	if(amount.isEmpty() || acron1.isEmpty() || acron2.isEmpty()) {
        	request.setAttribute("error", "Tienes que rellenar todos los campos");
        	RequestDispatcher dispatcher = request.getRequestDispatcher("compare.jsp");
    			
        	dispatcher.forward(request, response);
    	}
    	
    	Webscraping ws = new Webscraping();
    	
		request.setAttribute("criptos", data);
		request.setAttribute("notcriptos", Arrays.asList(notcriptos));
    	request.setAttribute("result", ws.Conversor(amount, acron1, acron2));
    	request.setAttribute("amount", amount);
    	request.setAttribute("acron1", acron1);
    	request.setAttribute("acron2", acron2);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("compare.jsp");
			
    	dispatcher.forward(request, response);
	}

	private void compare(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
    	List<Criptomoneda> data = new ArrayList<>();
    	String[] notcriptos = new String[]{"USD","ALL","DZD"}; 
    	
    	data = criptomonedaDAO.list();

		request.setAttribute("criptos", data);
		request.setAttribute("notcriptos", Arrays.asList(notcriptos));
		RequestDispatcher dispatcher = request.getRequestDispatcher("compare.jsp");
		
		dispatcher.forward(request, response);
	}

	private void insertCurrency(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
    	String acron = request.getParameter("acr");
    	
    	// comprobamos la criptomoneda
    	if(acron.length() <= 10 && !acron.isEmpty()) {
        	criptomonedaDAO.addCurrency(acron.toUpperCase());
    	}

		response.sendRedirect("config");
    }

	private void setDAO(CriptomonedaDAO c) {
		this.criptomonedaDAO = c;
	}
	
    private void config(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
    	List<Criptomoneda> list = new ArrayList<>();
		
    	list = criptomonedaDAO.listCurrency("all");

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
        String acron= request.getParameter("id");
        Criptomoneda crip= criptomonedaDAO.getCriptomoneda(acron);
        List<HistorialPrecio> history = criptomonedaDAO.getHistory(acron);

        request.setAttribute("criptos", crip);
        request.setAttribute("hist", history);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("ficha.jsp");
        
        dispatcher.forward(request, response);
    }

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String acron = request.getParameter("id");
		String entity = request.getParameter("entity");
		
		if(entity.equals("criptomoneda")) {
			criptomonedaDAO.remove(acron, entity);
			response.sendRedirect("list");
		} else if(entity.equals("currency")) {
			criptomonedaDAO.remove(acron, entity);
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
    
}