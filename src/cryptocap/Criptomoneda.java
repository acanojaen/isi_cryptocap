package cryptocap;

import java.util.ArrayList;
import java.util.Date;

public class Criptomoneda {

	/*-----------------------------------------Variables-----------------------------------------*/

	private String nombre;
	private String acronimo;
	private String imagen;
	private String urlDatos;

	private String precio;
	private String capMercado;
	private String volumen24;
	private String volumenTotal;
	private String variacion24;
	private String variacion7;

	private String ultimaActualizacion;


	/*-----------------------------------------Constructores-----------------------------------------*/

	public Criptomoneda(){
		nombre = "";
		acronimo = "";
		imagen = "";
		urlDatos = "";

		precio = "";
		capMercado = "";
		volumen24 = "";
		volumenTotal = "";
		variacion24 = "";
		variacion7 = "";

		ultimaActualizacion = "";
	}

	public Criptomoneda(Criptomoneda crip){
		nombre = crip.getNombre();
		acronimo = crip.getAcronimo();
		imagen = crip.getImagen();
		urlDatos = crip.getUrlDatos();

		precio = crip.getPrecio();
		capMercado = crip.getCapMercado();
		volumen24 = crip.getVolumen24();
		volumenTotal = crip.getVolumenTotal();
		variacion24 = crip.getVariacion24();
		variacion7 = crip.getVariacion7();

		ultimaActualizacion = crip.getUltimaActializacion();
	}

	public Criptomoneda(String nom, String acron, String imag, String url, String prec, String capMer, String vol24, String volTotal, String var24, String var7, String ultAct){
		nombre = nom;
		acronimo = acron;
		imagen = imag;
		urlDatos = url;

		precio = prec;
		capMercado = capMer;
		volumen24 = vol24;
		volumenTotal = volTotal;
		variacion24 = var24;
		variacion7 = var7;

		ultimaActualizacion = ultAct;
	}

	public Criptomoneda(String nom, String acron, String imag, String url, String ultAct){
		nombre = nom;
		acronimo = acron;
		imagen = imag;
		urlDatos = url;

		ultimaActualizacion = ultAct;
	}

	public Criptomoneda(String prec, String capMer, String vol24, String volTotal, String var24, String var7, String ultAct){
		precio = prec;
		capMercado = capMer;
		volumen24 = vol24;
		volumenTotal = volTotal;
		variacion24 = var24;
		variacion7 = var7;

		ultimaActualizacion = ultAct;
	}

	/*-----------------------------------------Modificadores-----------------------------------------*/

	void setNombre(String nom){
		nombre = nom;
	}

	void setAcronimo(String acron){
		acronimo = acron;
	}

	void setImagen(String imag){
		imagen = imag;
	}

	void setUrlDatos(String url){
		urlDatos = url;
	}

	void setPrecio(String prec){
		precio = prec;
	}

	void setCapMercado(String capMer){
		capMercado = capMer;
	}

	void setVolumen24(String vol24){
		volumen24 = vol24;
	}

	void setVolumenTotal(String volTotal){
		volumenTotal = volTotal;
	}

	void setVariacion24(String var24){
		variacion24 = var24;
	}

	void setVariacion7(String var7){
		variacion7 = var7;
	}

	void setUltimaActualizacion(String ultAct){
		ultimaActualizacion = ultAct;
	}

	void set(String nom, String acron, String imag, String url, String prec, String capMer,
				 String vol24, String volTotal, String var24, String var7){
		nombre = nom;
		acronimo = acron;
		imagen = imag;
		urlDatos = url;

		precio = prec;
		capMercado = capMer;
		volumen24 = vol24;
		volumenTotal = volTotal;
		variacion24 = var24;
		variacion7 = var7;
	}

	void set(String nom, String acron, String imag, String url){
		nombre = nom;
		acronimo = acron;
		imagen = imag;
		urlDatos = url;
	}

	void set(String prec, String capMer, String vol24, String volTotal, String var24, String var7){
		precio = prec;
		capMercado = capMer;
		volumen24 = vol24;
		volumenTotal = volTotal;
		variacion24 = var24;
		variacion7 = var7;
	}

	/*------------------------------------------Consultores------------------------------------------*/

	String getNombre(){
		return nombre;
	}

	String getAcronimo(){
		return acronimo;
	}

	String getImagen(){
		return imagen;
	}

	String getUrlDatos(){
		return urlDatos;
	}

	String getPrecio(){
		return precio;
	}

	String getCapMercado(){
		return capMercado;
	}

	String getVolumen24(){
		return volumen24;
	}

	String getVolumenTotal(){
		return volumenTotal;
	}

	String getVariacion24(){
		return variacion24;
	}

	String getVariacion7(){
		return variacion7;
	}

	String getUltimaActializacion(){
		return ultimaActualizacion;
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
