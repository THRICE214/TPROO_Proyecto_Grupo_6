package arrayList;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Connection; // Asegúrate de importar Connection
import java.util.ArrayList;

import clase.Compra;
import clase.DetalleCompra;
import clase.Lote;
import clase.Producto;
import clase.Usuario;
import coneccion.ConexionMySQL;

public class ArrayDetalleCompra {

    public ArrayList<DetalleCompra> ListarDetalles() {
        ArrayList<DetalleCompra> lista = new ArrayList<DetalleCompra>();

        // El try-with-resources abre la conexión y cierra los recursos automáticamente
        try (Connection conn = ConexionMySQL.getConexion();
             CallableStatement csta = conn.prepareCall("{call SP_LISTAR_DETALLE_COMPRA()}");
             ResultSet rs = csta.executeQuery()) {

            while (rs.next()) {
                // 1. Instanciamos los objetos necesarios
                Usuario usu = new Usuario();
                usu.setNombre(rs.getString("nombre_usuario"));

                Compra com = new Compra();
                com.setCod(rs.getInt("id_compra"));
                com.setFecha(rs.getDate("fecha").toLocalDate());
                com.setUsuario(usu);

                Producto pro = new Producto();
                pro.setId(rs.getInt("id_producto"));
                pro.setNombre(rs.getString("nombre_producto"));

                Lote lot = new Lote();
                lot.setNumeroLote(rs.getString("numero_lote"));

                // 2. Instanciamos el detalle y asignamos
                DetalleCompra det = new DetalleCompra();
                det.setCod(rs.getInt("id_detalle"));
                det.setCant(rs.getInt("cant"));
                det.setCostoUni(rs.getDouble("costo_uni"));
                
                det.setCompra(com);
                det.setPro(pro);
                det.setLote(lot);

                lista.add(det);
            }
        } catch (Exception e) {
            // Solo imprimimos el error en consola para depurar
            e.printStackTrace();
        }
        // Si hay error, devuelve la lista vacía (como querías, sin mensajes extra)
        return lista;
    }
}