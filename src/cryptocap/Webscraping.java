package cryptocap;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.*;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Webscraping {
	private static final String API_KEY = "029b4eaa-1983-4586-9caa-a7e52efaed01";
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

	public String Conversor(String amount, String acron1, String acron2) {
		String uri = "https://pro-api.coinmarketcap.com/v1/tools/price-conversion";
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		
		params.add(new BasicNameValuePair("amount", amount));
	    params.add(new BasicNameValuePair("symbol", acron1));
	    params.add(new BasicNameValuePair("convert", acron2));
	    
	    params.add(new 
	    

	    try {
	    	return (makeAPICall(uri, params));
	    } catch (IOException e) {
	    	return("Error: cannont access content - " + e.toString());
	    } catch (URISyntaxException e) {
	    	return("Error: Invalid URL " + e.toString());
	    }
	}
		
	
	public static String makeAPICall(String uri, List<NameValuePair> parameters)
		      throws URISyntaxException, IOException {
		    String response_content = "";

		    URIBuilder query = new URIBuilder(uri);
		    query.addParameters(parameters);

		    CloseableHttpClient client = HttpClients.createDefault();
		    HttpGet request = new HttpGet(query.build());

		    request.setHeader(HttpHeaders.ACCEPT, "application/json");
		    request.addHeader("X-CMC_PRO_API_KEY", API_KEY);

		    CloseableHttpResponse response = client.execute(request);

		    try {
		      System.out.println(response.getStatusLine());
		      HttpEntity entity = response.getEntity();
		      response_content = EntityUtils.toString(entity);
		      EntityUtils.consume(entity);
		    } finally {
		      response.close();
		    }

		    return response_content;
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
				imagen = elem.getElementsByClass("table__logo").attr("src");
				urlDatos = url + elem.getElementsByClass("profile__link").attr("href");
				ultAct = getActualHour();

				// buscamos la que nosotros queremos
				if(elem.getElementsByClass("profile__subtitle").text().equals(acron)){
					return (new Criptomoneda(nombre, acronimo, imagen, urlDatos, ultAct, "enabled"));
				}
			}
			
			// si no se encuentra
			return (new Criptomoneda(acron, ultAct, "disabled"));
			
		} else {
			// si el codigo no es 200 (�xito)
			return (new Criptomoneda("ERROR", ultAct, "disabled"));
		}
	}	
	
	// Scraping - Investing.com/es
	public Criptomoneda Investing(String acron) throws IOException {
		String url2 = "https://es.investing.com/crypto/";
		int code;
		ultAct = getActualHour();
		
		code = connect(url2);
		
		// acceso correcto
		if(code == 200) {
			// cargamos el html de la p�gina
			Document doc = html(url2);
			
			Elements element = doc.select("table > tbody > tr:has(td)");
			
			// recorremos todas las criptomonedas
			for (Element elem : element) {
				acronimo = elem.getElementsByClass("left noWrap elp symb js-currency-symbol").text();
				nombre = elem.getElementsByClass("left bold elp name cryptoName first js-currency-name").text();
                precio = elem.getElementsByClass("price js-currency-price").text();
                capitalizacion = elem.getElementsByClass("js-market-cap").text();
                vol24 = elem.getElementsByClass("js-24h-volume").text();
                volTotal = elem.getElementsByClass("js-total-vol").text();
                lastdaychange = elem.getElementsByClass("js-currency-change-24h redFont pid-1057391-pcp").text();
                sevendaychange = elem.getElementsByClass("js-currency-change-7d redFont").text();
                ultAct = getActualHour();
				
                if(elem.getElementsByClass("left noWrap elp symb js-currency-symbol").text().equals(acron)){
                    return (new Criptomoneda(acronimo, nombre, precio, capitalizacion, vol24, volTotal, lastdaychange, sevendaychange, ultAct, "enabled"));
                }
			}
			
			// si no se encuentra
			return (new Criptomoneda(acron, ultAct, "disabled"));
			
		} else {
			// si el codigo no es 200 (�xito)
			return (new Criptomoneda("ERROR", ultAct, "disabled"));
		}
	}

	public Criptomoneda Test(String acron) throws IOException {
		String url2 = "https://es.investing.com/crypto/";
		int code;
		ultAct = getActualHour();
		
		code = connect(url2);
		
		// acceso correcto
		if(code == 200) {
			// cargamos el html de la p�gina
			Document doc = html(url2);
			
			Elements element = doc.select("table > tbody > tr:has(td)");
			
			// recorremos todas las criptomonedas
			for (Element elem : element) {
				return (new Criptomoneda(element.html(), getActualHour()));
               
			}
			
			// si no se encuentra
			return (new Criptomoneda(acron, getActualHour()));
			
		} else {
			// si el codigo no es 200 (�xito)
			return (new Criptomoneda("Codigo != 200"));
		}
	}
	

	public static int connect(String url) throws IOException {
		Response res;
		
		res = Jsoup.connect(url).timeout(10*1000).execute();
		
		return res.statusCode();
	}
	
	public static Document html(String url) throws IOException {
		Document doc;
		
		doc = Jsoup.connect(url).timeout(10*1000).get();
		
		return doc; 
	}
	
	public String getActualHour() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		
		return formatter.format(date);
	}
	
	
}
