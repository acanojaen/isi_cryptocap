package cryptocap;

import java.io.IOException;

import org.jsoup.*;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Webscraping {
	
	String nombre;


	Webscraping (String nombre) {
		this.nombre = nombre;
		
	}

	// Scraping - Binance
	
	public String Binance() throws IOException {
		String url = "https://coinranking.com/es";
		int code;
		
		code = connect(url);
		
		// acceso correcto
		if(code == 200) {
			// cargamos el html de la página
			Document doc = html(url);
			
			Elements element = doc.select(":not(thead) tr.table__cell table__cell--3-of-8 table__cell--s-5-of-10");
			return element.html();
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
