package clase;

import java.time.LocalDate;
import java.util.ArrayList;

public class Venta {
	private int cod;
	private LocalDate fecha;
	
	private Usuario usuario;
	
	ArrayList<DetalleVenta> detVen;
	
	public double getCostoTotal() {
	    return detVen.stream()
	        .mapToDouble(d -> d.getCant() * d.getPrecioUni())
	        .sum();
	}

	public Venta(int cod, LocalDate fecha, Usuario usuario, ArrayList<DetalleVenta> detVen) {
		this.cod = cod;
		this.fecha = fecha;
		this.usuario = usuario;
		this.detVen = detVen;
	}

	public Venta() {
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ArrayList<DetalleVenta> getDetVen() {
		return detVen;
	}

	public void setDetVen(ArrayList<DetalleVenta> detVen) {
		this.detVen = detVen;
	}
}
