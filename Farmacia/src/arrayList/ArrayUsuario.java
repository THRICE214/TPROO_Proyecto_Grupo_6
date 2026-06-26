package arrayList;

import java.sql.CallableStatement;
import java.util.ArrayList;

import java.sql.ResultSet;

import clase.Usuario;
import coneccion.ConexionSQLServers;

public class ArrayUsuario {
	public ArrayList<Usuario> ListarUsuario() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		try {
			CallableStatement csta = ConexionSQLServers.getConexion().prepareCall("{call SP_LISTAR()}");
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
	        	ConexionSQLServers.getConexion().prepareCall(
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
	        	ConexionSQLServers.getConexion().prepareCall(
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
	        	ConexionSQLServers.getConexion().prepareCall(
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
	
	public int EliminarUsuario(String documento) {

	    int filas = 0;

	    try {

	        CallableStatement csta =
	        	ConexionSQLServers.getConexion().prepareCall(
	                "{call SP_ELIMINAR_USUARIO_DOC(?)}"
	            );

	        csta.setString(1, documento);

	        filas = csta.executeUpdate();

	        csta.close();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return filas;
	}
}
