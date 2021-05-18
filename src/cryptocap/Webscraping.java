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
	String acronimo;
	String precio;
	String capitalizacion;
	String urlImagen;


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
				nombre = (String) elem.getElementsByClass("profile__link").text();
				acronimo = (String) elem.getElementsByClass("profile__subtitle").text();
				precio = (String) elem.getElementsByClass("div.valuta.valuta--light").text();
				capitalizacion = (String) elem.getElementsByClass("div.valuta.valuta--light").text();
				urlImagen = (String) elem.getElementsByClass("profile__logo-background").attr("src");

				if(acron == acronimo){
					return (new Criptomoneda(nombre, acronimo, precio, capitalizacion, urlImagen));
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
