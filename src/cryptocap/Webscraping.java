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
	public Criptomoneda Binance(String acron) throws IOException {
		String url = "https://coinranking.com/es";
		int code;
		ArrayList<Criptomoneda> criptos;
		
		criptos = new ArrayList<Criptomoneda>();
		
		code = connect(url);
		
		// acceso correcto
		if(code == 200) {
			// cargamos el html de la p�gina
			Document doc = html(url);
			
			Elements element = doc.select(":not(thead) tr.table__row.table__row--click.table__row--full-width");
			
			for (Element elem : element) {
				if(acron == elem.getElementsByClass("profile__subtitle").text()){
					String nombre = elem.getElementsByClass("profile__link").text();
					String acronimo = elem.getElementsByClass("profile__subtitle").text();
					String precio = elem.getElementsByClass("div.valuta.valuta--light").text();
					String capitalizacion = elem.getElementsByClass("div.valuta.valuta--light").text();
					String urlImagen = elem.getElementsByClass("profile__logo-background").attr("src");
					
					return (new Criptomoneda(nombre, acronimo, precio, capitalizacion, urlImagen));
				}
			}
			
			return element.html();
			
		} else {
			return "null";
		}
	}		
	
	/*public ArrayList<Producto> getListaCriptomonedas(){
    	return this.criptos;
    }*/

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
