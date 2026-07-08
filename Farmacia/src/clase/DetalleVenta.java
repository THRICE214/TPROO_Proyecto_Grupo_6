package clase;

public class DetalleVenta {
	private int cod, cant;
	private double  precioUni;
	
	private Venta venta;
	private Producto pro;
	private Lote lote;
	
	public DetalleVenta(int cod, int cant, double precioUni, Venta venta, Producto pro, Lote lote) {
		this.cod = cod;
		this.cant = cant;
		this.precioUni = precioUni; //historico
		this.venta = venta;
		this.pro = pro;
		this.lote = lote;
	}

	public DetalleVenta() {
	}
	
	public double getSubTotal() {
	    return this.cant * this.precioUni;
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

	public double getPrecioUni() {
		return precioUni;
	}

	public void setPrecioUni(double precioUni) {
		this.precioUni = precioUni;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
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
