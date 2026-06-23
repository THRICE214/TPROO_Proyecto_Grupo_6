package clase;

import java.time.LocalDate;

public class Lote {
	private int id;
	private String numeroLote;
    private LocalDate fechaVencimiento;
    private int stockActual;
    
    private DetalleCompra detCom;
    private Producto pro;
    
	public Lote(int id, String numeroLote, LocalDate fechaVencimiento, int stockActual, DetalleCompra detCom,
			Producto pro) {
		this.id = id;
		this.numeroLote = numeroLote;
		this.fechaVencimiento = fechaVencimiento;
		this.stockActual = stockActual;
		this.detCom = detCom;
		this.pro = pro;
	}

	public Lote() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(String numeroLote) {
		this.numeroLote = numeroLote;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public int getStockActual() {
		return stockActual;
	}

	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}

	public DetalleCompra getDetCom() {
		return detCom;
	}

	public void setDetCom(DetalleCompra detCom) {
		this.detCom = detCom;
	}

	public Producto getPro() {
		return pro;
	}

	public void setPro(Producto pro) {
		this.pro = pro;
	}
}
