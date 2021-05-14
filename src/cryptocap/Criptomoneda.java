package cryptocap;

import java.util.ArrayList;
import java.util.Date;

public class Criptomoneda 
{	
	String nombre;
	String acronimo;
	String img;
	float volumen;
	float capitalizacion;
	float suministro_circulacion;
	int rango;
	String descripcion;
	Date fecha_emision;
	String web;
	ArrayList<HistorialPrecios> historial;

	public Criptomoneda(String nombre, String acronimo, String img, float volumen, float capitalizacion, float suministro_circulacion, int rango, String descripcion, Date fecha_emision, String web) {
		this.historial = new ArrayList<HistorialPrecios>();
		this.acronimo = acronimo;
		this.img = img;
		this.nombre = nombre;
		this.volumen = volumen;
		this.capitalizacion = capitalizacion;
		this.suministro_circulacion = suministro_circulacion;
		this.rango = rango;
		this.descripcion = descripcion;
		this.fecha_emision = fecha_emision;
		this.web = web;
	}

	public Criptomoneda(String nombre, String acronimo, String volumen) {
		this.nombre = nombre;
		this.acronimo = acronimo;
		this.volumen = Float.parseFloat(volumen);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getVolumen() {
		return volumen;
	}

	public void setVolumen(float volumen) {
		this.volumen = volumen;
	}

	public float getCapitalizacion() {
		return capitalizacion;
	}

	public void setCapitalizacion(float capitalizacion) {
		this.capitalizacion = capitalizacion;
	}

	public float getSuministro_circulacion() {
		return suministro_circulacion;
	}

	public void setSuministro_circulacion(float suministro_circulacion) {
		this.suministro_circulacion = suministro_circulacion;
	}

	public int getRango() {
		return rango;
	}

	public void setRango(int rango) {
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
		return "Criptomoneda [nombre=" + nombre + ", acronimo=" + acronimo + ", volumen=" + volumen + "]";
	}
}
