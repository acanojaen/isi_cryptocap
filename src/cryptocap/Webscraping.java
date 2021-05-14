package cryptocap;

import java.io.IOException;

import org.jsoup.*;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Webscraping {
	
	String nombre;


	Webscraping (String nombre) {
		this.nombre = nombre;
		
	}

	// Scraping - Coinranking.com/es
	public String Binance() throws IOException {
		String url = "https://coinranking.com/es";
		String nombre_criptomoneda = null;
		int code;
		
		code = connect(url);
		
		// acceso correcto
		if(code == 200) {
			// cargamos el html de la p�gina
			Document doc = html(url);
			
			Elements element = doc.select(":not(thead) tr.table__row.table__row--click.table__row--full-width");
			
			for (Element elem : element) {
				nombre_criptomoneda = elem.getElementsByClass("profile__link").text();
			}
			
			return nombre_criptomoneda;
			
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
