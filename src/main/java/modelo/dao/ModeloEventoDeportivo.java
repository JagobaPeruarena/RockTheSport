package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conector.Conector;

import modelo.bean.EventoDeportivo;


public class ModeloEventoDeportivo extends Conector {
	private ModeloOrganizador md = new ModeloOrganizador();
	private ModeloDeportes mdd= new ModeloDeportes();
	
	public ArrayList<EventoDeportivo> getEventos(){
		ArrayList<EventoDeportivo> eventoDeportivos = new ArrayList<EventoDeportivo>();
		String query = "Select * from eventosdeportivos";
		
		try {
			Statement st = getCon().createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				EventoDeportivo eventoDeportivo = new EventoDeportivo();
				eventoDeportivo.setId(rs.getInt("idEvento"));
				eventoDeportivo.setNombre(rs.getString("nombre"));
				eventoDeportivo.setDescripcion(rs.getString("descripcion"));
				eventoDeportivo.setTipoDeporte(mdd.select(rs.getInt("tipoDeporte")));
				eventoDeportivo.setOrganizador( md.select(rs.getInt("idOrganizador")));
				
				eventoDeportivos.add(eventoDeportivo);
			}
			rs.close();
			st.close();
			return eventoDeportivos;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	
	public EventoDeportivo select(int id) {
		try {
			PreparedStatement st = getCon().prepareStatement("SELECT * from eventosdeportivos where idEvento = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				EventoDeportivo eventoDeportivo = new EventoDeportivo();
				eventoDeportivo.setId(rs.getInt("idEvento"));
				eventoDeportivo.setNombre(rs.getString("nombre"));
				eventoDeportivo.setDescripcion(rs.getString("descripcion"));
				eventoDeportivo.setTipoDeporte(mdd.select(rs.getInt("tipoDeporte")));
				eventoDeportivo.setOrganizador( md.select(rs.getInt("idOrganizador")));
				
				return eventoDeportivo;
			}
			 rs.close();
	            st.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
		
	}
	
	
	
	public boolean crearEventoDeportivo(EventoDeportivo evento) {
        String query = "INSERT INTO eventosdeportivos (nombre, descripcion, tipoDeporte, idOrganizador) VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement st = getCon().prepareStatement(query);
            st.setString(1, evento.getNombre());
            st.setString(2, evento.getDescripcion());
            st.setInt(3, evento.getTipoDeporte().getId());
            st.setInt(4, evento.getOrganizador().getId());
            
            int rowsInserted = st.executeUpdate();
            
            st.close();
            
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public boolean actualizarEventoDeportivo(EventoDeportivo evento) {
        String query = "UPDATE eventosdeportivos SET nombre = ?, descripcion = ?, tipoDeporte = ?, idOrganizador = ? WHERE idEvento = ?";
        
        try {
            PreparedStatement st = getCon().prepareStatement(query);
            st.setString(1, evento.getNombre());
            st.setString(2, evento.getDescripcion());
            st.setInt(3, evento.getTipoDeporte().getId());
            st.setInt(4, evento.getOrganizador().getId());
            st.setInt(5, evento.getId());
            
            int rowsUpdated = st.executeUpdate();
            
            st.close();
            
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminarEventoDeportivo(int idEvento) {
        String query = "DELETE FROM eventosdeportivos WHERE idEvento = ?";
        
        try {
            PreparedStatement st = getCon().prepareStatement(query);
            st.setInt(1, idEvento);
            
            int rowsDeleted = st.executeUpdate();
            
            st.close();
            
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
