package clase;

public class Medicamento {
	private String pro;
	private String cod;
	private String tipo;
	private double precio;
	private String user;

	

	   public Medicamento(String producto, String codigo, String tipo, double precio, String usuario) {
	        this.pro = producto;
	        this.cod= codigo;
	        this.tipo = tipo;
	        this.precio = precio;
	        this.user = usuario;
	    }
	
	public String getCod() {
		return cod;
	}
	public String getTipo() {
		return tipo;
	}
	public  double getPrecio() {
		return precio;
	}
	
	public String getUser() {
		return user;
	}

	public Object[] toFila() {
		return new Object[] { pro, cod, tipo, precio, user};
	}
	
}
