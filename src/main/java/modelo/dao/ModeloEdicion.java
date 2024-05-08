package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conector.Conector;
import modelo.bean.Edicion;

public class ModeloEdicion extends Conector {
	private ModeloCiudad mdc = new ModeloCiudad();
	private ModeloEventoDeportivo mded = new ModeloEventoDeportivo();

	public ArrayList<Edicion> getEdicions() {
		ArrayList<Edicion> edicions = new ArrayList<Edicion>();
		String query = "SELECT * FROM ediciones";

		try {
			Statement st = getCon().createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Edicion edicion = new Edicion();
				edicion.setId(rs.getInt("idEdicion"));
				edicion.setFecha(rs.getDate("fecha"));
				edicion.setCuposDisponibles(rs.getInt("cuposDisponibles"));
				edicion.setEventoDeportivo(mded.select(rs.getInt("idEvento")));
				edicion.setCiudad(mdc.select(rs.getInt("idCiudad")));

				edicions.add(edicion);
			}
			rs.close();
			st.close();
			return edicions;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}
	public ArrayList<Edicion> getEdicionsCiudad(int idCiudad) {
		ArrayList<Edicion> edicions = new ArrayList<Edicion>();
		String query = "SELECT * FROM ediciones where idCiudad = ?";

		try {
			PreparedStatement st = getCon().prepareStatement(query);
			st.setInt(1, idCiudad);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Edicion edicion = new Edicion();
				edicion.setId(rs.getInt("idEdicion"));
				edicion.setFecha(rs.getDate("fecha"));
				edicion.setCuposDisponibles(rs.getInt("cuposDisponibles"));
				edicion.setEventoDeportivo(mded.select(rs.getInt("idEvento")));
				edicion.setCiudad(mdc.select(rs.getInt("idCiudad")));

				edicions.add(edicion);
			}
			rs.close();
			st.close();
			return edicions;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public Edicion select(int id) {
		try {
			PreparedStatement st = getCon().prepareStatement("SELECT * from ediciones where idEdicion = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				Edicion edicion = new Edicion();
				edicion.setId(rs.getInt("idEdicion"));
				edicion.setFecha(rs.getDate("fecha"));
				edicion.setCuposDisponibles(rs.getInt("cuposDisponibles"));
				edicion.setEventoDeportivo(mded.select(rs.getInt("idEvento")));
				edicion.setCiudad(mdc.select(rs.getInt("idCiudad")));

				return edicion;
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	 public boolean crearEdicion(Edicion edicion) {
	        String query = "INSERT INTO ediciones (cuposDisponibles, fecha, idEvento, idCiudad) VALUES (?, ?, ?, ?)";
	        
	        try {
	            PreparedStatement st = getCon().prepareStatement(query);
	            st.setInt(1, edicion.getCuposDisponibles());
	            st.setDate(2, new java.sql.Date(edicion.getFecha().getTime()));
	            st.setInt(3, edicion.getEventoDeportivo().getId());
	            st.setInt(4, edicion.getCiudad().getId());
	            
	            int rowsInserted = st.executeUpdate();
	            
	            st.close();
	            
	            return rowsInserted > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	 
	 
	 
	 public boolean actualizarEdicion(Edicion edicion) {
	        String query = "UPDATE ediciones SET cuposDisponibles = ?, fecha = ?, idEvento = ?, idCiudad = ? WHERE idEdicion = ?";
	        
	        try {
	            PreparedStatement st = getCon().prepareStatement(query);
	            st.setInt(1, edicion.getCuposDisponibles());
	            st.setDate(2, new java.sql.Date(edicion.getFecha().getTime()));
	            st.setInt(3, edicion.getEventoDeportivo().getId());
	            st.setInt(4, edicion.getCiudad().getId());
	            st.setInt(5, edicion.getId());
	            
	            int rowsUpdated = st.executeUpdate();
	            
	            st.close();
	            
	            return rowsUpdated > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    
	    public boolean eliminarEdicion(int idEdicion) {
	        String query = "DELETE FROM ediciones WHERE idEdicion = ?";
	        
	        try {
	            PreparedStatement st = getCon().prepareStatement(query);
	            st.setInt(1, idEdicion);
	            
	            int rowsDeleted = st.executeUpdate();
	            
	            st.close();
	            
	            return rowsDeleted > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
}
