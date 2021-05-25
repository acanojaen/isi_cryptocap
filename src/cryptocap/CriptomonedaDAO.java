package cryptocap;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.*;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;


/**
 * CriptomonedaDAO.java
 * Operaciones CRUD sobre el TDA Criptomoneda.
 * 
 * 
 * 
 * 
 * CREATE TABLE criptomonedas (
 *  acronimo varchar(10) NOT NULL,
 *  nombre varchar(128) NOT NULL,
 *  urlDatos varchar(128),
 *  ultAct varchar(128) NOT NULL,
 *  precio varchar(128),
 *  capitalizacion varchar(128),
 *  vol24 varchar(128),
 *  volTotal varchar(128),
 *  lastdaychange varchar(128),
 *  sevendaychange varchar(128),
 *  PRIMARY KEY (acronimo),
 *  UNIQUE KEY acronimo_UNIQUE (acronimo)
 * ) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
 *
 *
 *
 */

public class CriptomonedaDAO 
{	
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection = null;
    
	String acronimo;
	String nombre;
	String imagen;
	String urlDatos;
	String ultAct;
	String capitalizacion;
	String vol24;
	String volTotal;
	float lastdaychange;
	float sevendaychange;
	float percent_change_30d;
	String status;
	String desc;
	
	float precio;
	float total_volume_24h_reported;
	float total_volume_24h;
	float total_market_cap;
	private int total_supply;
	private int num_market_pairs;
	
    
    public CriptomonedaDAO(String url, String user, String password){
        this.jdbcURL = url;
        this.jdbcUsername = user;  
        this.jdbcPassword = password;
    }

    protected void connect() throws SQLException {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }

    

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()){
            jdbcConnection.close();
        }
    }
    
    public List<Criptomoneda> list() throws SQLException{
    	List<Criptomoneda> c = new ArrayList<>();
		String sql = "SELECT * FROM criptomonedas";
		PreparedStatement st;
		ResultSet rs;
		
    	connect();
    	
		st = jdbcConnection.prepareStatement(sql);
		rs = st.executeQuery();
		
		while(rs.next()) {
			nombre = rs.getString(2);
	    	acronimo = rs.getString(1);
	    	imagen = rs.getString(11);
	    	urlDatos = rs.getString(3);
	    	precio = rs.getFloat(5);
	    	capitalizacion = rs.getString(6);
	    	vol24 = rs.getString(7);
	    	volTotal = rs.getString(8); 
	    	lastdaychange = rs.getFloat(9);
	    	sevendaychange = rs.getFloat(10);
	    	ultAct = rs.getString(4);
	    	desc = rs.getString(15);
	    	
	    	if(desc != null) {
	    		desc = desc.substring(0, 45) + "...";
	    	}
	    	
			c.add(new Criptomoneda(nombre, acronimo, imagen, urlDatos, precio, capitalizacion, vol24, volTotal, lastdaychange, sevendaychange, ultAct, desc));
		}
		
		rs.close();
		st.close();
    	
		disconnect();
		return c;
    	
    }
    
    public List<Criptomoneda> listMarket() throws SQLException{
    	List<Criptomoneda> c = new ArrayList<>();
		String sql = "SELECT * FROM criptomonedas ORDER BY precio DESC;";
		PreparedStatement st;
		Criptomoneda crip;
		ResultSet rs;
		
    	connect();
    	
		st = jdbcConnection.prepareStatement(sql);
		rs = st.executeQuery();
		
		while(rs.next()) {
			nombre = rs.getString(2);
	    	acronimo = rs.getString(1);
	    	urlDatos = rs.getString(3);
	    	precio = rs.getFloat(5);
	    	total_market_cap = rs.getFloat(12);
	    	total_volume_24h = rs.getFloat(13);
	    	vol24 = rs.getString(7);
	    	volTotal = rs.getString(8); 
	    	lastdaychange = rs.getFloat(9);
	    	sevendaychange = rs.getFloat(10);
	    	percent_change_30d = rs.getFloat(14);
	    	ultAct = rs.getString(4);
	    	imagen = rs.getString(11);
			crip = new Criptomoneda(nombre, acronimo, imagen, urlDatos, precio, capitalizacion, vol24, volTotal, lastdaychange, sevendaychange,percent_change_30d, ultAct, total_market_cap, total_volume_24h);
			crip.setVariacion24_S(rs.getFloat(9));
			crip.setVariacion30_S(rs.getFloat(14));
			crip.setVariacion7_S(rs.getFloat(10));
			
			c.add(crip);
		}
		
		rs.close();
		st.close();
    	
		disconnect();
		return c;
    	
    }
    
    public ArrayList<Criptomoneda> listCurrency(String status) throws SQLException {
    	ArrayList<Criptomoneda> res = new ArrayList<>();
    	String sql;
		PreparedStatement st;
		ResultSet rs;
		
		connect();
		
		switch(status) {
			case "disabled":
				sql = "SELECT * FROM currency";
				sql += " where status = ?";
				st = jdbcConnection.prepareStatement(sql);
				st.setString(1, "disabled");
				break;
			case "enabled":
				sql = "SELECT * FROM currency";
				sql += " where status = ?";
				st = jdbcConnection.prepareStatement(sql);
				st.setString(1, "enabled");
				break;
			default:
				sql = "SELECT * FROM currency";
				st = jdbcConnection.prepareStatement(sql);
				break;
		}
	
		
		rs = st.executeQuery();
		
		while(rs.next()) {
			res.add(new Criptomoneda(rs.getString(1), rs.getString(2)));
		}
		
		rs.close();
		st.close();
		
		disconnect();
	
		return res;
    }
    
    public List<String> getListing() throws SQLException{
    	List<String> res = new ArrayList<>();
    	String sql = "SELECT * FROM currency";
    	PreparedStatement st;
		ResultSet rs;
		
    	connect();
    	
		st = jdbcConnection.prepareStatement(sql);
		rs = st.executeQuery();
		
		while(rs.next()) {
			res.add(rs.getString(1));
		}
		
		rs.close();
		st.close();
    	
		disconnect();
		return res;
    }
    
	public Criptomoneda getCriptomoneda(String acron) throws SQLException{
		String sql;
		sql = "SELECT * FROM criptomonedas";
		sql += " WHERE acronimo = ?";
		PreparedStatement st;
		ResultSet rs;

		connect();

		st = jdbcConnection.prepareStatement(sql);
		st.setString(1, acron);
		
		rs = st.executeQuery();
		if(rs.next()) {
			nombre = rs.getString(2);
	    	acronimo = rs.getString(1);
	    	imagen = rs.getString(11);
	    	urlDatos = rs.getString(3);
	    	precio = rs.getFloat(5);
	    	total_market_cap = rs.getFloat(12);
	    	total_volume_24h = rs.getFloat(13);
	    	volTotal = rs.getString(8); 
	    	lastdaychange = rs.getFloat(9);
	    	sevendaychange = rs.getFloat(10);
	    	ultAct = rs.getString(4);
	    	desc = rs.getString(15);
			
			rs.close();
			st.close();

			return (new Criptomoneda(nombre, acronimo, imagen, urlDatos, precio, total_market_cap, total_volume_24h, volTotal, lastdaychange, sevendaychange, ultAct, desc));				
		}
		rs.close();
		st.close();
		disconnect();
    	return (new Criptomoneda("Error"));
	}
    
    public boolean addCurrency(String acron) throws SQLException {
		String sql;
    	PreparedStatement st;
    	ResultSet rs;
    	boolean stat = false;
    	
    	connect();
    	
    	sql = "SELECT * FROM currency";
		sql += " WHERE acronimo = ?";

		st = jdbcConnection.prepareStatement(sql);
		st.setString(1, acron);
		
		rs = st.executeQuery();
		// si FALSE --> INSERT
		if(!rs.next()) {
			sql = "INSERT INTO currency (acronimo)";
			sql += " VALUES (?)";
			st = jdbcConnection.prepareStatement(sql);
			st.setString(1, acron);
			stat = st.executeUpdate() > 0;
			st.close();
			
		} 
		
		st.close();
		disconnect();
		
		return stat;
    }
    
    public boolean addMarketStats () throws SQLException {
    	String sql;
    	PreparedStatement st;
    	Webscraping w;
    	boolean stat = false; 
    	List<Integer> array = new ArrayList<>();
    	
    	    	
    	w = new Webscraping();
    	array = w.getMarketStats();
    	
    	sql = "UPDATE market SET active_cryptocurrencies = ?, total_cryptocurrencies = ?, active_exchanges = ?, "
    		+ " total_exchanges = ?, active_market_pairs = ? WHERE market_id = ?";
    	connect();
    	
    	st = jdbcConnection.prepareStatement(sql);
    	st.setInt(1, array.get(0));
    	st.setInt(2, array.get(1));
    	st.setInt(3, array.get(2));
    	st.setInt(4, array.get(3));
    	st.setInt(5, array.get(4));
    	st.setInt(6, 0);
    	
		stat = st.executeUpdate() > 0;

		
		disconnect();
		
		st.close();
		return stat;
    }
	public List<HistorialPrecio> getHistory(String acron) throws SQLException {
		List<HistorialPrecio> history = new ArrayList<>();
		String sql;
		sql = "SELECT * FROM history";
		sql += " WHERE acronimo = ?";
		PreparedStatement st;
		ResultSet rs;

		connect();

		st = jdbcConnection.prepareStatement(sql);
		st.setString(1, acron);
		
		rs = st.executeQuery();
		while(rs.next()) {
			ultAct = rs.getString(1);
	    	acronimo = rs.getString(2);
	    	precio = rs.getFloat(3);
	    	
	    	history.add(new HistorialPrecio(ultAct, acronimo, precio));
		}
		
		disconnect();
		return history;
	}
	
	public List<Number> getMarketStats () throws SQLException {
		String sql;
		PreparedStatement st;
		ResultSet rs;
		List<Number> list = new ArrayList<>();
		
		connect();
		
		sql = "SELECT * FROM market";
		sql += " WHERE market_id = ?";
				
		st = jdbcConnection.prepareStatement(sql);
    	st.setInt(1, 0);			
	
		rs = st.executeQuery();
		
		if(rs.next()) {
			list.add(rs.getInt(1));
			list.add(rs.getInt(2));
			list.add(rs.getInt(3));
			list.add(rs.getInt(4));
			list.add(rs.getInt(5));
		}
		
		rs.close();
		st.close();
		
		disconnect();
		
		return list;
	}
	
    
    public boolean addToHistory(String acron, float precio) throws SQLException {
		String sql;
    	PreparedStatement st;
    	boolean stat = false;
    	
    	sql = "INSERT INTO history (fecha, acronimo, precio)";
		sql += " VALUES (?, ?, ?)";
		st = jdbcConnection.prepareStatement(sql);
		
		st.setString(1, getActualHour());
		st.setString(2, acron);
		st.setFloat(3, precio);
		stat = st.executeUpdate() > 0;
		st.close();
			
		
		return stat;
    }
    
    
    public boolean remove(String acron, String entity) throws SQLException{
    	String sql;
    	PreparedStatement st;
    	ResultSet rs;
    	boolean stat = false;
    	
    	connect();
    	
    	switch(entity) {
    		case "criptomoneda":
    			sql = "DELETE FROM criptomonedas where acronimo = ?";
    	    	st = jdbcConnection.prepareStatement(sql);
    	    	st.setString(1, acron);
    	    	stat = st.executeUpdate() > 0;
    			stat = setCurrencyStatus(acron, "disabled");
    	    	
    	    	st.close();
    			break;
    		case "currency":
    			sql = "SELECT * FROM criptomonedas where acronimo = ?";
    	    	st = jdbcConnection.prepareStatement(sql);
    	    	st.setString(1, acron);
    	    	rs = st.executeQuery();
	    		
	    		if(!rs.next() ) {
	    			sql = "DELETE FROM currency where acronimo = ?";
	    	    	st = jdbcConnection.prepareStatement(sql);
	    	    	st.setString(1, acron);
	    	    	stat = st.executeUpdate() > 0;
		    	}
	    		
    	    	st.close();
    			
    	    	break;
    	}

		disconnect();
		
		return stat;
    	
    }
    
    
    public boolean setCurrencyStatus(String acronimo, String status) throws SQLException {
    	String sql;
    	PreparedStatement st;
    	boolean stat = false;
    	
    	
    	sql = "UPDATE currency SET"; 
		sql += " status = ? where acronimo = ?";
		
		st = jdbcConnection.prepareStatement(sql);
		st.setString(1, status);
		st.setString(2, acronimo);
    	
		stat = st.executeUpdate() > 0;
    	
    	
		return stat;
    	
    }
    
    public List<Criptomoneda> investing () throws IOException, SQLException{
    	List<String> lista = getListing();
    	List<Criptomoneda> criptos = new ArrayList<>();
    	Criptomoneda crip;
    	Webscraping it;
		String sql;
		PreparedStatement st;
		ResultSet rs;
    	boolean stat = false;
		
		connect();
    	
		// lista de criptomonedas recopilada en la tabla "currency"
		// status: enabled (aquellas encontradas)
		//		   disabled (no se ha encontrado)
        for(int i=0; i<lista.size(); i++){
        	it = new Webscraping();
        	
        	// scrapeamos --> Class Webscraping
        	crip = it.Investing(lista.get(i));
        	if(crip.getStatus().equals("enabled")) {
	    		criptos.add(crip);
	    		       		
	    		acronimo = crip.getAcronimo();
	        	nombre = crip.getNombre();
	        	precio = crip.getPrecio();
	        	total_market_cap = crip.getTotal_market_cap();
	        	total_volume_24h = crip.getTotal_volume_24h();
	        	volTotal = crip.getVolumenTotal(); 
	        	lastdaychange = crip.getVariacion24();
	        	sevendaychange = crip.getVariacion7();
	        	ultAct = crip.getUltimaActualizacion();
	        	
	        	// necesitamos saber si existe en la base de datos (2 casos)
	        	sql = "SELECT * FROM criptomonedas";
	    		sql += " WHERE acronimo = ?";
	
	    		st = jdbcConnection.prepareStatement(sql);
	    		st.setString(1, acronimo);
	        	
	    		rs = st.executeQuery();
	    		
	    		// INSERCION
	    		if(!rs.next()) {
	    			sql = "INSERT INTO criptomonedas (acronimo, nombre, ultAct, precio, total_market_cap, total_volume_24h, volTotal)";
	    			sql += " VALUES (?, ?, ?, ?, ?, ?, ?)";
	    			
	    			st = jdbcConnection.prepareStatement(sql);
	    			st.setString(1, acronimo);
	    			st.setString(2, nombre);
	    			st.setString(3, ultAct);
	    			st.setFloat(4, precio);
	    			st.setFloat(5, total_market_cap);
	    			st.setFloat(6, total_volume_24h);
	    			st.setString(7, volTotal);
	    			stat = st.executeUpdate() > 0;
	    			stat = addToHistory(acronimo, precio);
		            stat = setCurrencyStatus(acronimo, "enabled");
	
	    			st.close();
	    			
	    		} else {            	
	    			// MODIFICACI�N
	    			sql = "UPDATE criptomonedas SET"; 
	    			sql += " nombre = ?, ultAct = ?, precio = ?, total_market_cap = ?, total_volume_24h = ?, volTotal = ?, percent_change_24h = ?, percent_change_7d = ? where acronimo = ?";
	    			
	    			st = jdbcConnection.prepareStatement(sql);
	    			st.setString(1, nombre);
	    			st.setString(2, ultAct);
	    			st.setFloat(3, precio);
	    			st.setFloat(4, total_market_cap);
	    			st.setFloat(5, total_volume_24h);
	    			st.setString(6, volTotal);
	    			st.setFloat(7, lastdaychange);
	    			st.setFloat(8, sevendaychange);
	    			st.setString(9, acronimo);
	    			
	    			stat = st.executeUpdate() > 0;
	    			stat = addToHistory(acronimo, precio);
	    			
	    			st.close();
	    			
	    		} 
        	}
        }
        
        disconnect();

        return criptos;
    }
    
    
    
	public List<Criptomoneda> coinranking() throws SQLException, IOException, URISyntaxException, ClassNotFoundException {
    	List<String> lista = getListing();
    	List<Criptomoneda> criptos = new ArrayList<>();
    	Criptomoneda crip;
        Webscraping it;
		String sql;
		PreparedStatement st;
		ResultSet rs;
		boolean stat;
		
		
    	connect();
    	
        // Recorremos la lista de criptomonedas
        for(int i=0; i<lista.size(); i++){
        	it = new Webscraping();
        	
        	// scrapeamos --> Class Webscraping
        	crip = it.Coinranking(lista.get(i));
        	if(crip.getStatus().equals("enabled")) {
        		criptos.add(crip);
            
	            nombre = crip.getNombre();
	            status = crip.getStatus();
	            acronimo = crip.getAcronimo();
	            urlDatos = crip.getUrlDatos();
	            ultAct = crip.getUltimaActualizacion();
	            imagen = crip.getImagen();
	            
	            
	            // QUERY1: �Existe la moneda "i"?
	    		sql = "SELECT * FROM criptomonedas";
	    		sql += " WHERE acronimo = ?";
	    	
	    		st = jdbcConnection.prepareStatement(sql);
	    		st.setString(1, acronimo);
	        	
	    		rs = st.executeQuery();
	    		// si FALSE --> INSERT
	    		if(!rs.next() ) {
					sql = "INSERT INTO criptomonedas (acronimo, nombre, urlDatos, ultAct, urlImagen)";
					sql += " VALUES (?, ?, ?, ?, ?)";
					
					st = jdbcConnection.prepareStatement(sql);
					st.setString(1, acronimo);
					st.setString(2, nombre);
					st.setString(3, urlDatos);
					st.setString(4, ultAct);
					st.setString(5, imagen);
					
					stat = st.executeUpdate() > 0;
		            stat = setCurrencyStatus(acronimo, "enabled");
		            st.close();
	    			
	    		} else {
	    			sql = "UPDATE criptomonedas SET"; 
	    			sql += " nombre = ?, urlDatos = ?, ultAct = ?, urlImagen = ? where acronimo = ?";
	    			
	    			st = jdbcConnection.prepareStatement(sql);
	    			st.setString(1, nombre);
	    			st.setString(2, urlDatos);
	    			st.setString(3, ultAct);
	       			st.setString(4, imagen);
	    			st.setString(5, acronimo);
	    			
	    			stat = st.executeUpdate() > 0;
	    			st.close();
	    			
	    		} 
        	} 
        }

        disconnect();

        return criptos;
    }
	
	public List<Criptomoneda> setAllPricesAPI() throws SQLException {
		List<Criptomoneda> lista = listCurrency("enabled");
    	List<Criptomoneda> criptos = new ArrayList<>();
    	Criptomoneda crip;
        Webscraping it;
		String sql;
		PreparedStatement st;
		ResultSet rs;
		boolean stat;
		
		
    	connect();
    	
        // Recorremos la lista de criptomonedas
        for(int i=0; i<lista.size(); i++){
        	it = new Webscraping();
        	
        	// scrapeamos --> Class Webscraping
        	crip = it.getCryptoAPI(lista.get(i).getAcronimo());
    		criptos.add(crip);
        
    		acronimo = crip.getAcronimo();
    		nombre = crip.getNombre();
    		precio = crip.getPrecio();
    		total_market_cap = crip.getTotal_market_cap();
    		total_volume_24h = crip.getTotal_volume_24h();
            lastdaychange = crip.getVariacion7();
            sevendaychange = crip.getVariacion24();
            percent_change_30d = crip.getVariacion30();
            total_supply = crip.getTotal_supply();
            num_market_pairs = crip.getNum_market_pairs();
            ultAct = crip.getUltimaActualizacion();
            
            // QUERY1: �Existe la moneda "i"?
    		sql = "SELECT * FROM criptomonedas";
    		sql += " WHERE acronimo = ?";
    	
    		st = jdbcConnection.prepareStatement(sql);
    		st.setString(1, acronimo);
        	
    		rs = st.executeQuery();

    		if(rs.next() ) {
    			sql = "UPDATE criptomonedas SET"; 
    			sql += " precio = ?, total_market_cap = ?, total_volume_24h = ?, percent_change_24h = ?, percent_change_7d = ?, percent_change_30d = ?, total_supply = ?, num_market_pairs = ?, ultAct = ? where acronimo = ?";
    			
    			st = jdbcConnection.prepareStatement(sql);
    			st.setFloat(1, precio);
    			st.setFloat(2, total_market_cap);
    			st.setFloat(3, total_volume_24h);
    			st.setFloat(4, lastdaychange);
    			st.setFloat(5, sevendaychange);
    			st.setFloat(6, percent_change_30d);
    			st.setInt(7, total_supply);
    			st.setInt(8, num_market_pairs);
    			st.setString(9, ultAct);
    			st.setString(10, acronimo);
    			
    			stat = st.executeUpdate() > 0;
    			st.close();
    			
    		} else {
    			sql = "INSERT INTO criptomonedas (acronimo, nombre, ultAct, precio, total_market_cap, total_volume_24h, percent_change_24h, percent_change_7d, percent_change_30d, total_supply, num_market_pairs)";
				sql += " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
    			st = jdbcConnection.prepareStatement(sql);
    			st.setString(1, acronimo);
    			st.setString(2, nombre);
    			st.setString(3, ultAct);
    			st.setFloat(4, precio);
    			st.setFloat(5, total_market_cap);
    			st.setFloat(6, total_volume_24h);
    			st.setFloat(7, lastdaychange);
    			st.setFloat(8, sevendaychange);
    			st.setFloat(9, percent_change_30d);
    			st.setInt(10, total_supply);
    			st.setInt(11, num_market_pairs);
    			
    			stat = st.executeUpdate() > 0;
    			st.close();
    		}
        }

        disconnect();

        return criptos;
    }
	
	public boolean setPriceAPI(String acron) throws SQLException {
		PreparedStatement st;
		ResultSet rs;
		String sql;
		Webscraping it;
		Criptomoneda crip;
		boolean stat = false;
		
		sql = "SELECT * FROM criptomonedas";
		sql += " WHERE acronimo = ?";
		
		connect(); 
		
		it = new Webscraping();
    	
    	// scrapeamos --> Class Webscraping
    	crip = it.getCryptoAPI(acron);
		
		st = jdbcConnection.prepareStatement(sql);
		st.setString(1, acron);
    	
		rs = st.executeQuery();
		
		if(rs.next()) {
			sql = "UPDATE criptomonedas SET"; 
			sql += " precio = ?, total_market_cap = ?, total_volume_24h = ?, percent_change_24h = ?, percent_change_7d = ?, percent_change_30d = ?, total_supply = ?, num_market_pairs = ?, ultAct = ? where acronimo = ?";
			
			st = jdbcConnection.prepareStatement(sql);
			st.setFloat(1, crip.getPrecio());
			st.setFloat(2, crip.getTotal_market_cap());
			st.setFloat(3, crip.getTotal_volume_24h());
			st.setFloat(4, crip.getVariacion24());
			st.setFloat(5, crip.getVariacion7());
			st.setFloat(6, crip.getVariacion30());
			st.setInt(7, crip.getTotal_supply());
			st.setInt(8, crip.getNum_market_pairs());
			st.setString(9, crip.getUltimaActualizacion());
			st.setString(10, acron);
			
			stat = st.executeUpdate() > 0;
			st.close();
		}
		
		rs.close();
		st.close();
		
		disconnect();
		
		return stat;
		
	}
	
	public boolean setMetadataAPI(String acron) throws SQLException{
    	Criptomoneda crip;
        Webscraping it;
		String sql;
		PreparedStatement st;
		ResultSet rs;
		boolean stat;
		
		
    	connect();
    	
        // Recorremos la lista de criptomonedas
    	it = new Webscraping();
    	
    	// llamamos a la api --> Class Webscraping
    	crip = it.getMetadata(acron);
    	
    	if(crip.getStatus().equals("disabled") && crip.getAcronimo().equals(crip.getNombre())) {
            disconnect();
            
            return false;
    	}
    
		acronimo = crip.getAcronimo();
		nombre = crip.getNombre();
        urlDatos = crip.getUrlDatos();
        ultAct = crip.getUltimaActualizacion();
        imagen = crip.getImagen();
        desc = crip.getDesc();
        status = crip.getStatus();
        precio = crip.getPrecio();
        
        // QUERY1: �Existe la moneda "i"?
		sql = "SELECT * FROM criptomonedas";
		sql += " WHERE acronimo = ?";
	
		st = jdbcConnection.prepareStatement(sql);
		st.setString(1, acronimo);
    	
		rs = st.executeQuery();
		// si FALSE --> INSERT
		if(!rs.next() ) {
			sql = "INSERT INTO criptomonedas (acronimo, nombre, urlDatos, ultAct, urlImagen, description, precio)";
			sql += " VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			st = jdbcConnection.prepareStatement(sql);
			st.setString(1, acronimo);
			st.setString(2, nombre);
			st.setString(3, urlDatos);
			st.setString(4, ultAct);
			st.setString(5, imagen);
			st.setString(6, desc);
			st.setFloat(7, precio);
			
			stat = st.executeUpdate() > 0;
            stat = setCurrencyStatus(acronimo, "enabled");
            st.close();
			
		} else {
			sql = "UPDATE criptomonedas SET"; 
			sql += " nombre = ?, urlDatos = ?, ultAct = ?, urlImagen = ?, description = ?, precio = ? where acronimo = ?";
			
			st = jdbcConnection.prepareStatement(sql);
			st.setString(1, nombre);
			st.setString(2, urlDatos);
			st.setString(3, ultAct);
   			st.setString(4, imagen);
   			st.setString(5, desc);
			st.setFloat(6, precio);
			st.setString(7, acronimo);
			
			
			stat = st.executeUpdate() > 0;
			st.close();
			
		} 

        disconnect();

        return stat;
	}
	
	public static String getActualHour() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		
		return formatter.format(date);
	}


}
