package arrayList;

import java.sql.CallableStatement;
import java.util.ArrayList;

import java.sql.ResultSet;

import clase.Usuario;
import coneccion.ConexionMySQL;

public class ArrayUsuario {
	public ArrayList<Usuario> ListarUsuario() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		try {
			CallableStatement csta = ConexionMySQL.getConexion().prepareCall("{call SP_LISTAR()}");
			ResultSet rs = csta.executeQuery();
			Usuario usu;
			while(rs.next()) {
				usu = new Usuario(
				        rs.getInt("id"),
				        rs.getString("nombre"),
				        rs.getString("email"),
				        rs.getString("password"),
				        rs.getString("tipo_documento"),
				        rs.getString("documento"),
				        rs.getString("direccion"),
				        rs.getString("telefono"),
				        rs.getBoolean("estado"),
				        rs.getBoolean("admin")
				    );
				lista.add(usu);
			}
			rs.close();
			csta.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public int EditarUsuario(Usuario usu) {

	    int estado = 0;

	    try {

	        CallableStatement csta =
	            ConexionMySQL.getConexion().prepareCall(
	                "{call SP_EDITAR_USUARIO(?,?,?,?,?,?,?,?,?,?)}"
	            );

	        csta.setInt(1, usu.getId());
	        csta.setString(2, usu.getNombre());
	        csta.setString(3, usu.getEmail());
	        csta.setString(4, usu.getPassword());
	        csta.setString(5, usu.getTipoDocumento());
	        csta.setString(6, usu.getDocumento());
	        csta.setString(7, usu.getDireccion());
	        csta.setString(8, usu.getTelefono());
	        csta.setBoolean(9, usu.isEstado());
	        csta.setBoolean(10, usu.isAdmin());

	        estado = csta.executeUpdate();

	        csta.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return estado;
	}
	
	public int AgregarUsuario(Usuario usu) {

	    int estado = 0;

	    try {

	        CallableStatement csta =
	            ConexionMySQL.getConexion().prepareCall(
	                "{call SP_INSERTAR_USUARIO(?,?,?,?,?,?,?,?,?)}"
	            );

	        csta.setString(1, usu.getNombre());
	        csta.setString(2, usu.getEmail());
	        csta.setString(3, usu.getPassword());
	        csta.setString(4, usu.getTipoDocumento());
	        csta.setString(5, usu.getDocumento());
	        csta.setString(6, usu.getDireccion());
	        csta.setString(7, usu.getTelefono());
	        csta.setBoolean(8, usu.isEstado());
	        csta.setBoolean(9, usu.isAdmin());

	        estado = csta.executeUpdate();

	        csta.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return estado;
	}
	
	public Usuario ConsultarUsuarioDNI(String documento) {

	    Usuario usu = null;

	    try {

	        CallableStatement csta =
	            ConexionMySQL.getConexion().prepareCall(
	                "{call SP_CONSULTAR_DNI_USUARIO(?)}"
	            );

	        csta.setString(1, documento);

	        ResultSet rs = csta.executeQuery();

	        if(rs.next()) {

	            usu = new Usuario(
	                rs.getInt("id"),
	                rs.getString("nombre"),
	                rs.getString("email"),
	                rs.getString("password"),
	                rs.getString("tipo_documento"),
	                rs.getString("documento"),
	                rs.getString("direccion"),
	                rs.getString("telefono"),
	                rs.getBoolean("estado"),
	                rs.getBoolean("admin")
	            );
	        }

	        rs.close();
	        csta.close();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return usu;
	}
	
	public int DesactivarUsuario(String documento) {

	    int estado = 0;

	    try {

	        CallableStatement csta =
	            ConexionMySQL.getConexion()
	                .prepareCall(
	                    "{call SP_DESACTIVAR_USUARIO(?)}"
	                );

	        csta.setString(1, documento);

	        estado = csta.executeUpdate();

	        csta.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return estado;
	}
	
	public Usuario ConsultarUsuarioEmail(String email) {
	    Usuario usu = null;
	    try {
	        // 1. Nos conectamos y preparamos la llamada al nuevo procedimiento de MySQL
	        CallableStatement csta = ConexionMySQL.getConexion().prepareCall(
	            "{call SP_CONSULTAR_EMAIL_USUARIO(?)}"
	        );

	        // 2. Le pasamos el email que el usuario escribió en el Login
	        csta.setString(1, email);

	        // 3. Ejecutamos la consulta y recibimos el resultado
	        ResultSet rs = csta.executeQuery();

	        // 4. Si la base de datos encontró al usuario, extraemos sus datos y creamos el objeto
	        if(rs.next()) {
	            usu = new Usuario(
	                rs.getInt("id"),
	                rs.getString("nombre"),
	                rs.getString("email"),
	                rs.getString("password"),
	                rs.getString("tipo_documento"),
	                rs.getString("documento"),
	                rs.getString("direccion"),
	                rs.getString("telefono"),
	                rs.getBoolean("estado"),
	                rs.getBoolean("admin")
	            );
	        }

	        // 5. Cerramos los flujos por seguridad
	        rs.close();
	        csta.close();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    
	    // Si lo encontró, devuelve el usuario completo; si no existe, devuelve null
	    return usu;
	}
}
