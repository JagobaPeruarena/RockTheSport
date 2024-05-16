package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conector.Conector;
import modelo.bean.Ciudad;
import modelo.bean.Deportes;

public class ModeloDeportes extends Conector {
	public ArrayList<Deportes> getDeportes() {
		ArrayList<Deportes> deportes = new ArrayList<Deportes>();
		String query = "Select * from deportes";

		try {
			Statement st = getCon().createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Deportes deporte = new Deportes();
				deporte.setId(rs.getInt("idDeporte"));
				deporte.setNombre(rs.getString("nombre"));
				

				deportes.add(deporte);
			}
			rs.close();
			st.close();
			return deportes;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}
	public Deportes select(int id) {
		try {
			PreparedStatement st = getCon().prepareStatement("SELECT * from deportes where idDeporte = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				Deportes deporte = new Deportes();
				deporte.setId(rs.getInt("idDeporte"));
				deporte.setNombre(rs.getString("nombre"));
				

				return deporte;
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
}
