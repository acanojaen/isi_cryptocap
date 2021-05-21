package cryptocap;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
	String urlDatos;
	String ultAct;
	String precio;
	String capitalizacion;
	String vol24;
	String volTotal;
	String lastdaychange;
	String sevendaychange;
	
    
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
			// TODO Auto-generated catch block
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
    	Criptomoneda crip;
		String sql = "SELECT * FROM criptomonedas";
		PreparedStatement st;
		ResultSet rs;
		
    	connect();
    	
		st = jdbcConnection.prepareStatement(sql);
		rs = st.executeQuery();

		while(rs.next()) {
			c.add(new Criptomoneda(rs.getString(2), rs.getString(1), "", rs.getString(3), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),  rs.getString(10), rs.getString(4)));
		}
		
		rs.close();
		st.close();
    	
		disconnect();
		return c;
    	
    }
    
    public boolean remove(Criptomoneda c) throws SQLException{
		String sql = "DELETE FROM criptomonedas where acronimo = ?";
		boolean stat;
		PreparedStatement st;
		
    	connect();
    	
    	
    	st = jdbcConnection.prepareStatement(sql);
    	st.setString(1, c.getAcronimo());
    		
    	stat = st.executeUpdate() > 0;
    		
    	st.close();
    	
		disconnect();
		return stat;
    	
    }
    
    public List<String> investing () throws IOException, SQLException{
    	List<String> lista = new ArrayList<>(); lista.add("BTC"); lista.add("ETH"); lista.add("USDT"); lista.add("ADA"); lista.add("BNB"); lista.add("DOGE");
    	lista.add("DOT"); lista.add("HEX"); lista.add("ICP"); lista.add("USDC");
    	List<Criptomoneda> criptos = new ArrayList<>();
    	Criptomoneda crip;
    	List<String> json = new ArrayList<>();
    	Webscraping it;
		String sql;
		PreparedStatement st;
		ResultSet rs;
		
		connect();
    	
        // Recorremos la lista de criptomonedas
        for(int i=0; i<lista.size(); i++){
        	it = new Webscraping();
        	crip=it.Investing(lista.get(i));
            criptos.add(crip);
            ObjectMapper mapper = new ObjectMapper();
			json.add(mapper.writeValueAsString(crip));
            
        	acronimo = criptos.get(i).getAcronimo();
        	nombre = criptos.get(i).getNombre();
        	precio = criptos.get(i).getPrecio();
        	capitalizacion = criptos.get(i).getCapMercado();
        	vol24 = criptos.get(i).getVolumen24();
        	volTotal = criptos.get(i).getVolumenTotal(); 
        	lastdaychange = criptos.get(i).getVariacion24();
        	sevendaychange = criptos.get(i).getVariacion7();
        	ultAct = criptos.get(i).getUltimaActualizacion();
        	
    		sql = "SELECT * FROM criptomonedas";
    		sql += " WHERE acronimo = ?";

    		st = jdbcConnection.prepareStatement(sql);
    		st.setString(1, acronimo);
        	
    		rs = st.executeQuery();
    		// si FALSE --> INSERT
    		if(!rs.next()) {
    			sql = "INSERT INTO criptomonedas (acronimo, nombre, ultAct, precio, capitalizacion, vol24, volTotal, lastdaychange, sevendaychange)";
    			sql += " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    			
    			st = jdbcConnection.prepareStatement(sql);
    			st.setString(1, acronimo);
    			st.setString(2, nombre);
    			st.setString(3, ultAct);
    			st.setString(4, precio);
    			st.setString(5, capitalizacion);
    			st.setString(6, vol24);
    			st.setString(7, volTotal);
    			st.setString(8, lastdaychange);
    			st.setString(9, sevendaychange);
    			
    			boolean rowInserted = st.executeUpdate() > 0;
    			st.close();
    			
    		} else {
    			// si TRUE --> UPDATE (existe)
    			sql = "UPDATE criptomonedas SET"; 
    			sql += " nombre = ?, ultAct = ?, precio = ?, capitalizacion = ?, vol24 = ?, volTotal = ?, lastdaychange = ?, sevendaychange = ? where acronimo = ?";
    			
    			st = jdbcConnection.prepareStatement(sql);
    			st.setString(1, nombre);
    			st.setString(2, ultAct);
    			st.setString(3, precio);
    			st.setString(4, capitalizacion);
    			st.setString(5, vol24);
    			st.setString(6, volTotal);
    			st.setString(7, lastdaychange);
    			st.setString(8, sevendaychange);
    			st.setString(9, acronimo);
    			
    			boolean rowInserted = st.executeUpdate() > 0;
    			st.close();
    		}

        }

        disconnect();

        return json;
    }
    
    
    
	public List<Criptomoneda> coinranking() throws SQLException, IOException, URISyntaxException, ClassNotFoundException {
    	// Test: consiste en buscar la moneda que se quiere añadir
    	// si existe: --> UPDATE criptomonedas SET nombre = ?, precio = ?, capitalizacion = ?, url_datos = ? 
    	// si no existe: --> INSERT INTO criptomonedas (acronimo, nombre, precio, capitalizacion, url_datos) WHERE (?, ?, ?, ?, ?)
    	List<String> lista = new ArrayList<>(); lista.add("BTC"); lista.add("ETH"); lista.add("USDT"); lista.add("ADA"); lista.add("BNB"); lista.add("DOGE");
    	lista.add("DOT"); lista.add("HEX"); lista.add("ICP"); lista.add("USDC");
    	List<Criptomoneda> criptos = new ArrayList<>();
        Criptomoneda actual;
        Webscraping it;
		String sql;
		PreparedStatement st;
		ResultSet rs;
		
		
    	connect();
    	
        // Recorremos la lista de criptomonedas
        for(int i=0; i<lista.size(); i++){
        	it = new Webscraping();
            criptos.add(it.Coinranking(lista.get(i)));
     
            nombre = criptos.get(i).getNombre();
            acronimo = criptos.get(i).getAcronimo();
            urlDatos = criptos.get(i).getUrlDatos();
            ultAct = criptos.get(i).getUltimaActualizacion();
            
            
            // QUERY1: ¿Existe la moneda "i"?
    		sql = "SELECT * FROM criptomonedas";
    		sql += " WHERE acronimo = ?";
    	
    		st = jdbcConnection.prepareStatement(sql);
    		st.setString(1, acronimo);
        	
    		rs = st.executeQuery();
    		// si FALSE --> INSERT
    		if(!rs.next()) {
    			sql = "INSERT INTO criptomonedas (acronimo, nombre, urlDatos, ultAct)";
    			sql += " VALUES (?, ?, ?, ?)";
    			
    			st = jdbcConnection.prepareStatement(sql);
    			st.setString(1, acronimo);
    			st.setString(2, nombre);
    			st.setString(3, urlDatos);
    			st.setString(4, ultAct);
    			
    			boolean rowInserted = st.executeUpdate() > 0;
    			st.close();
    			
    		} else {
    			// si TRUE --> UPDATE (existe)
    			sql = "UPDATE criptomonedas SET"; 
    			sql += " nombre = ?, urlDatos = ?, ultAct = ? where acronimo = ?";
    			
    			st = jdbcConnection.prepareStatement(sql);
    			st.setString(1, nombre);
    			st.setString(2, urlDatos);
    			st.setString(3, ultAct);
    			st.setString(4, acronimo);
    			
    			boolean rowInserted = st.executeUpdate() > 0;
    			st.close();
    		}

        }

        disconnect();

        return criptos;
    }


}
