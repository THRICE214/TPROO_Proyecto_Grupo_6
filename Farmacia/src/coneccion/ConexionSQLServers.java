package coneccion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionSQLServers {
    
    public static Connection getConexion() {
        Connection cnx = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver correcto");
            
            String url = "jdbc:sqlserver://localhost:1433;databaseName=BD_Botica;encrypt=true;trustServerCertificate=true;";
            String usuario = "sa";
            String contrasena = "NghAle676";
            
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
