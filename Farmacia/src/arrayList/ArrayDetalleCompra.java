package arrayList;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Connection; // Asegúrate de importar Connection
import java.util.ArrayList;

import clase.Categoria;
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
    
    public DetalleCompra obtenerDetalleCompra(int idDetalle) {
        DetalleCompra det = null;

        try (Connection conn = ConexionMySQL.getConexion();
             CallableStatement csta =
                     conn.prepareCall("{call SP_OBTENER_DETALLE_COMPRA(?)}")) {

            csta.setInt(1, idDetalle);

            try (ResultSet rs = csta.executeQuery()) {

                if (rs.next()) {

                    // Usuario
                    Usuario usu = new Usuario();
                    usu.setId(rs.getInt("id_usuario"));
                    usu.setNombre(rs.getString("nombre_usuario"));

                    // Compra
                    Compra com = new Compra();
                    com.setCod(rs.getInt("id_compra"));
                    com.setFecha(rs.getDate("fecha").toLocalDate());
                    com.setEstado(rs.getBoolean("estado"));
                    com.setUsuario(usu);

                    // Producto
                    Producto pro = new Producto();
                    pro.setId(rs.getInt("id_producto"));
                    pro.setNombre(rs.getString("nom_producto"));
                    pro.setPrinAct(rs.getString("prin_act"));
                    pro.setMarca(rs.getString("marca"));
                    pro.setLab(rs.getString("lab"));
                    pro.setPresentacion(rs.getString("presentacion"));
                    pro.setPrecio(rs.getDouble("precio"));
                    pro.setRequiereReceta(rs.getBoolean("requiere_receta"));
                    pro.setActivo(rs.getBoolean("activo"));
                    
                    // Categoria
                    Categoria cat = new Categoria();
                    cat.setId(rs.getInt("id_categoria"));
                    cat.setNombre(rs.getString("nom_categoria"));
                    cat.setDescripcion(rs.getString("descripcion"));

                    pro.setCategoria(cat);

                    // Lote
                    Lote lot = new Lote();
                    lot.setId(rs.getInt("id_lote"));
                    lot.setNumeroLote(rs.getString("numero_lote"));
                    lot.setFechaVencimiento(
                            rs.getDate("fecha_vencimiento").toLocalDate());
                    lot.setStockActual(rs.getInt("stock_actual"));

                    // DetalleCompra
                    det = new DetalleCompra();
                    det.setCod(rs.getInt("id_detalle"));
                    det.setCant(rs.getInt("cant"));
                    det.setCostoUni(rs.getDouble("costo_uni"));

                    det.setCompra(com);
                    det.setPro(pro);
                    det.setLote(lot);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return det;
    }
    
    public double obtenerTotalCompra(int idCompra) {
        double total = 0;

        try (
            Connection conn = ConexionMySQL.getConexion();
            CallableStatement csta =
                    conn.prepareCall("{call SP_TOTAL_COMPRA(?)}")
        ) {

            // Enviamos el parámetro al procedure
            csta.setInt(1, idCompra);

            // Ejecutamos
            try (ResultSet rs = csta.executeQuery()) {

                if (rs.next()) {
                    total = rs.getDouble("total");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return total;
    }
    
    public ArrayList<DetalleCompra> listarDetallesPorFecha(
            java.time.LocalDate fecha) {

        ArrayList<DetalleCompra> lista =
                new ArrayList<DetalleCompra>();

        try (
            Connection conn = ConexionMySQL.getConexion();
            CallableStatement csta =
                conn.prepareCall(
                    "{call SP_LISTAR_DETALLE_COMPRA_FECHA(?)}")
        ) {

            csta.setDate(
                    1,
                    java.sql.Date.valueOf(fecha));

            try (ResultSet rs = csta.executeQuery()) {

                while (rs.next()) {

                    Usuario usu = new Usuario();
                    usu.setNombre(
                            rs.getString(
                                    "nombre_usuario"));

                    Compra com = new Compra();
                    com.setCod(
                            rs.getInt(
                                    "id_compra"));
                    com.setFecha(
                            rs.getDate(
                                    "fecha")
                              .toLocalDate());
                    com.setUsuario(usu);

                    Producto pro = new Producto();
                    pro.setId(
                            rs.getInt(
                                    "id_producto"));
                    pro.setNombre(
                            rs.getString(
                                    "nombre_producto"));

                    Lote lot = new Lote();
                    lot.setNumeroLote(
                            rs.getString(
                                    "numero_lote"));

                    DetalleCompra det =
                            new DetalleCompra();

                    det.setCod(
                            rs.getInt(
                                    "id_detalle"));
                    det.setCant(
                            rs.getInt(
                                    "cant"));
                    det.setCostoUni(
                            rs.getDouble(
                                    "costo_uni"));

                    det.setCompra(com);
                    det.setPro(pro);
                    det.setLote(lot);

                    lista.add(det);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}