package arrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.util.ArrayList;

import clase.Categoria;
import clase.DetalleVenta;
import clase.Lote;
import clase.Producto;
import clase.Usuario;
import clase.Venta;
import coneccion.ConexionMySQL;

public class ArrayVenta {

	public int registrarVentaCompleta(Venta venta) {

		Connection cn = null;
		PreparedStatement psVenta = null;
		PreparedStatement psDetalle = null;
		PreparedStatement psStock = null;
		ResultSet rs = null;

		try {
			cn = ConexionMySQL.getConexion();
			cn.setAutoCommit(false);

			// 1. Insertar cabecera de venta
			String sqlVenta =
					"INSERT INTO venta (fecha, id_usuario) VALUES (?, ?)";

			psVenta = cn.prepareStatement(
					sqlVenta,
					PreparedStatement.RETURN_GENERATED_KEYS
			);

			psVenta.setDate(1, java.sql.Date.valueOf(venta.getFecha()));
			psVenta.setInt(2, venta.getUsuario().getId());

			psVenta.executeUpdate();

			rs = psVenta.getGeneratedKeys();

			int idVenta = 0;

			if (rs.next()) {
				idVenta = rs.getInt(1);
			} else {
				throw new Exception("No se pudo obtener el ID de la venta.");
			}

			// 2. Insertar detalles y descontar stock
			for (DetalleVenta dv : venta.getDetVen()) {

				String sqlDetalle =
						"INSERT INTO detalle_venta " +
						"(cant, precio_unitario, id_venta, id_producto, id_lote) " +
						"VALUES (?, ?, ?, ?, ?)";

				psDetalle = cn.prepareStatement(sqlDetalle);

				psDetalle.setInt(1, dv.getCant());
				psDetalle.setDouble(2, dv.getPrecioUni());
				psDetalle.setInt(3, idVenta);
				psDetalle.setInt(4, dv.getPro().getId());
				psDetalle.setInt(5, dv.getLote().getId());

				psDetalle.executeUpdate();

				String sqlStock =
						"UPDATE lote " +
						"SET stock_actual = stock_actual - ? " +
						"WHERE id = ? AND stock_actual >= ?";

				psStock = cn.prepareStatement(sqlStock);

				psStock.setInt(1, dv.getCant());
				psStock.setInt(2, dv.getLote().getId());
				psStock.setInt(3, dv.getCant());

				int filasAfectadas = psStock.executeUpdate();

				if (filasAfectadas == 0) {
					throw new Exception(
							"Stock insuficiente en el lote: " +
							dv.getLote().getNumeroLote()
					);
				}
			}

			cn.commit();
			return idVenta;

		} catch (Exception e) {

			try {
				if (cn != null) {
					cn.rollback();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			e.printStackTrace();
			return -1;

		} finally {

			try { if (rs != null) rs.close(); } catch (Exception e) {}
			try { if (psVenta != null) psVenta.close(); } catch (Exception e) {}
			try { if (psDetalle != null) psDetalle.close(); } catch (Exception e) {}
			try { if (psStock != null) psStock.close(); } catch (Exception e) {}

			try {
				if (cn != null) {
					cn.setAutoCommit(true);
					cn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<DetalleVenta> listarDetallesVenta() {

		ArrayList<DetalleVenta> lista = new ArrayList<>();

		Connection cn = null;
		CallableStatement cs = null;
		ResultSet rs = null;

		try {
			cn = ConexionMySQL.getConexion();
			cs = cn.prepareCall("{CALL SP_LISTAR_DETALLE_VENTA()}");
			rs = cs.executeQuery();

			while (rs.next()) {

				Usuario usuario = new Usuario();
				usuario.setNombre(rs.getString("nombre_usuario"));

				Venta venta = new Venta();
				venta.setCod(rs.getInt("id_venta"));
				venta.setFecha(rs.getDate("fecha").toLocalDate());
				venta.setUsuario(usuario);

				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("id_categoria"));
				categoria.setNombre(rs.getString("nombre_categoria"));

				Producto producto = new Producto();
				producto.setId(rs.getInt("id_producto"));
				producto.setNombre(rs.getString("nombre_producto"));
				producto.setPresentacion(rs.getString("presentacion"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setCategoria(categoria);

				Lote lote = new Lote();
				lote.setId(rs.getInt("id_lote"));
				lote.setNumeroLote(rs.getString("numero_lote"));
				lote.setFechaVencimiento(rs.getDate("fecha_vencimiento").toLocalDate());
				lote.setStockActual(rs.getInt("stock_actual"));
				lote.setPro(producto);

				DetalleVenta detalle = new DetalleVenta();
				detalle.setCod(rs.getInt("id_detalle"));
				detalle.setCant(rs.getInt("cant"));
				detalle.setPrecioUni(rs.getDouble("precio_unitario"));
				detalle.setVenta(venta);
				detalle.setPro(producto);
				detalle.setLote(lote);

				lista.add(detalle);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (Exception e) {}
			try { if (cs != null) cs.close(); } catch (Exception e) {}
			try { if (cn != null) cn.close(); } catch (Exception e) {}
		}

		return lista;
	}
	
	public ArrayList<DetalleVenta> listarDetallesVentaPorFecha(java.time.LocalDate fecha) {

		ArrayList<DetalleVenta> lista = new ArrayList<>();

		Connection cn = null;
		CallableStatement cs = null;
		ResultSet rs = null;

		try {
			cn = ConexionMySQL.getConexion();
			cs = cn.prepareCall("{CALL SP_LISTAR_DETALLE_VENTA_FECHA(?)}");

			cs.setDate(1, java.sql.Date.valueOf(fecha));

			rs = cs.executeQuery();

			while (rs.next()) {

				Usuario usuario = new Usuario();
				usuario.setNombre(rs.getString("nombre_usuario"));

				Venta venta = new Venta();
				venta.setCod(rs.getInt("id_venta"));
				venta.setFecha(rs.getDate("fecha").toLocalDate());
				venta.setUsuario(usuario);

				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("id_categoria"));
				categoria.setNombre(rs.getString("nombre_categoria"));

				Producto producto = new Producto();
				producto.setId(rs.getInt("id_producto"));
				producto.setNombre(rs.getString("nombre_producto"));
				producto.setPresentacion(rs.getString("presentacion"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setCategoria(categoria);

				Lote lote = new Lote();
				lote.setId(rs.getInt("id_lote"));
				lote.setNumeroLote(rs.getString("numero_lote"));
				lote.setFechaVencimiento(rs.getDate("fecha_vencimiento").toLocalDate());
				lote.setStockActual(rs.getInt("stock_actual"));
				lote.setPro(producto);

				DetalleVenta detalle = new DetalleVenta();
				detalle.setCod(rs.getInt("id_detalle"));
				detalle.setCant(rs.getInt("cant"));
				detalle.setPrecioUni(rs.getDouble("precio_unitario"));
				detalle.setVenta(venta);
				detalle.setPro(producto);
				detalle.setLote(lote);

				lista.add(detalle);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (Exception e) {}
			try { if (cs != null) cs.close(); } catch (Exception e) {}
			try { if (cn != null) cn.close(); } catch (Exception e) {}
		}

		return lista;
	}
}