package modelo.dao;

import java.util.ArrayList;
import java.sql.*;
import conector.Conector;
import modelo.bean.Ciudad;
import modelo.bean.Deportista;

public class ModeloDeportista extends Conector{
	public ArrayList<Deportista> getAll(){
		ArrayList<Deportista> deportistas = new ArrayList<Deportista>();
		String query = "Select * from deportista";
		
		try {
			Statement st = getCon().createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				Deportista deportista = new Deportista();
				deportista.setId(rs.getInt("idDeportista"));
				deportista.setDni(rs.getString("dni"));
				deportista.setEdad(rs.getInt("edad"));
				deportista.setGenero(rs.getString("genero"));
				deportista.setNombre(rs.getString("nombre"));
				deportista.setTelefono(rs.getInt("telefono"));
				deportista.setEmail(rs.getString("email"));
				
				deportistas.add(deportista);
			}
			rs.close();
			st.close();
			return deportistas;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return null;
		
	}
	
	public Deportista select(int id) {
		try {
		PreparedStatement st = getCon().prepareStatement("Select * from deportista where idDeportista = ? ");
		st.setInt(1, id);
		ResultSet rs= st.executeQuery();
		
		if (rs.next()) {
			Deportista deportista = new Deportista();
			deportista.setId(rs.getInt("idDeportista"));
			deportista.setDni(rs.getString("dni"));
			deportista.setEdad(rs.getInt("edad"));
			deportista.setGenero(rs.getString("genero"));
			deportista.setNombre(rs.getString("nombre"));
			deportista.setTelefono(rs.getInt("telefono"));
			deportista.setEmail(rs.getString("email"));
			
			return deportista;
		}
		rs.close();
		st.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	
	
	public boolean insertDeportista(Deportista deportista) {
	    String query = "INSERT INTO deportista (Nombre, edad, genero, email, telefono, DNI) VALUES (?, ?, ?, ?, ?, ?)";
	    
	    try {
	        PreparedStatement st = getCon().prepareStatement(query);
	        st.setString(1, deportista.getNombre());
	        st.setInt(2, deportista.getEdad());
	        st.setString(3, deportista.getGenero());
	        st.setString(4, deportista.getEmail());
	        st.setInt(5, deportista.getTelefono());
	        st.setString(6, deportista.getDni());
	        
	        int rowsInserted = st.executeUpdate();
	        
	        st.close();
	        
	        return rowsInserted > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	
	
	public boolean eliminarDeportista(int idDeportista) {
	    String query = "DELETE FROM deportista WHERE idDeportista = ?";
	    
	    try {
	        PreparedStatement st = getCon().prepareStatement(query);
	        st.setInt(1, idDeportista);
	        
	        int rowsDeleted = st.executeUpdate();
	        
	        st.close();
	        
	        return rowsDeleted > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	
	
	public boolean modificarDeportista(Deportista deportista) {
	    String query = "UPDATE deportista SET Nombre = ?, edad = ?, genero = ?, email = ?, telefono = ?, DNI = ? WHERE idDeportista = ?";
	    
	    try {
	        PreparedStatement st = getCon().prepareStatement(query);
	        st.setString(1, deportista.getNombre());
	        st.setInt(2, deportista.getEdad());
	        st.setString(3, deportista.getGenero());
	        st.setString(4, deportista.getEmail());
	        st.setInt(5, deportista.getTelefono());
	        st.setString(6, deportista.getDni());
	        st.setInt(7, deportista.getId());
	        
	        int rowsUpdated = st.executeUpdate();
	        
	        st.close();
	        
	        return rowsUpdated > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	public int getMaxIdForDeportista() {
	    String query = "SELECT MAX(id) FROM deportistas";
	    PreparedStatement st = null;
	    ResultSet rs = null;
	    try {
	        st = getCon().prepareStatement(query);
	        rs = st.executeQuery();
	        if (rs.next()) {
	            return rs.getInt("id");  // Devuelve el dorsal máximo encontrado, 0 si no hay ninguno
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (st != null) st.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return 0; // Devuelve 0 si no encuentra un dorsal máximo o en caso de error
	}

	
	
	
}
