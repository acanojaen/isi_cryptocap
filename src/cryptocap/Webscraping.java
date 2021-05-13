package cryptocap;

import java.io.IOException;

import org.jsoup.*;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;

public class Webscraping {
	
	String nombre;


	Webscraping (String nombre) {
		this.nombre = nombre;
		
	}

	// Scraping - Binance
	
	public String Binance() throws IOException {
		String url = "https://www.binance.com/es/markets";
		int code;
		
		code = connect(url);
		
		// acceso correcto
		if(code == 200) {
			// cargamos el html de la página
			Document doc = html(url);
			return doc.outerHtml();
		} else {
			return "null";
		}
	}		
	

	public static int connect(String url) throws IOException {
		Response res;
		
		res = Jsoup.connect(url).timeout(1000).execute();
		
		return res.statusCode();
	}
	
	public static Document html(String url) throws IOException {
		Document doc;
		
		doc = Jsoup.connect(url).timeout(1000).get();
		
		return doc; 
	}
	
	
}
