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


	Webscraping () {
		this.nombre = "TEST";
	}

	// Scraping - Coinranking.com/es
	public Criptomoneda Binance(String acron) throws IOException {
		String url = "https://coinranking.com/es";
		int code;
		
		code = connect(url);
		
		// acceso correcto
		if(code == 200) {
			// cargamos el html de la p�gina
			Document doc = html(url);
			
			Elements element = doc.select(":not(thead) tr.table__row.table__row--click.table__row--full-width");
			
			for (Element elem : element) {
				String nombre = elem.getElementsByClass("profile__link").text();
				String acronimo = "BTC";
				//String precio = elem.getElementsByClass("div.valuta.valuta--light").text();
				//String capitalizacion = elem.getElementsByClass("div.valuta.valuta--light").text();
				//String urlImagen = elem.getElementsByClass("profile__logo-background").attr("src");

				if(acron == acronimo){
					return (new Criptomoneda(elem.getElementsByClass("profile__subtitle").text()));
				}
			}
			
			return (new Criptomoneda("No se ha encontrado la moneda " + acron));
			
		} else {
			return (new Criptomoneda("Codigo != 200"));
		}
	}		
	
	/*public ArrayList<Criptomoneda> getListaCriptomonedas(){
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
