package cryptocap;

import java.io.IOException;

import org.jsoup.*;
import org.jsoup.Connection.Response;

public class Webscraping {
	
	String nombre;


	Webscraping (String nombre) {
		this.nombre = nombre;
		
	}

	// Scraping - Binance
	
	void Binance() throws IOException {
		String url = "https://www.binance.com/es/markets";
		int code;
		
		code = connect(url);
		
		if(code == 200) {
			System.out.println("Conexión correcta");
		} else {
			System.out.println("Conexión errónea");
		}
	}		
	

	public static int connect(String url) throws IOException {
		Response res;
		
		res = Jsoup.connect(url).execute();
		
		return res.statusCode();
	}
	
	
}
