package cryptocap;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.jsoup.*;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Webscraping {
	
	String nombre;
	String acronimo;
	String imagen;
	String urlDatos;
	String ultAct;
	String precio;
	String capitalizacion;
	String vol24;
	String volTotal;
	String lastdaychange;
	String sevendaychange;

	Webscraping () {
		this.nombre = "";
	}

	// Scraping - Coinranking.com/es
	public Criptomoneda Coinranking(String acron) throws IOException {
		String url = "https://coinranking.com";
		int code;
		
		code = connect(url);
		
		// acceso correcto
		if(code == 200) {
			// cargamos el html de la p�gina
			Document doc = html(url);
			
			// obtenemos la lista de las criptomonedas (1 p�gina)
			Elements element = doc.select(":not(thead) tr.table__row.table__row--click.table__row--full-width");
			
			// recorremos todas las criptomonedas
			for (Element elem : element) {
				nombre = elem.getElementsByClass("profile__link").text();
				acronimo = elem.getElementsByClass("profile__subtitle").text();
				imagen = elem.getElementsByClass("profile__logo-background").text();
				urlDatos = url + elem.getElementsByClass("profile__link").attr("href").text();
				ultAct = getActualHour();

				// buscamos la que nosotros queremos
				if(elem.getElementsByClass("profile__subtitle").text().equals(acron)){
					return (new Criptomoneda(nombre, acronimo, imagen, urlDatos, ultAct));
				}
			}
			
			// si no se encuentra
			return (new Criptomoneda("No se ha encontrado la moneda " + acron));
			
		} else {
			// si el codigo no es 200 (�xito)
			return (new Criptomoneda("Codigo != 200"));
		}
	}	
	
	// Scraping - Investing.com/es
	public Criptomoneda Investing(String acron) throws IOException {
		String url2 = "https://es.investing.com/crypto/currencies";
		int code;
		
		code = connect(url2);
		
		// acceso correcto
		if(code == 200) {
			// cargamos el html de la p�gina
			Document doc = html(url2);
			
			//***********************CAMBIAR doc.select*****************
			// obtenemos la lista de las criptomonedas (1 p�gina)
			Elements element = doc.select(":not(thead) tr.table__row.table__row--click.table__row--full-width");
			
			// recorremos todas las criptomonedas
			for (Element elem : element) {
				precio = elem.getElementsByClass("price js-currency-price").text();
				capitalizacion = elem.getElementsByClass("js-market-cap").text();
				vol24 = elem.getElementsByClass("js-24h-volume").text();
				volTotal = elem.getElementsByClass("js-total-vol").text();
				lastdaychange = elem.getElementsByClass("js-currency-change-24h redFont pid-1057391-pcp").text();
				sevendaychange = elem.getElementsByClass("js-currency-change-7d redFont").text();

				//***********************CAMBIAR new Criptomoneda*****************
				// buscamos la que nosotros queremos  
				if(elem.getElementsByClass("left noWrap elp symb js-currency-symbol").text().equals(acron)){
					return (new Criptomoneda(precio, capitalizacion, vol24, volTotal, lastdaychange, sevendaychange));
				}
			}
			
			// si no se encuentra
			return (new Criptomoneda("No se ha encontrado la moneda " + acron));
			
		} else {
			// si el codigo no es 200 (�xito)
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
	
	public String getActualHour() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		
		return formatter.format(date);
	}
	
	
}
