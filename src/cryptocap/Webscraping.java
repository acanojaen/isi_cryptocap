package cryptocap;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.*;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
	String capitalizacion;
	String vol24;
	String volTotal;
	String lastdaychange;
	String sevendaychange;
	String description;
	String url;
	String percent_change_30d;
	
	int total_supply;
	int num_market_pairs;
	
	float precio;
	float total_market_cap;
	float total_volume_24h;
	float total_volume_24h_reported;

	Webscraping () {
		this.url = "";
	}

	public float Conversor(String amount, String acron1, String acron2) {
		String uri = "https://pro-api.coinmarketcap.com/v1/tools/price-conversion";
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		
		params.add(new BasicNameValuePair("amount", amount));
	    params.add(new BasicNameValuePair("symbol", acron1));
	    params.add(new BasicNameValuePair("convert", acron2));
	    

	    try {
	    	JsonObject local = makeAPICall(uri, params).getAsJsonObject("data").getAsJsonObject("quote").getAsJsonObject(acron2);
	    	
	    	return (local.get("price").getAsFloat());
	    } catch (IOException e) {
	    	return(0);
	    } catch (URISyntaxException e) {
	    	return(0);
	    }
	}
	
	public Criptomoneda getCryptoAPI(String acron) {
		String uri = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest";
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		
		params.add(new BasicNameValuePair("symbol", acron));

	    try {
	    	JsonObject local = makeAPICall(uri, params).getAsJsonObject("data").getAsJsonObject(acron);
	    	JsonObject prices = local.getAsJsonObject("quote").getAsJsonObject("USD");
	    	
	    	acronimo = local.get("symbol").getAsString();
	    	nombre = local.get("name").getAsString();
	    	precio = prices.get("price").getAsFloat();
	    	total_market_cap = prices.get("market_cap").getAsFloat();
	    	total_volume_24h = prices.get("volume_24h").getAsFloat();
	    	lastdaychange = prices.get("percent_change_24h").getAsString();
	    	sevendaychange = prices.get("percent_change_7d").getAsString();
	    	percent_change_30d = prices.get("percent_change_24h").getAsString();
	    	total_supply = local.get("total_supply").getAsInt();
	    	num_market_pairs = local.get("num_market_pairs").getAsInt();
	    	
	    	ultAct = getActualHour();
	    	
	    	return(new Criptomoneda(acron, nombre, ultAct, "enabled", precio, total_market_cap, total_volume_24h, lastdaychange, sevendaychange, percent_change_30d, total_supply, num_market_pairs));
	    	
	    } catch (IOException e) {
			return (new Criptomoneda(acron, ultAct, "disabled"));
	    } catch (URISyntaxException e) {
	    	return (new Criptomoneda(acron, ultAct, "disabled"));
	    }
	}
	
	public List<Integer> getMarketStats() {
		String uri = "https://pro-api.coinmarketcap.com/v1/global-metrics/quotes/latest";
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		List<Integer> array = new ArrayList<>();

	    try {
	    	JsonObject local = makeAPICall(uri, params).getAsJsonObject("data");
	    	array.add(local.get("active_cryptocurrencies").getAsInt());
	    	array.add(local.get("total_cryptocurrencies").getAsInt());
	    	array.add(local.get("active_exchanges").getAsInt());
	    	array.add(local.get("total_exchanges").getAsInt());
	    	array.add(local.get("active_market_pairs").getAsInt());
	    	
	    	return(array);
	    	
	    } catch (IOException e) {
			return (array);
	    } catch (URISyntaxException e) {
	    	return (array);
	    }
	}
	
	public Criptomoneda getMetadata(String acron) {
		String uri = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/info";
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		
		params.add(new BasicNameValuePair("symbol", acron));
		ultAct = getActualHour();
		
	    try {
	    	JsonObject local = makeAPICall(uri, params).getAsJsonObject("data").getAsJsonObject(acron);
	    	JsonObject urls = local.getAsJsonObject("urls");
			nombre = local.get("name").getAsString();
			imagen = local.get("logo").getAsString();
			description = local.get("description").getAsString();
			urlDatos = "";
	    	precio = Conversor("1", acron, "USD");
	    	
	    	return(new Criptomoneda(acron, nombre, "enabled", imagen, description, urlDatos, ultAct, precio));
	    	
	    } catch (IOException e) {
			return (new Criptomoneda(acron, ultAct, "disabled"));
	    } catch (URISyntaxException e) {
	    	return (new Criptomoneda(acron, ultAct, "disabled"));
	    }
	}
	
	// Scraping - Coinranking.com/es
		public Criptomoneda Coinmarketcap(String acron) throws IOException {
			String url = " https://pro-api.coinmarketcap.com/v1/global-metrics/quotes/latest ";
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
		String url2 = "https://es.investing.com/crypto/currencies";
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
                precio = parsePrecio(elem.getElementsByClass("price js-currency-price").text());
                total_market_cap = Float.parseFloat(elem.getElementsByClass("js-market-cap").attr("data-value"));
                total_volume_24h = Float.parseFloat(elem.getElementsByClass("js-24h-volume").attr("data-value"));
                volTotal = elem.getElementsByClass("js-total-vol").text();
                lastdaychange = elem.getElementsByClass("js-currency-change-24h greenFont pid-1061443-pcp").text();
                if(lastdaychange.isEmpty()) {
                    lastdaychange = elem.getElementsByClass("js-currency-change-24h redFont pid-1061453-pcp").text();
                }
                
                sevendaychange = elem.getElementsByClass("js-currency-change-7d greenFont").text();
                if(sevendaychange.isEmpty()) {
                	sevendaychange = elem.getElementsByClass("js-currency-change-7d redFont").text();
                }
                ultAct = getActualHour();
				
                if(elem.getElementsByClass("left noWrap elp symb js-currency-symbol").text().equals(acron)){
                    return (new Criptomoneda(acronimo, nombre, precio, total_market_cap, total_volume_24h, volTotal, lastdaychange, sevendaychange, ultAct, "enabled"));
                }
			}
			
			// si no se encuentra
			return (new Criptomoneda(acron, ultAct, "disabled"));
			
		} else {
			// si el codigo no es 200 (�xito)
			return (new Criptomoneda("ERROR", ultAct, "disabled"));
		}
	}

	public static JsonObject makeAPICall(String uri, List<NameValuePair> parameters)
		      throws URISyntaxException, IOException {
		    String response_content = "";
		    JsonObject rootObj;

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
		      
		      rootObj = (JsonObject) JsonParser.parseString(response_content).getAsJsonObject();
		      
		    } finally {
		      response.close();
		    }

		    return rootObj;
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
	
    public Float parsePrecio(String precio) {
    	precio = precio.replace(".","");
    	precio = precio.replace(",",".");
    	
    	return (Float.parseFloat(precio));
    }
	
}
