package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conector.Conector;
import modelo.bean.Ciudad;

public class ModeloCiudad extends Conector {

	public ArrayList<Ciudad> getCiudades() {
		ArrayList<Ciudad> ciudads = new ArrayList<Ciudad>();
		String query = "Select * from ciudades";

		try {
			Statement st = getCon().createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Ciudad ciudad = new Ciudad();
				ciudad.setId(rs.getInt("idCiudad"));
				ciudad.setNombre(rs.getString("nombre"));
				ciudad.setPoblacion(rs.getInt("poblacion"));
				ciudad.setUbicacionGeografica(rs.getString("ubicacionGeografica"));

				ciudads.add(ciudad);
			}
			rs.close();
			st.close();
			return ciudads;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public Ciudad select(int id) {
		try {
			PreparedStatement st = getCon().prepareStatement("SELECT * from ciudades where idCiudad = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				Ciudad ciudad = new Ciudad();
				ciudad.setId(rs.getInt("idCiudad"));
				ciudad.setNombre(rs.getString("nombre"));
				ciudad.setPoblacion(rs.getInt("poblacion"));
				ciudad.setUbicacionGeografica(rs.getString("ubicacionGeografica"));

				return ciudad;
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public boolean insertCiudad(Ciudad ciudad) {
	    String query = "INSERT INTO ciudades (nombre, poblacion, ubicacionGeografica) VALUES (?, ?, ?)";
	    
	    try {
	        PreparedStatement st = getCon().prepareStatement(query);
	        st.setString(1, ciudad.getNombre());
	        st.setInt(2, ciudad.getPoblacion());
	        st.setString(3, ciudad.getUbicacionGeografica());
	        
	        int rowsInserted = st.executeUpdate();
	        
	        st.close();
	        
	        return rowsInserted > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	public boolean eliminarCiudad(int idCiudad) {
	    String query = "DELETE FROM ciudades WHERE idCiudad = ?";
	    
	    try {
	        PreparedStatement st = getCon().prepareStatement(query);
	        st.setInt(1, idCiudad);
	        
	        int rowsDeleted = st.executeUpdate();
	        
	        st.close();
	        
	        return rowsDeleted > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	
	public boolean editarCiudad(Ciudad ciudad) {
	    String query = "UPDATE ciudades SET nombre = ?, poblacion = ?, ubicacionGeografica = ? WHERE idCiudad = ?";
	    
	    try {
	        PreparedStatement st = getCon().prepareStatement(query);
	        st.setString(1, ciudad.getNombre());
	        st.setInt(2, ciudad.getPoblacion());
	        st.setString(3, ciudad.getUbicacionGeografica());
	        st.setInt(4, ciudad.getId());
	        
	        int rowsUpdated = st.executeUpdate();
	        
	        st.close();
	        
	        return rowsUpdated > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	
}
