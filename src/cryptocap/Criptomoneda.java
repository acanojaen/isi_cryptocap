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

	Criptomoneda(String nom, String acron, String imag, String url, String prec, String capMer, String vol24, String volTotal, String var24, String var7, String ultAct){
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

	Criptomoneda(String prec, String capMer, String vol24, String volTotal, String var24, String var7, String ultAct){
		this.precio = prec;
		this.capMercado = capMer;
		this.volumen24 = vol24;
		this.volumenTotal = volTotal;
		this.variacion24 = var24;
		this.variacion7 = var7;

		this.ultimaActualizacion = ultAct;
	}
	
	public Criptomoneda(String nombre, String acronimo, String imagen, String urlDatos, String ultimaActualizacion) {
		this.nombre = nombre;
		this.acronimo = acronimo;
		this.imagen = imagen;
		this.urlDatos = urlDatos;
		this.ultimaActualizacion = ultimaActualizacion;
	}
	
	/*-----------------------------------------Modificadores-----------------------------------------*/
	
	public String getNombre() {
		return nombre;
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

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
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

	public String getVariacion24() {
		return variacion24;
	}

	public void setVariacion24(String variacion24) {
		this.variacion24 = variacion24;
	}

	public String getVariacion7() {
		return variacion7;
	}

	public void setVariacion7(String variacion7) {
		this.variacion7 = variacion7;
	}

	public String getUltimaActualizacion() {
		return ultimaActualizacion;
	}

	public void setUltimaActualizacion(String ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
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
