package clase;

public class Usuario {
	private int id;
	private String nombre, tipoDocumento, documento, direccion, email, telefono;
	private boolean estado, admin;
	
	public Usuario(int id, String nombre, String tipoDocumento, String documento, String direccion, String email,
			String telefono, boolean estado, boolean admin) {
		this.id = id;
		this.nombre = nombre;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.estado = estado;
		this.admin = admin;
	}

	public Usuario() {
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

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
