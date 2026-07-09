package arrayList;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import clase.Categoria;
import clase.Producto;
import coneccion.ConexionMySQL;

public class ArrayProducto {
	public ArrayList<Producto> ListarProducto() {

	    ArrayList<Producto> lista =
	            new ArrayList<Producto>();

	    try {

	        CallableStatement csta =
	                ConexionMySQL.getConexion()
	                .prepareCall("{call SP_LISTAR_P()}");

	        ResultSet rs =
	                csta.executeQuery();

	        while(rs.next()) {

	            Categoria cat =
	                    new Categoria();

	            cat.setId(
	                    rs.getInt("id_categoria"));
	            cat.setNombre(
	                    rs.getString("nom_categoria"));

	            Producto pro =
	                    new Producto();

	            pro.setId(
	                    rs.getInt("id"));
	            pro.setNombre(
	                    rs.getString("nombre"));
	            pro.setPrinAct(
	                    rs.getString("prin_act"));
	            pro.setMarca(
	                    rs.getString("marca"));
	            pro.setLab(
	                    rs.getString("lab"));
	            pro.setPresentacion(
	                    rs.getString("presentacion"));
	            pro.setPrecio(
	                    rs.getDouble("precio"));
	            pro.setRequiereReceta(
	                    rs.getBoolean("requiere_receta"));
	            pro.setActivo(
	                    rs.getBoolean("activo"));

	            pro.setCategoria(cat);

	            lista.add(pro);
	        }

	        rs.close();
	        csta.close();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return lista;
	}
	
	public int AgregarProducto(Producto pro) {

	    int estado = 0;

	    try {
	        CallableStatement csta =
	            ConexionMySQL.getConexion().prepareCall(
	                "{call SP_INSERTAR_PRODUCTO(?,?,?,?,?,?,?,?,?)}"
	            );

	        csta.setString(1, pro.getNombre());
	        csta.setString(2, pro.getPrinAct());
	        csta.setString(3, pro.getMarca());
	        csta.setString(4, pro.getLab());
	        csta.setString(5, pro.getPresentacion());
	        csta.setDouble(6, pro.getPrecio());
	        csta.setBoolean(7, pro.isRequiereReceta());
	        csta.setBoolean(8, pro.isActivo());
	        csta.setInt(9, pro.getCategoria().getId());

	        estado = csta.executeUpdate();

	        csta.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return estado;
	}
	
	public ArrayList<Producto> BuscarProductoNombre(String nombre) {

	    ArrayList<Producto> lista =
	            new ArrayList<Producto>();

	    try {

	        CallableStatement csta =
	                ConexionMySQL.getConexion()
	                .prepareCall(
	                    "{call SP_BUSCAR_PRODUCTO_NOMBRE(?)}"
	                );

	        csta.setString(1, nombre);

	        ResultSet rs =
	                csta.executeQuery();

	        while(rs.next()) {

	            Categoria cat =
	                    new Categoria();

	            cat.setId(
	                    rs.getInt("id_categoria"));
	            cat.setNombre(
	                    rs.getString("nom_categoria"));

	            Producto pro =
	                    new Producto();

	            pro.setId(
	                    rs.getInt("id"));
	            pro.setNombre(
	                    rs.getString("nombre"));
	            pro.setPrinAct(
	                    rs.getString("prin_act"));
	            pro.setMarca(
	                    rs.getString("marca"));
	            pro.setLab(
	                    rs.getString("lab"));
	            pro.setPresentacion(
	                    rs.getString("presentacion"));
	            pro.setPrecio(
	                    rs.getDouble("precio"));
	            pro.setRequiereReceta(
	                    rs.getBoolean("requiere_receta"));
	            pro.setActivo(
	                    rs.getBoolean("activo"));

	            pro.setCategoria(cat);

	            lista.add(pro);
	        }

	        rs.close();
	        csta.close();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return lista;
	}
	
	public int EditarProducto(Producto pro) {

	    int estado = 0;

	    try {

	        CallableStatement csta =
	            ConexionMySQL.getConexion().prepareCall(
	                "{call SP_EDITAR_PRODUCTO(?,?,?,?,?,?,?,?,?,?)}"
	            );

	        csta.setInt(1, pro.getId());
	        csta.setString(2, pro.getNombre());
	        csta.setString(3, pro.getPrinAct());
	        csta.setString(4, pro.getMarca());
	        csta.setString(5, pro.getLab());
	        csta.setString(6, pro.getPresentacion());
	        csta.setDouble(7, pro.getPrecio());
	        csta.setBoolean(8, pro.isRequiereReceta());
	        csta.setBoolean(9, pro.isActivo());
	        csta.setInt(10, pro.getCategoria().getId());

	        estado = csta.executeUpdate();

	        csta.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return estado;
	}
	
	public int DeshabilitarProducto(int id) {
	    int estado = 0;
	    try {
	        CallableStatement csta = 
	            ConexionMySQL.getConexion().prepareCall(
	                "{call SP_DESHABILITAR_PRODUCTO(?)}"
	            );
	            
	        csta.setInt(1, id);
	        
	        estado = csta.executeUpdate();
	        csta.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return estado;
	}
	
	public ArrayList<Producto> ListarProductoActivo() {

	    ArrayList<Producto> lista = new ArrayList<>();

	    try {

	        CallableStatement cs =
	            ConexionMySQL.getConexion()
	            .prepareCall("{call SP_LISTAR_PRODUCTOS_ACTIVOS()}");

	        ResultSet rs = cs.executeQuery();

	        while (rs.next()) {

	            Categoria c = new Categoria();
	            c.setId(rs.getInt("id_categoria"));
	            c.setNombre(rs.getString("categoria"));

	            Producto p = new Producto();

	            p.setId(rs.getInt("id"));
	            p.setNombre(rs.getString("nombre"));
	            p.setPresentacion(rs.getString("presentacion"));
	            p.setPrecio(rs.getDouble("precio"));
	            p.setActivo(rs.getBoolean("activo"));
	            p.setCategoria(c);

	            lista.add(p);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return lista;
	}
	
	public int EditarProductoInfo(Producto pro) {

		int filas = 0;

		Connection cn = null;
		CallableStatement cs = null;

		try {
			cn = ConexionMySQL.getConexion();

			cs = cn.prepareCall("{CALL SP_EDITAR_PRODUCTO_INFO(?, ?, ?, ?, ?, ?, ?, ?)}");

			cs.setInt(1, pro.getId());
			cs.setString(2, pro.getNombre());
			cs.setString(3, pro.getPrinAct());
			cs.setString(4, pro.getMarca());
			cs.setString(5, pro.getLab());
			cs.setString(6, pro.getPresentacion());
			cs.setBoolean(7, pro.isRequiereReceta());
			cs.setInt(8, pro.getCategoria().getId());

			filas = cs.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			filas = -1;
		} finally {
			try { if (cs != null) cs.close(); } catch (Exception e) {}
			try { if (cn != null) cn.close(); } catch (Exception e) {}
		}

		return filas;
	}
}
