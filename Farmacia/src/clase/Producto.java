package clase;

import java.util.ArrayList;
import java.util.List;

public class Producto {
	private int id;
    private String nombre;
    private double precio;
    
    private Categoria categoria;
    
    private List<Lote> lotes = new ArrayList<>();
    
    //Constructores
    public Producto(int id, String nombre, double precio, Categoria categoria, List<Lote> lotes) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
		this.lotes = lotes;
	}

	public Producto() {
	}

	//Metodos
	public int getStockTotal() {
        int total = 0;

        for (Lote lote : lotes) {
            total += lote.getCantidad();
        }

        return total;
    }

	//Get's y Set's
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

	public List<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
	}
}
