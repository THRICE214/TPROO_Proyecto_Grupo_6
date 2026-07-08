package arrayList;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import coneccion.ConexionMySQL;

public class ArrayMovimiento {
	
	/*se usa una clase object para en un solo objeto creado para Movimientos, 
	poner todos los datos y dsps facilitar el traspaso de datos a la tabla, el
	filtrado no necesita procesos pre calculados como al crear para llenar la db*/
	public ArrayList<Object[]> listarMovimientosCompras() {

		ArrayList<Object[]> lista = new ArrayList<>();

		Connection cn = null;
		CallableStatement cs = null;
		ResultSet rs = null;

		try {
			cn = ConexionMySQL.getConexion();
			cs = cn.prepareCall("{CALL SP_MOVIMIENTOS_COMPRAS()}");
			rs = cs.executeQuery();

			while (rs.next()) {

				Object[] fila = {
						rs.getInt("id_compra"),
						rs.getDate("fecha").toLocalDate(),
						rs.getDouble("total_compra"),

						rs.getInt("id_detalle"),
						rs.getInt("cant"),
						rs.getDouble("costo_uni"),
						rs.getDouble("subtotal"),

						rs.getInt("id_producto"),
						rs.getString("nombre_producto"),
						rs.getDouble("precio_actual"),
						rs.getString("marca"),
						rs.getString("lab"),
						rs.getString("nombre_categoria"),

						rs.getInt("id_lote"),
						rs.getString("numero_lote"),
						rs.getDate("fecha_vencimiento").toLocalDate(),
						rs.getInt("stock_actual"),

						rs.getInt("id_usuario"),
						rs.getString("nombre_usuario")
				};

				lista.add(fila);
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

	public ArrayList<Object[]> listarMovimientosVentas() {

		ArrayList<Object[]> lista = new ArrayList<>();

		Connection cn = null;
		CallableStatement cs = null;
		ResultSet rs = null;

		try {
			cn = ConexionMySQL.getConexion();
			cs = cn.prepareCall("{CALL SP_MOVIMIENTOS_VENTAS()}");
			rs = cs.executeQuery();

			while (rs.next()) {

				Object[] fila = {
						rs.getInt("id_venta"),
						rs.getDate("fecha").toLocalDate(),
						rs.getDouble("total_venta"),

						rs.getInt("id_detalle"),
						rs.getInt("cant"),
						rs.getDouble("precio_unitario"),
						rs.getDouble("subtotal"),

						rs.getInt("id_producto"),
						rs.getString("nombre_producto"),
						rs.getDouble("precio_actual"),
						rs.getString("marca"),
						rs.getString("lab"),
						rs.getString("nombre_categoria"),

						rs.getInt("id_lote"),
						rs.getString("numero_lote"),
						rs.getDate("fecha_vencimiento").toLocalDate(),
						rs.getInt("stock_actual"),

						rs.getInt("id_usuario"),
						rs.getString("nombre_usuario")
				};

				lista.add(fila);
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