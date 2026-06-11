package clase;

import java.time.LocalDate;

public class Lote {
	private int id;
	private String numeroLote;
    private LocalDate fechaVencimiento;
    private int cantidad;
    
	public Lote(String numeroLote, LocalDate fechaVencimiento, int cantidad) {
		this.numeroLote = numeroLote;
		this.fechaVencimiento = fechaVencimiento;
		this.cantidad = cantidad;
	}
	
	public Lote() {
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
