package clase;

import java.time.LocalDate;
import java.util.ArrayList;

public class Compra {
	private int cod;
	private LocalDate fecha;
	
	private Usuario usuario;
	private ArrayList<DetalleCompra> detCom;

	public double getCostoTotal() {
	    return detCom.stream()
	        .mapToDouble(d -> d.getCant() * d.getCostoUni())
	        .sum();
	}

	public Compra(int cod, LocalDate fecha, Usuario usuario, ArrayList<DetalleCompra> detCom) {
		this.cod = cod;
		this.fecha = fecha;
		this.usuario = usuario;
		this.detCom = detCom;
	}

	public Compra() {
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

	public ArrayList<DetalleCompra> getDetCom() {
		return detCom;
	}

	public void setDetCom(ArrayList<DetalleCompra> detCom) {
		this.detCom = detCom;
	}
}
