package clase;

import java.util.ArrayList;
import java.util.List;

public class Producto {
	private int id;
    private String nombre, prinAct, marca, lab, presentacion;
    private double precio;
    private Categoria categoria;
    private boolean requiereReceta;
    private boolean activo;
    
    private List<Lote> lotes = new ArrayList<>();

	public Producto(int id, String nombre, String prinAct, String marca, String lab, String presentacion, double precio,
			Categoria categoria, boolean requiereReceta, boolean activo, List<Lote> lotes) {
		this.id = id;
		this.nombre = nombre;
		this.prinAct = prinAct;
		this.marca = marca;
		this.lab = lab;
		this.presentacion = presentacion;
		this.precio = precio;
		this.categoria = categoria;
		this.requiereReceta = requiereReceta;
		this.activo = activo;
		this.lotes = lotes;
	}

	public Producto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrinAct() {
		return prinAct;
	}

	public void setPrinAct(String prinAct) {
		this.prinAct = prinAct;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getLab() {
		return lab;
	}

	public void setLab(String lab) {
		this.lab = lab;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public boolean isRequiereReceta() {
		return requiereReceta;
	}

	public void setRequiereReceta(boolean requiereReceta) {
		this.requiereReceta = requiereReceta;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public List<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
	}
}