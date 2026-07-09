package arrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import clase.Compra;
import clase.DetalleCompra;
import clase.SesionUsuario;
import coneccion.ConexionMySQL;

public class ArrayCompra {

	public ArrayList<Object[]> listarDetallesHistorial() {
	    ArrayList<Object[]> lista = new ArrayList<>();
	    String sql = "SELECT c.cod, c.fecha, u.nombre AS usuario, p.nombre AS producto, " +
	                 "dc.cant, dc.costo_uni, (dc.cant * dc.costo_uni) AS subtotal, l.numero_lote " +
	                 "FROM detalle_compra dc " +
	                 "JOIN compra c ON dc.id_compra = c.cod " +
	                 "JOIN usuario u ON c.id_usuario = u.id " +
	                 "JOIN producto p ON dc.id_producto = p.id " +
	                 "JOIN lote l ON dc.id_lote = l.id " +
	                 "ORDER BY c.cod DESC";

	    try (Connection cn = ConexionMySQL.getConexion();
	         PreparedStatement ps = cn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {
	        
	        while (rs.next()) {
	            lista.add(new Object[] {
	                rs.getInt("cod"),
	                rs.getDate("fecha"),
	                rs.getString("usuario"),
	                rs.getString("producto"),
	                rs.getInt("cant"),
	                String.format("%.2f", rs.getDouble("costo_uni")),
	                String.format("%.2f", rs.getDouble("subtotal")),
	                rs.getString("numero_lote")
	            });
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return lista;
	}
	
	public boolean registrarCompraCompleta(Compra compra) {
		Connection cn = null;
		PreparedStatement psCompra = null;
		ResultSet rs = null;

		try {
			cn = ConexionMySQL.getConexion();
			cn.setAutoCommit(false);

			// 1. Insertar cabecera de compra
			String sqlCompra =
					"INSERT INTO compra (fecha, estado, id_usuario) VALUES (?, ?, ?)";

			psCompra = cn.prepareStatement(
					sqlCompra,
					Statement.RETURN_GENERATED_KEYS
			);

			psCompra.setDate(1, java.sql.Date.valueOf(compra.getFecha()));
			psCompra.setBoolean(2, true);
			psCompra.setInt(
					3,
					SesionUsuario.getInstancia()
							.getUsuarioLogueado()
							.getId()
			);

			psCompra.executeUpdate();

			rs = psCompra.getGeneratedKeys();

			int idCompra = 0;

			if (rs.next()) {
				idCompra = rs.getInt(1);
			}

			if (idCompra == 0) {
				throw new Exception("No se pudo obtener el ID de la compra.");
			}

			// 2. Insertar detalles, lotes, productos/categorías nuevas
			for (DetalleCompra dc : compra.getDetCom()) {

				// A. Si la categoría es nueva, registrarla primero
				if (dc.getPro().getCategoria().getId() == 0) {
					int idCategoriaNueva =
							insertarCategoriaYRetornarId(
									cn,
									dc.getPro().getCategoria()
							);

					dc.getPro()
					  .getCategoria()
					  .setId(idCategoriaNueva);
				}

				// B. Si el producto es nuevo, registrarlo antes del lote
				if (dc.getPro().getId() == 0) {
					int idProductoNuevo =
							insertarProductoYRetornarId(
									cn,
									dc.getPro()
							);

					dc.getPro().setId(idProductoNuevo);
				}

				// C. Insertar lote
				int idLote =
						insertarLoteYRetornarId(
								cn,
								dc
						);

				dc.getLote().setId(idLote);

				// D. Insertar detalle de compra
				insertarDetalleCompra(
						cn,
						dc,
						idCompra,
						idLote
				);

				// E. Actualizar precio de venta del producto
				actualizarPrecioProducto20(
						cn,
						dc.getPro().getId()
				);
			}

			cn.commit();
			return true;

		} catch (Exception e) {
			try {
				if (cn != null) {
					cn.rollback();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			e.printStackTrace();
			return false;

		} finally {
			try {
				if (rs != null) rs.close();
			} catch (Exception e) {}

			try {
				if (psCompra != null) psCompra.close();
			} catch (Exception e) {}

			try {
				if (cn != null) cn.close();
			} catch (Exception e) {}
		}
	}
	
	private int insertarCategoriaYRetornarId(
			Connection cn,
			clase.Categoria categoria
	) throws Exception {

		String sql =
				"INSERT INTO categoria (nombre, descripcion) VALUES (?, ?)";

		try (PreparedStatement ps = cn.prepareStatement(
				sql,
				Statement.RETURN_GENERATED_KEYS
		)) {
			ps.setString(1, categoria.getNombre());
			ps.setString(2, categoria.getDescripcion());

			ps.executeUpdate();

			try (ResultSet rs = ps.getGeneratedKeys()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
		}

		throw new Exception("No se pudo obtener el ID de la categoría nueva.");
	}
	
	private int insertarProductoYRetornarId(
			Connection cn,
			clase.Producto producto
	) throws Exception {

		String sql =
				"INSERT INTO producto " +
				"(nombre, prin_act, marca, lab, presentacion, precio, requiere_receta, activo, id_categoria) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement ps = cn.prepareStatement(
				sql,
				Statement.RETURN_GENERATED_KEYS
		)) {
			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getPrinAct());
			ps.setString(3, producto.getMarca());
			ps.setString(4, producto.getLab());
			ps.setString(5, producto.getPresentacion());

			// Precio temporal. Luego se actualiza con el costo del lote + 20%.
			ps.setDouble(6, 0);

			ps.setBoolean(7, producto.isRequiereReceta());
			ps.setBoolean(8, producto.isActivo());
			ps.setInt(9, producto.getCategoria().getId());

			ps.executeUpdate();

			try (ResultSet rs = ps.getGeneratedKeys()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
		}

		throw new Exception("No se pudo obtener el ID del producto nuevo.");
	}
	
	private int insertarLoteYRetornarId(
			Connection cn,
			DetalleCompra dc
	) throws Exception {

		String sql =
				"INSERT INTO lote " +
				"(numero_lote, fecha_vencimiento, stock_actual, id_producto) " +
				"VALUES (?, ?, ?, ?)";

		try (PreparedStatement ps = cn.prepareStatement(
				sql,
				Statement.RETURN_GENERATED_KEYS
		)) {
			ps.setString(1, dc.getLote().getNumeroLote());
			ps.setDate(
					2,
					java.sql.Date.valueOf(
							dc.getLote().getFechaVencimiento()
					)
			);
			ps.setInt(3, dc.getLote().getStockActual());
			ps.setInt(4, dc.getPro().getId());

			ps.executeUpdate();

			try (ResultSet rs = ps.getGeneratedKeys()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
		}

		throw new Exception("No se pudo obtener el ID del lote.");
	}
	
	private void insertarDetalleCompra(
			Connection cn,
			DetalleCompra dc,
			int idCompra,
			int idLote
	) throws Exception {

		String sql =
				"INSERT INTO detalle_compra " +
				"(cant, costo_uni, id_compra, id_producto, id_lote) " +
				"VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement ps = cn.prepareStatement(sql)) {
			ps.setInt(1, dc.getCant());
			ps.setDouble(2, dc.getCostoUni());
			ps.setInt(3, idCompra);
			ps.setInt(4, dc.getPro().getId());
			ps.setInt(5, idLote);

			ps.executeUpdate();
		}
	}
	
	private void actualizarPrecioProducto20(
			Connection cn,
			int idProducto
	) throws Exception {

		String sql =
				"CALL SP_ACTUALIZAR_PRECIO_PRODUCTO_20(?)";

		try (PreparedStatement ps = cn.prepareStatement(sql)) {
			ps.setInt(1, idProducto);
			ps.executeUpdate();
		}
	}
}