package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conector.Conector;
import modelo.bean.Inscripcion;
import modelo.bean.Resultado;

public class ModeloResultado extends Conector {
	private ModeloInscripcion mdi = new ModeloInscripcion();

	public ArrayList<Resultado> getResultados() {
		ArrayList<Resultado> resultados = new ArrayList<Resultado>();
		String query = "Select * from resultados";

		try {
			Statement st = getCon().createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Resultado resultado = new Resultado();
				resultado.setId(rs.getInt("idResultado"));
				resultado.setClasificacion(rs.getInt("clasificacion"));
				resultado.setTiempo(rs.getString("tiempo"));
				resultado.setInscripcion(mdi.select(rs.getInt("idInscripcion")));
				resultados.add(resultado);
			}
			rs.close();
			st.close();
			return resultados;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public Resultado select(int id) {
		try {
			PreparedStatement st = getCon().prepareStatement("SELECT * from resultados where idResultado = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				Resultado resultado = new Resultado();
				resultado.setId(rs.getInt("idResultado"));
				resultado.setClasificacion(rs.getInt("clasificacion"));
				resultado.setTiempo(rs.getString("tiempo"));
				resultado.setInscripcion(mdi.select(rs.getInt("idInscripcion")));

				return resultado;
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	
	  public boolean crearResultado(Resultado resultado) {
	        String query = "INSERT INTO resultados (tiempo, clasificacion, idInscripcion) VALUES (?, ?, ?)";
	        
	        try {
	            PreparedStatement st = getCon().prepareStatement(query);
	            st.setString(1, resultado.getTiempo());
	            st.setInt(2, resultado.getClasificacion());
	            st.setInt(3, resultado.getInscripcion().getId());
	            
	            int rowsInserted = st.executeUpdate();
	            
	            st.close();
	            
	            return rowsInserted > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    
	 
	    
	    public boolean actualizarResultado(Resultado resultado) {
	        String query = "UPDATE resultados SET tiempo = ?, clasificacion = ?, idInscripcion = ? WHERE idResultado = ?";
	        
	        try {
	            PreparedStatement st = getCon().prepareStatement(query);
	            st.setString(1, resultado.getTiempo());
	            st.setInt(2, resultado.getClasificacion());
	            st.setInt(3, resultado.getInscripcion().getId());
	            st.setInt(4, resultado.getId());
	            
	            int rowsUpdated = st.executeUpdate();
	            
	            st.close();
	            
	            return rowsUpdated > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    
	    public boolean eliminarResultado(int idResultado) {
	        String query = "DELETE FROM resultados WHERE idResultado = ?";
	        
	        try {
	            PreparedStatement st = getCon().prepareStatement(query);
	            st.setInt(1, idResultado);
	            
	            int rowsDeleted = st.executeUpdate();
	            
	            st.close();
	            
	            return rowsDeleted > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    
	    
	    
	    public List<Resultado> selectByDeportistaId(int deportistaId) {
	        List<Resultado> resultados = new ArrayList<>();
	        String query = "SELECT r.* FROM resultados r JOIN inscripciones i ON r.idInscripcion = i.idInscripcion WHERE i.idDeportista = ?";
	        PreparedStatement st = null;
	        ResultSet rs = null;
	        try {
	            st = getCon().prepareStatement(query);
	            st.setInt(1, deportistaId);
	            rs = st.executeQuery();
	            while (rs.next()) {
	                Resultado resultado = new Resultado();
	                resultado.setId(rs.getInt("idResultado"));
	                resultado.setClasificacion(rs.getInt("clasificacion"));
	                resultado.setTiempo(rs.getString("tiempo"));
	                resultado.setInscripcion(mdi.select(rs.getInt("idInscripcion")));
	                resultados.add(resultado);
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
	        return resultados;
	    }
}
