package arrayList;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import clase.Categoria;
import clase.Usuario;
import coneccion.ConexionMySQL;

public class ArrayCategoria {
	public ArrayList<Categoria> ListarCategoria() {
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		try {
			CallableStatement csta = ConexionMySQL.getConexion().prepareCall("{call SP_LISTAR_C()}");
			ResultSet rs = csta.executeQuery();
			Categoria cate;
			while(rs.next()) {
				cate = new Categoria(
				        rs.getInt("id"),
				        rs.getString("nombre"),
				        rs.getString("descripcion")
				    );
				lista.add(cate);
			}
			rs.close();
			csta.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public int AgregarCategoria(Categoria cate) {
		
		int estado = 0;
		
		try {
			CallableStatement csta =
		            ConexionMySQL.getConexion().prepareCall(
		                "{call SP_INSERTAR_CATEGORIA(?,?)}"
		            );
			
			csta.setString(1, cate.getNombre());
	        csta.setString(2, cate.getDescripcion());
	        
	        estado = csta.executeUpdate();

	        csta.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return estado;
	}
	
	public int EditarCategoria(Categoria cate) {
		int estado = 0;
		
		try {
			
			CallableStatement csta =
		            ConexionMySQL.getConexion().prepareCall(
		                "{call SP_EDITAR_CATEGORIA(?,?,?)}"
		            );
			
			csta.setInt(1, cate.getId());
	        csta.setString(2, cate.getNombre());
	        csta.setString(3, cate.getDescripcion());
			
			estado = csta.executeUpdate();

	        csta.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return estado;
	}
	
	public Categoria ConsultarCategoriaNombre(String nombre) {
		Categoria cate = null;
		
		try {
			CallableStatement csta =
		            ConexionMySQL.getConexion().prepareCall(
		                "{call SP_CONSULTAR_NOM_CATEGORIA(?)}"
		            );
			
			csta.setString(1, nombre);
			
			ResultSet rs = csta.executeQuery();
			
			if(rs.next()) {

	            cate = new Categoria(
	                rs.getInt("id"),
	                rs.getString("nombre"),
	                rs.getString("descripcion")
	            );
	        }

	        rs.close();
	        csta.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cate;
	}
	
	public int EliminarCategoria(String nombre) {
	    int filas = 0;
	    
	    try {
	        CallableStatement csta =
	                ConexionMySQL.getConexion().prepareCall(
	                    "{call SP_ELIMINAR_CATEGORIA_NOM(?)}"
	                );
	        
	        csta.setString(1, nombre);

	        filas = csta.executeUpdate();

	        csta.close();
	        
	    } catch (java.sql.SQLIntegrityConstraintViolationException e) {
	        // Si el conector de MySQL lanza esta excepción exacta,
	        // significa SÍ O SÍ que la categoría tiene productos amarrados.
	        return -1; 
	        
	    } catch (java.sql.SQLException e) {
	        // Para cualquier otro error de base de datos (conexión, sintaxis, etc.)
	        e.printStackTrace();
	        return 0;
	        
	    } catch (Exception e) {
	        // Para cualquier otro error general de Java
	        e.printStackTrace();
	        return 0;
	    }
	    
	    return filas;
	}
}
