package clase;

import java.time.LocalDate;

public class DetalleCompra {
	private int cod, cant;
	private double  costoUni;
	
	private Compra compra;
	private Producto pro;
	private Lote lote;
	
	public DetalleCompra(int cod, int cant, double costoUni, Compra compra, Producto pro, Lote lote) {
		this.cod = cod;
		this.cant = cant;
		this.costoUni = costoUni;
		this.compra = compra;
		this.pro = pro;
		this.lote = lote;
	}

	public DetalleCompra() {
	}

	//obtener el costo del detalle de compra
	public Double getSubTotal() {
		return this.cant * this.costoUni;
	}
	
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public double getCostoUni() {
		return costoUni;
	}

	public void setCostoUni(double costoUni) {
		this.costoUni = costoUni;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Producto getPro() {
		return pro;
	}

	public void setPro(Producto pro) {
		this.pro = pro;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}
}
