package coneccion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionSQLServers {
    
    public static Connection getConexion() {
        Connection cnx = null;
        try {
            // 1. Nuevo Driver de SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver correcto");
            
            // 2. Nueva URL de conexión con el puerto 1433
            // Nota: Se añaden encrypt y trustServerCertificate para evitar errores de conexión modernos
            String url = "jdbc:sqlserver://localhost:1433;databaseName=BD_Botica;encrypt=true;trustServerCertificate=true;";
            String usuario = "sa"; // Asegúrate de que sea tu usuario de SQL Server
            String contrasena = "NghAle676"; // Mantengo la contraseña que tenías en la captura
            
            cnx = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexión correcta a SQL Server");
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return cnx;
    }

    public static void main(String[] args) {
        getConexion();
    }
}
