package cryptocap;

import java.util.ArrayList;
import java.util.Date;

public class Criptomoneda 
{	
	String nombre;
	String acronimo;
	String img;
	String volumen;
	String capitalizacion;
	String suministro_circulacion;
	String rango;
	String descripcion;
	Date fecha_emision;
	String urlImagen;
	String web;
	ArrayList<HistorialPrecios> historial;

	public Criptomoneda(String msg){
		this.nombre = msg;
		this.acronimo = msg;
	}

	public Criptomoneda(String nombre, String acronimo, String volumen, String capitalizacion, String urlImagen) {
		this.nombre = nombre;
		this.acronimo = acronimo;
		this.volumen = volumen;
		this.capitalizacion = capitalizacion;
		this.urlImagen = urlImagen;
	}

	public Criptomoneda(Criptomoneda c) {
		this.nombre = c.nombre;
		this.acronimo = c.acronimo;
		this.volumen = c.volumen;
		this.capitalizacion = c.capitalizacion;
		this.urlImagen = c.urlImagen;
	}

	public String getNombre() {
		return nombre;
	}

	public String getAcronimo() {
		return acronimo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	@Override
	public String toString() {
		return "Criptomoneda: nombre=" + nombre + ", acronimo=" + acronimo + "]";
	}

}
