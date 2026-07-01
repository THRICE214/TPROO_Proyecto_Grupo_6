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
	    PreparedStatement psCompra = null, psLote = null, psDetalle = null;
	    ResultSet rs = null;

	    try {
	        cn = ConexionMySQL.getConexion();
	        cn.setAutoCommit(false); // INICIO DE TRANSACCIÓN: Nada se guarda hasta el final

	        // 1. Insertar Cabecera de Compra
	        String sqlCompra = "INSERT INTO compra (fecha, estado, id_usuario) VALUES (?, ?, ?)";
	        psCompra = cn.prepareStatement(sqlCompra, PreparedStatement.RETURN_GENERATED_KEYS);
	        psCompra.setDate(1, java.sql.Date.valueOf(compra.getFecha()));
	        psCompra.setBoolean(2, true);
	        psCompra.setInt(3, SesionUsuario.getInstancia().getUsuarioLogueado().getId());
	        psCompra.executeUpdate();

	        rs = psCompra.getGeneratedKeys();
	        int idCompra = rs.next() ? rs.getInt(1) : 0;

	        // 2. Insertar Lotes y Detalles
	        for (DetalleCompra dc : compra.getDetCom()) {
	            // A. Insertar Lote
	            String sqlLote = "INSERT INTO lote (numero_lote, fecha_vencimiento, stock_actual, id_producto) VALUES (?, ?, ?, ?)";
	            psLote = cn.prepareStatement(sqlLote, PreparedStatement.RETURN_GENERATED_KEYS);
	            psLote.setString(1, dc.getLote().getNumeroLote());
	            psLote.setDate(2, java.sql.Date.valueOf(dc.getLote().getFechaVencimiento()));
	            psLote.setInt(3, dc.getLote().getStockActual());
	            psLote.setInt(4, dc.getPro().getId());
	            psLote.executeUpdate();

	            ResultSet rsLote = psLote.getGeneratedKeys();
	            int idLote = rsLote.next() ? rsLote.getInt(1) : 0;

	            // B. Insertar Detalle
	            String sqlDetalle = "INSERT INTO detalle_compra (cant, costo_uni, id_compra, id_producto, id_lote) VALUES (?, ?, ?, ?, ?)";
	            psDetalle = cn.prepareStatement(sqlDetalle);
	            psDetalle.setInt(1, dc.getCant());
	            psDetalle.setDouble(2, dc.getCostoUni());
	            psDetalle.setInt(3, idCompra);
	            psDetalle.setInt(4, dc.getPro().getId());
	            psDetalle.setInt(5, idLote);
	            psDetalle.executeUpdate();
	        }

	        cn.commit(); // ÉXITO: Guardamos todo
	        return true;

	    } catch (Exception e) {
	        try { if (cn != null) cn.rollback(); } catch (Exception ex) { ex.printStackTrace(); }
	        e.printStackTrace();
	        return false;
	    }
	}
}