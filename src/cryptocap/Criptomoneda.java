package cryptocap;

import java.util.ArrayList;
import java.util.Date;

public class Criptomoneda {
	private: 
		String nombre;
		String acronimo;
		String imagen;
		String urlDatos;

		String precio;
		String capMercado;
		String volumen24;
		String volumenTotal;
		String variacion24;
		String variacion7;

		String ultimaActualizacion;

	public:
		/*-----------------------------------------Constructores-----------------------------------------*/
		Criptomoneda(){
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

		Criptomoneda(Criptomoneda crip){
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

		Criptomoneda(String nom, String acron, String imag, String url, String prec, String capMer,
					 String vol24, String volTotal, String var24, String var7, String ultAct){
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

		Criptomoneda(String nom, String acron, String imag, String url, String ultAct){
			nombre = nom;
			acronimo = acron;
			imagen = imag;
			urlDatos = url;

			ultimaActualizacion = ultAct;
		}

		Criptomoneda(String prec, String capMer, String vol24, String volTotal, 
					String var24, String var7, String ultAct){
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


















		





	String nombre;
	String acronimo;
	String img;
	String volumen;
	String capitalizacion;
	String suministro_circulacion;
	String rango;
	String descripcion;
	Date fecha_emision;
	String urlDatos;
	String web;
	ArrayList<HistorialPrecios> historial;
	String ultAct;

	public Criptomoneda(String acron){
		this.acronimo = acron;
	}

	public Criptomoneda(String nombre, String acronimo, String volumen, String capitalizacion, String urlDatos, String ultAct) {
		this.nombre = nombre;
		this.acronimo = acronimo;
		this.volumen = volumen;
		this.capitalizacion = capitalizacion;
		this.urlDatos = urlDatos;
		this.ultAct = ultAct;
	}

	public Criptomoneda(Criptomoneda c) {
		this.nombre = c.nombre;
		this.acronimo = c.acronimo;
		this.volumen = c.volumen;
		this.capitalizacion = c.capitalizacion;
		this.urlDatos = c.urlDatos;
	}

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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getVolumen() {
		return volumen;
	}

	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}

	public String getCapitalizacion() {
		return capitalizacion;
	}

	public void setCapitalizacion(String capitalizacion) {
		this.capitalizacion = capitalizacion;
	}

	public String getSuministro_circulacion() {
		return suministro_circulacion;
	}

	public void setSuministro_circulacion(String suministro_circulacion) {
		this.suministro_circulacion = suministro_circulacion;
	}

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha_emision() {
		return fecha_emision;
	}

	public void setFecha_emision(Date fecha_emision) {
		this.fecha_emision = fecha_emision;
	}

	public String getUrlDatos() {
		return urlDatos;
	}
	
	public String getUltAct() {
		return ultAct;
	}

	public void setUrlDatos(String urlDatos) {
		this.urlDatos = urlDatos;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public ArrayList<HistorialPrecios> getHistorial() {
		return historial;
	}

	public void setHistorial(ArrayList<HistorialPrecios> historial) {
		this.historial = historial;
	}

	@Override
	public String toString() {
		return "{nombre : " + nombre + ", acronimo : " + acronimo + ", volumen : " + volumen + ", capitalizacion : " + capitalizacion + ", urlDatos : " + urlDatos + "}";
	}

}
