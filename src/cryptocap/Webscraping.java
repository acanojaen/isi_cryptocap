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
	
	public int Binance() throws IOException {
		String url = "https://www.binance.com/es/markets";
		int code;
		
		code = connect(url);
		
		if(code == 200) {
			return 1;
		} else {
			return 0;
		}
	}		
	

	public static int connect(String url) throws IOException {
		Response res;
		
		res = Jsoup.connect(url).execute();
		
		return res.statusCode();
	}
	
	
}
