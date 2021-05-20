package cryptocap;

import java.util.ArrayList;
import java.util.Date;

public class Criptomoneda {

	/*-----------------------------------------Variables-----------------------------------------*/

	public String nombre;
	public String acronimo;
	public String imagen;
	public String urlDatos;

	public String precio;
	public String capMercado;
	public String volumen24;
	public String volumenTotal;
	public String variacion24;
	public String variacion7;

	public String ultimaActualizacion;


	/*-----------------------------------------Constructores-----------------------------------------*/

	public Criptomoneda(String acronimo) {
		this.acronimo = acronimo;
	}
	
	public Criptomoneda(){
		this.nombre = "";
		this.acronimo = "";
		this.imagen = "";
		this.urlDatos = "";

		this.precio = "";
		this.capMercado = "";
		this.volumen24 = "";
		this.volumenTotal = "";
		this.variacion24 = "";
		this.variacion7 = "";

		this.ultimaActualizacion = "";
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

		this.ultimaActualizacion = crip.getUltimaActializacion();
	}

	public Criptomoneda(String nom, String acron, String imag, String url, String prec, String capMer, String vol24, String volTotal, String var24, String var7, String ultAct){
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
	}

	public Criptomoneda(String nom, String acron, String imag, String url, String ultAct){
		this.nombre = nom;
		this.acronimo = acron;
		this.imagen = imag;
		this.urlDatos = url;

		this.ultimaActualizacion = ultAct;
	}

	public Criptomoneda(String prec, String capMer, String vol24, String volTotal, String var24, String var7, String ultAct){
		this.precio = prec;
		this.capMercado = capMer;
		this.volumen24 = vol24;
		this.volumenTotal = volTotal;
		this.variacion24 = var24;
		this.variacion7 = var7;

		this.ultimaActualizacion = ultAct;
	}

	/*-----------------------------------------Modificadores-----------------------------------------*/

	void setNombre(String nom){
		this.nombre = nom;
	}

	void setAcronimo(String acron){
		this.acronimo = acron;
	}

	void setImagen(String imag){
		this.imagen = imag;
	}

	void setUrlDatos(String url){
		this.urlDatos = url;
	}

	void setPrecio(String prec){
		this.precio = prec;
	}

	void setCapMercado(String capMer){
		this.capMercado = capMer;
	}

	void setVolumen24(String vol24){
		this.volumen24 = vol24;
	}

	void setVolumenTotal(String volTotal){
		this.volumenTotal = volTotal;
	}

	void setVariacion24(String var24){
		this.variacion24 = var24;
	}

	void setVariacion7(String var7){
		this.variacion7 = var7;
	}

	void setUltimaActualizacion(String ultAct){
		this.ultimaActualizacion = ultAct;
	}

	void set(String nom, String acron, String imag, String url, String prec, String capMer,
				 String vol24, String volTotal, String var24, String var7){
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
	}

	void set(String nom, String acron, String imag, String url){
		this.nombre = nom;
		this.acronimo = acron;
		this.imagen = imag;
		this.urlDatos = url;
	}

	void set(String prec, String capMer, String vol24, String volTotal, String var24, String var7){
		this.precio = prec;
		this.capMercado = capMer;
		this.volumen24 = vol24;
		this.volumenTotal = volTotal;
		this.variacion24 = var24;
		this.variacion7 = var7;
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
