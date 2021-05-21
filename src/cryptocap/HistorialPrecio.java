package cryptocap;

import java.util.Date;

public class HistorialPrecio {
	String acronimo;
	String fecha;
	float valor;
	
	public HistorialPrecio(String fecha, String acronimo, float valor) {
		this.fecha = fecha;
		this.acronimo = acronimo;
		this.valor = valor;
	}
	
	public String getAcronimo() {
		return acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
}
