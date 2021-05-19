package cryptocap;

import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
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
    private Connection jdbcConnection;
    
    public CriptomonedaDAO(String url, String user, String password){
        this.jdbcURL = url;
        this.jdbcUsername = user;  
        this.jdbcPassword = password;
    }

    public CriptomonedaDAO (CriptomonedaDAO c){
        this.jdbcURL = c.jdbcURL;
        this.jdbcUsername = c.jdbcUsername;  
        this.jdbcPassword = c.jdbcPassword;
    }

    protected Connection connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver"); 
            } catch(ClassNotFoundException e){
                throw new SQLException(e);
            } 

            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

            return jdbcConnection;
        }

        return jdbcConnection;
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()){
            jdbcConnection.close();
        }
    }

    public ArrayList<String> test() throws SQLException {
        connect();
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("BTC");
        lista.add("ETH");
        ArrayList<String> criptos = new ArrayList<String>();

        for(int i=0; i<lista.size(); i++){
            Webscraping it = new Webscraping();
            criptos.add(it.Coinranking(lista.get(i)).toString());
        }

        disconnect();

        return criptos;
    }


}
