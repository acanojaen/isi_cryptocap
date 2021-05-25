package cryptocap;

import java.util.ArrayList;
import java.util.Date;

public class Criptomoneda {

	/*-----------------------------------------Variables-----------------------------------------*/

	public String nombre;
	public String acronimo;
	public String imagen;
	public String urlDatos;

	public String capMercado;
	public String volumen24;
	public String volumenTotal;

	public String ultimaActualizacion;
	public String status;
	public String msg;
	public String desc;
	
	public String percent_change_24h;
	public String percent_change_7d;
	public String percent_change_30d;
	
	public float precio;
	public float total_market_cap;
	public float total_volume_24h;
    public float total_volume_24h_reported;
	public float variacion24;
	public float variacion7;
    public float variacion30;
    public int total_supply;
    public int num_market_pairs;
	
	/*-----------------------------------------Constructores-----------------------------------------*/

	public Criptomoneda(String acronimo) {
		this.acronimo = acronimo;
		this.nombre = acronimo;
		this.ultimaActualizacion = "";
	}
	
	public Criptomoneda(String acronimo, String status) {
		this.acronimo = acronimo;
		this.nombre = acronimo;
		this.status = status;
	}

	public Criptomoneda(String acronimo, String ultAct, String status) {
		this.acronimo = acronimo;
		this.nombre = acronimo;
		this.ultimaActualizacion = ultAct;
		this.status = status;
	}

	public Criptomoneda(String acronimo, String ultAct, String status, float total_market_cap, float total_volume_24h, float total_volume_24h_reported) {
		this.acronimo = acronimo;
		this.nombre = acronimo;
		this.ultimaActualizacion = ultAct;
		this.status = status;
		this.total_market_cap = total_market_cap;
	 	this.total_volume_24h = total_volume_24h;
    	this.total_volume_24h_reported = total_volume_24h_reported;
	}
	
	public Criptomoneda(Criptomoneda crip){
		this.nombre = crip.getNombre();
		this.acronimo = crip.getAcronimo();
		this.imagen = crip.getImagen();
		this.urlDatos = crip.getUrlDatos();

		this.precio = crip.getPrecio();
		this.capMercado = crip.getCapMercado();
		this.volumen24 = crip.getVolumen24();
		this.volumenTotal = crip.getVolumenTotal();
		this.variacion24 = crip.getVariacion24();
		this.variacion7 = crip.getVariacion7();
	}

	public Criptomoneda(String nom, String acron, String imag, String url, float prec, String capMer, String vol24, String volTotal, float var24, float var7, String ultAct, String desc){
		this.nombre = nom;
		this.acronimo = acron;
		this.imagen = imag;
		this.urlDatos = url;

		this.precio = prec;
		this.capMercado = capMer;
		this.volumen24 = vol24;
		this.volumenTotal = volTotal;
		this.variacion24 = var24;
		this.variacion7 = var7;

		this.ultimaActualizacion = ultAct;
		this.desc = desc;
	}
	
	public Criptomoneda(String nom, String acron, String imag, String url, float prec, float total_market_cap, float total_volume_24h, String volTotal, float var24, float var7, String ultAct, String desc){
		this.nombre = nom;
		this.acronimo = acron;
		this.imagen = imag;
		this.urlDatos = url;

		this.precio = prec;
		this.total_market_cap = total_market_cap;
		this.total_volume_24h = total_volume_24h;
		this.volumenTotal = volTotal;
		this.variacion24 = var24;
		this.variacion7 = var7;

		this.ultimaActualizacion = ultAct;
		this.desc = desc;
	}

	public Criptomoneda(String acron, String nombre, float prec, String capMer, String vol24, String volTotal, String var24, String var7, String ultAct, String status){
		this.acronimo = acron;
		this.nombre = nombre;
		this.precio = prec;
		this.capMercado = capMer;
		this.volumen24 = vol24;
		this.volumenTotal = volTotal;
		this.variacion24 = Float.parseFloat(var24);
		this.variacion7 = Float.parseFloat(var7);

		this.ultimaActualizacion = ultAct;
		this.status = status;
	}
	
	
	public Criptomoneda(String acron, String nombre, float prec, float total_market_cap, float total_volume_24h, String volTotal, float var24, float var7, String ultAct, String status){
		this.acronimo = acron;
		this.nombre = nombre;
		this.precio = prec;
		this.total_market_cap = total_market_cap;
		this.total_volume_24h = total_volume_24h;
		this.volumenTotal = volTotal;
		this.variacion24 = var24;
		this.variacion7 = var7;

		this.ultimaActualizacion = ultAct;
		this.status = status;
	}
	
	public Criptomoneda(String nom, String acron, String imag, String url, float prec, String capMer, String vol24, String volTotal, float var24, float var7, float variacion30, String ultAct, float total_market_cap, float total_volume_24h){
		this.nombre = nom;
		this.acronimo = acron;
		this.imagen = imag;
		this.urlDatos = url;

		this.precio = prec;
		this.capMercado = capMer;
		this.volumen24 = vol24;
		this.volumenTotal = volTotal;
		this.variacion24 = var24;
		this.variacion7 = var7;
		this.variacion30 = variacion30;
		this.percent_change_24h = setVariacion24_S(var24);
		this.percent_change_7d = setVariacion7_S(var7);
		this.percent_change_30d = setVariacion30_S(variacion30);

		this.ultimaActualizacion = ultAct;
		this.total_market_cap = total_market_cap;
	 	this.total_volume_24h = total_volume_24h;
	}
	
	public Criptomoneda(String nombre, String acronimo, String imagen, String urlDatos, String ultimaActualizacion, String status) {
		this.nombre = nombre;
		this.acronimo = acronimo;
		this.imagen = imagen;
		this.urlDatos = urlDatos;
		this.ultimaActualizacion = ultimaActualizacion;
		this.status = status;
	}
	
	public Criptomoneda(String acronimo, String nombre, String status, String imagen, String desc, String urlDatos, String ultimaActualizacion) {
		this.acronimo = acronimo;
		this.nombre = nombre;
		this.status = status;
		this.imagen = imagen;
		this.desc = desc;
		this.urlDatos = urlDatos;
		this.ultimaActualizacion = ultimaActualizacion;
	}
	
	public Criptomoneda(String acronimo, String nombre, String status, String imagen, String desc, String urlDatos, String ultimaActualizacion, float precio) {
		this.acronimo = acronimo;
		this.nombre = nombre;
		this.status = status;
		this.imagen = imagen;
		this.desc = desc;
		this.urlDatos = urlDatos;
		this.ultimaActualizacion = ultimaActualizacion;
		this.precio = precio;
	}
	
	public Criptomoneda(String acron, String nombre, String ultAct, String status, float precio, float total_market_cap, float total_volume_24h, float percent_change_24h, float percent_change_7d, float percent_change_30d, int total_supply, int num_market_pairs) {
		this.acronimo = acron;
		this.nombre = nombre;
		this.ultimaActualizacion = ultAct;
		this.status = status;
		this.precio = precio;
		this.total_market_cap = total_market_cap;
		this.total_volume_24h = total_volume_24h;
		this.variacion24 = percent_change_24h;
		this.variacion7 = percent_change_7d;
		this.variacion30 = percent_change_30d;
		this.total_supply = total_supply;
		this.num_market_pairs = num_market_pairs;
		
		
	}
	
	
	

	/*----------------------------------Modificadores y Consultores----------------------------------*/
	
	
	
	public String getNombre() {
		return nombre;
	}

	public float getVariacion30() {
		return variacion30;
	}

	public void setVariacion30(float variacion30) {
		this.variacion30 = variacion30;
	}

	public int getTotal_supply() {
		return total_supply;
	}

	public void setTotal_supply(int total_supply) {
		this.total_supply = total_supply;
	}

	public int getNum_market_pairs() {
		return num_market_pairs;
	}

	public void setNum_market_pairs(int num_market_pairs) {
		this.num_market_pairs = num_market_pairs;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAcronimo() {
		return acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getUrlDatos() {
		return urlDatos;
	}

	public void setUrlDatos(String urlDatos) {
		this.urlDatos = urlDatos;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getCapMercado() {
		return capMercado;
	}

	public void setCapMercado(String capMercado) {
		this.capMercado = capMercado;
	}

	public String getVolumen24() {
		return volumen24;
	}

	public void setVolumen24(String volumen24) {
		this.volumen24 = volumen24;
	}

	public String getVolumenTotal() {
		return volumenTotal;
	}

	public void setVolumenTotal(String volumenTotal) {
		this.volumenTotal = volumenTotal;
	}

	public float getVariacion24() {
		return variacion24;
	}

	public void setVariacion24(float variacion24) {
		this.variacion24 = variacion24;
	}

	public float getVariacion7() {
		return variacion7;
	}
	
	public String setVariacion7_S(float var) {
		if (var >= 0) {
			return "+" + String.valueOf(var);
		} else {
			return String.valueOf(var);
		}
	}

	public String setVariacion24_S(float var) {
		if (var >= 0) {
			return "+" + String.valueOf(var);
		} else {
			return String.valueOf(var);
		}
	}
	
	public String setVariacion30_S(float var) {
		if (var >= 0) {
			return "+" + String.valueOf(var);
		} else {
			return String.valueOf(var);
		}
	}
	
	public void setVariacion7(float variacion7) {
		this.variacion7 = variacion7;
	}

	public String getUltimaActualizacion() {
		return ultimaActualizacion;
	}

	public void setUltimaActualizacion(String ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}

	public float getTotal_market_cap() {
		return total_market_cap;
	}

	public void setTotal_market_cap(float total_market_cap) {
		this.total_market_cap = total_market_cap;
	}

	public float getTotal_volume_24h() {
		return total_volume_24h;
	}

	public void setTotal_volume_24h(float total_volume_24h) {
		this.total_volume_24h = total_volume_24h;
	}

	public float getTotal_volume_24h_reported() {
		return total_volume_24h_reported;
	}

	public void setTotal_volume_24h_reported(float total_volume_24h_reported) {
		this.total_volume_24h_reported = total_volume_24h_reported;
	}

	/*-------------------------------------------to_String-------------------------------------------*/
	
	@Override
	public String toString() {
		return "{imagen" + imagen + "nombre : " + nombre + ", acronimo : " + acronimo + ", precio : " + precio + 
			", capitalizacion de mercado : " + capMercado + ", Volumen 24h : " + volumen24 + 
			", Volumen total : " + volumenTotal + ", Variación 24h : " + variacion24 +
			", Variación 7d : " + variacion7 + ", urlDatos : " + urlDatos + 
			", Ultima actualización : " + ultimaActualizacion + "}";
	}
}
