package arrayList;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import clase.Producto;

import clase.Lote;
import coneccion.ConexionMySQL;

public class ArrayLote {
	public ArrayList<Lote> listarLotesProducto(int idProducto) {

	    ArrayList<Lote> lista = new ArrayList<>();

	    try (
	        Connection cn = ConexionMySQL.getConexion();
	        CallableStatement cs = cn.prepareCall("{CALL SP_LISTAR_LOTES_PRODUCTO(?)}")
	    ) {

	        cs.setInt(1, idProducto);

	        ResultSet rs = cs.executeQuery();

	        while (rs.next()) {

	        	Lote lote = new Lote();

	        	lote.setId(rs.getInt("id"));
	        	lote.setNumeroLote(rs.getString("numero_lote"));
	        	lote.setFechaVencimiento(
	        	        rs.getDate("fecha_vencimiento").toLocalDate());
	        	lote.setStockActual(rs.getInt("stock_actual"));

	        	// Producto asociado
	        	Producto p = new Producto();
	        	p.setId(rs.getInt("id_producto"));
	        	p.setNombre(rs.getString("nombre"));

	        	lote.setPro(p);

	        	lista.add(lote);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return lista;
	}
}