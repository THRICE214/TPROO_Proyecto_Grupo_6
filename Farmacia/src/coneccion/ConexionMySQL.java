package coneccion;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class ConexionMySQL {
	public static Connection getConexion() {
		Connection cnx = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver correcto");
			cnx=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/BD_FARMACIA","root","72651031.LPbpmn");
			System.out.println("conexión correcta");
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		return cnx;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getConexion();
	}

}
