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


/**
 * CriptomonedaDAO.java
 * Operaciones CRUD sobre el TDA Criptomoneda.
 */

public class CriptomonedaDAO 
{	
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection = null;
    
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
		String sql = "SELECT * FROM criptomonedas";
		PreparedStatement st;
		ResultSet rs;
		
    	connect();
    	
		st = jdbcConnection.prepareStatement(sql);
		rs = st.executeQuery();

		while(rs.next()) {
			c.add(new Criptomoneda(rs.getString(2), rs.getString(1) , rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
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
    
	public List<Criptomoneda> test() throws SQLException, IOException, URISyntaxException, ClassNotFoundException {
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
		
		// Variables de una criptomoneda
		String nombre;
		String acronimo;
		String precio;
		String capitalizacion;
		String urlDatos;
		String ultAct;
		
    	connect();
    	
        // Recorremos la lista de criptomonedas
        for(int i=0; i<lista.size(); i++){
        	it = new Webscraping();
            criptos.add(it.Coinranking(lista.get(i)));
     
            nombre = criptos.get(i).getNombre();
            acronimo = criptos.get(i).getAcronimo();
            precio = criptos.get(i).getVolumen();
            capitalizacion = criptos.get(i).getCapitalizacion();
            urlDatos = criptos.get(i).getUrlDatos();
            ultAct = criptos.get(i).getUltAct();
            
            
            // QUERY1: ¿Existe la moneda "i"?
    		sql = "SELECT * FROM criptomonedas";
    		sql += " WHERE acronimo = ?";
    	
    		st = jdbcConnection.prepareStatement(sql);
    		st.setString(1, acronimo);
        	
    		rs = st.executeQuery();
    		// si FALSE --> INSERT
    		if(!rs.next()) {
    			sql = "INSERT INTO criptomonedas (acronimo, nombre, precio, capitalizacion, url_datos, ult_act)";
    			sql += " VALUES (?, ?, ?, ?, ?, ?)";
    			
    			st = jdbcConnection.prepareStatement(sql);
    			st.setString(1, acronimo);
    			st.setString(2, nombre);
    			st.setString(3, precio);
    			st.setString(4, capitalizacion);
    			st.setString(5, urlDatos);
    			st.setString(6, ultAct);
    			
    			boolean rowInserted = st.executeUpdate() > 0;
    			st.close();
    			
    		} else {
    			// si TRUE --> UPDATE (existe)
    			sql = "UPDATE criptomonedas SET"; 
    			sql += " nombre = ?, precio = ?, capitalizacion = ?, url_datos = ?, ult_act = ? where acronimo = ?";
    			
    			st = jdbcConnection.prepareStatement(sql);
    			st.setString(1, nombre);
    			st.setString(2, precio);
    			st.setString(3, capitalizacion);
    			st.setString(4, urlDatos);
    			st.setString(5, ultAct);
    			st.setString(6, acronimo);
    			
    			boolean rowInserted = st.executeUpdate() > 0;
    			st.close();
    		}
        	
        }

        disconnect();

        return criptos;
    }


}
