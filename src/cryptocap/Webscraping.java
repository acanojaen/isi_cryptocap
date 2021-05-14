package cryptocap;

import java.io.IOException;
import java.util.ArrayList;

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
		int code;
		ArrayList<Criptomoneda> criptos;
		
		criptos = new ArrayList<Criptomoneda>();
		
		code = connect(url);
		
		// acceso correcto
		if(code == 200) {
			// cargamos el html de la página
			Document doc = html(url);
			
			Elements element = doc.select(":not(thead) tr.table__row.table__row--click.table__row--full-width");
			
			for (Element elem : element) {
				String nombre = elem.getElementsByClass("profile__link").text();
				String acronimo = elem.getElementsByClass("profile__subtitle").text();
				String precio = elem.getElementsByClass("div.valuta.valuta--light").text();
				
				
				Criptomoneda c = new Criptomoneda(nombre, acronimo, precio);
				System.out.println(c.toString());
				
				criptos.add(c);
			}
			
			return criptos.toString();
			
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
