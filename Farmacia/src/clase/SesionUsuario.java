package clase;

public class SesionUsuario {
	// 1. La única instancia de la sesión que existirá en memoria
    private static SesionUsuario instancia;
    
    // 2. Aquí guardamos al objeto Usuario que logró loguearse
    private Usuario usuarioLogueado;

    // 3. El constructor PRIVADO impide que otras clases hagan "new SesionUsuario()" por error
    private SesionUsuario() {}

    // 4. Método global para obtener la sesión desde cualquier parte del programa
    public static SesionUsuario getInstancia() {
        if (instancia == null) {
            instancia = new SesionUsuario();
        }
        return instancia;
    }

    // 5. Métodos prácticos para controlar la sesión
    public void iniciarSesion(Usuario usuario) {
        this.usuarioLogueado = usuario;
    }

    public Usuario getUsuarioLogueado() {
        return this.usuarioLogueado;
    }

    public void cerrarSesion() {
        this.usuarioLogueado = null;
    }
}
