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
	String urlDatos;

	Webscraping () {
		this.nombre = "TEST";
	}

	// Scraping - Coinranking.com/es
	public Criptomoneda Coinranking(String acron) throws IOException {
		String url = "https://coinranking.com";
		int code;
		
		code = connect(url);
		
		// acceso correcto
		if(code == 200) {
			// cargamos el html de la pï¿½gina
			Document doc = html(url);
			
			// obtenemos la lista de las criptomonedas (1 página)
			Elements element = doc.select(":not(thead) tr.table__row.table__row--click.table__row--full-width");
			
			// recorremos todas las criptomonedas
			for (Element elem : element) {
				nombre = elem.getElementsByClass("profile__link").text();
				acronimo = elem.getElementsByClass("profile__subtitle").text();
				precio = elem.getElementsByClass("valuta valuta--light").text();
				capitalizacion = elem.getElementsByClass("valuta valuta--light").text();
				urlDatos = url + elem.getElementsByClass("profile__link").attr("href");

				// buscamos la que nosotros queremos
				if(elem.getElementsByClass("profile__subtitle").text().equals(acron)){
					return (new Criptomoneda(nombre, acronimo, precio, capitalizacion, urlDatos));
				}
			}
			
			// si no se encuentra
			return (new Criptomoneda("No se ha encontrado la moneda " + acron));
			
		} else {
			// si el codigo no es 200 (éxito)
			return (new Criptomoneda("Codigo != 200"));
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
