package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conector.Conector;
import modelo.bean.Organizador;

public class ModeloOrganizador extends Conector {
	public ArrayList<Organizador> getAll(){
		ArrayList<Organizador> organizadors = new ArrayList<Organizador>();
		String query = "Select * from organizadores";
		
		try {
			Statement st = getCon().createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				Organizador organizador = new Organizador();
				organizador.setId(rs.getInt("idOrganizador"));
				organizador.setDni(rs.getString("dni"));
				
				organizador.setNombre(rs.getString("nombre"));
				organizador.setTelefono(rs.getInt("telefono"));
				organizador.setEmail(rs.getString("email"));
				
				organizadors.add(organizador);
			}
			rs.close();
			st.close();
			return organizadors;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return null;
		
	}
	
	public Organizador select(int id) {
		try {
		PreparedStatement st = getCon().prepareStatement("Select * from organizadores where idOrganizador = ? ");
		st.setInt(1, id);
		ResultSet rs= st.executeQuery();
		
		if (rs.next()) {
			Organizador organizador = new Organizador();
			organizador.setId(rs.getInt("idOrganizador"));
			organizador.setDni(rs.getString("dni"));
			organizador.setNombre(rs.getString("nombre"));
			organizador.setTelefono(rs.getInt("telefono"));
			organizador.setEmail(rs.getString("email"));
			
			return organizador;
		}
		rs.close();
		st.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	
	
	 public boolean crearOrganizador(Organizador organizador) {
	        String query = "INSERT INTO organizadores (nombre, email, telefono, dni) VALUES (?, ?, ?, ?)";
	        
	        try {
	            PreparedStatement st = getCon().prepareStatement(query);
	            st.setString(1, organizador.getNombre());
	            st.setString(2, organizador.getEmail());
	            st.setInt(3, organizador.getTelefono());
	            st.setString(4, organizador.getDni());
	            
	            int rowsInserted = st.executeUpdate();
	            
	            st.close();
	            
	            return rowsInserted > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    
	   
	    
	    public boolean actualizarOrganizador(Organizador organizador) {
	        String query = "UPDATE organizadores SET nombre = ?, email = ?, telefono = ?, dni = ? WHERE idOrganizador = ?";
	        
	        try {
	            PreparedStatement st = getCon().prepareStatement(query);
	            st.setString(1, organizador.getNombre());
	            st.setString(2, organizador.getEmail());
	            st.setInt(3, organizador.getTelefono());
	            st.setString(4, organizador.getDni());
	            st.setInt(5, organizador.getId());
	            
	            int rowsUpdated = st.executeUpdate();
	            
	            st.close();
	            
	            return rowsUpdated > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    
	    public boolean eliminarOrganizador(int idOrganizador) {
	        String query = "DELETE FROM organizadores WHERE idOrganizador = ?";
	        
	        try {
	            PreparedStatement st = getCon().prepareStatement(query);
	            st.setInt(1, idOrganizador);
	            
	            int rowsDeleted = st.executeUpdate();
	            
	            st.close();
	            
	            return rowsDeleted > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
}


