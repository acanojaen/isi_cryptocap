package cryptocap;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
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

    private static Connection connect() throws SQLException, URISyntaxException {
    	URI jdbUri = new URI("mysql://go4wfmmyetu3gkvm:qvqtmle58bq9wcrq@lmc8ixkebgaq22lo.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/fbj6jfrdn8y5rorn?sslmode=require&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
    	String username = jdbUri.getUserInfo().split(":")[0];
        String password = jdbUri.getUserInfo().split(":")[1];
        String port = String.valueOf(jdbUri.getPort());
        String jdbUrl = "jdbc:mysql://" + jdbUri.getHost() + ":" + port + jdbUri.getPath();

        return DriverManager.getConnection(jdbUrl, username, password);
    }

    

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()){
            jdbcConnection.close();
        }
    }

    public ArrayList<Criptomoneda> test() throws SQLException, IOException, URISyntaxException {
		
    	connect();
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("BTC");
        lista.add("ETH");
        ArrayList<Criptomoneda> criptos = new ArrayList<Criptomoneda>();

        for(int i=0; i<lista.size(); i++){
            Webscraping it = new Webscraping();
            criptos.add(it.Coinranking(lista.get(i)));
        }

        disconnect();

        return criptos;
    }


}
