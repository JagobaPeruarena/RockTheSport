package conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
	private Connection con;

	public Conector() {
		try {

			

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + Config.HOST + "/" + Config.BBDD, Config.USERNAME, Config.PASSWORD);
			System.out.println("Conexion establecida");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void cerrarConexionBBDD() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
}
