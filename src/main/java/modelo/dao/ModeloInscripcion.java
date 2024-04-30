package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conector.Conector;

import modelo.bean.Inscripcion;

public class ModeloInscripcion extends Conector {
	private ModeloEdicion mde = new ModeloEdicion();
	private ModeloDeportista mdd = new ModeloDeportista();

	public ArrayList<Inscripcion> getInscripcions() {
		ArrayList<Inscripcion> inscripcions = new ArrayList<Inscripcion>();

		try {
			Statement st = getCon().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM inscripciones");

			while (rs.next()) {

				Inscripcion inscripcion = new Inscripcion();

				inscripcion.setId(rs.getInt("idInscripcion"));

				inscripcion.setFechaInscripcion(rs.getDate("fechaInscipcion"));
				inscripcion.setDorsal(rs.getInt("dorsal"));

				inscripcion.setDeportista(mdd.select(rs.getInt("idDeportista")));

				inscripcion.setEdicion(mde.select(rs.getInt("idEdicion")));

				inscripcions.add(inscripcion);
			}
			rs.close();
			st.close();
			return inscripcions;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public Inscripcion select(int id) {
		try {
			PreparedStatement st = getCon().prepareStatement("SELECT * from inscripciones where idInscripcion = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				Inscripcion inscripcion = new Inscripcion();
				inscripcion.setId(rs.getInt("idInscripcion"));
				inscripcion.setFechaInscripcion(rs.getDate("fechaInscipcion"));
				inscripcion.setDorsal(rs.getInt("dorsal"));
				inscripcion.setDeportista(mdd.select(rs.getInt("idDeportista")));
				inscripcion.setEdicion(mde.select(rs.getInt("idEdicion")));

				return inscripcion;
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean crearInscripcion(Inscripcion inscripcion) {
		String query = "INSERT INTO inscripciones (dorsal, fechaInscipcion, idDeportista, idEdicion) VALUES (?, ?, ?, ?)";

		try {
			PreparedStatement st = getCon().prepareStatement(query);
			st.setInt(1, inscripcion.getDorsal());
			st.setDate(2, new java.sql.Date(inscripcion.getFechaInscripcion().getTime()));
			st.setInt(3, inscripcion.getDeportista().getId());
			st.setInt(4, inscripcion.getEdicion().getId());

			int rowsInserted = st.executeUpdate();

			st.close();

			return rowsInserted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean actualizarInscripcion(Inscripcion inscripcion) {
		String query = "UPDATE inscripciones SET dorsal = ?, fechaInscipcion = ?, idDeportista = ?, idEdicion = ? WHERE idInscripcion = ?";

		try {
			PreparedStatement st = getCon().prepareStatement(query);
			st.setInt(1, inscripcion.getDorsal());
			st.setDate(2, new java.sql.Date(inscripcion.getFechaInscripcion().getTime()));
			st.setInt(3, inscripcion.getDeportista().getId());
			st.setInt(4, inscripcion.getEdicion().getId());
			st.setInt(5, inscripcion.getId());

			int rowsUpdated = st.executeUpdate();

			st.close();

			return rowsUpdated > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean eliminarInscripcion(int idInscripcion) {
		String query = "DELETE FROM inscripciones WHERE idInscripcion = ?";

		try {
			PreparedStatement st = getCon().prepareStatement(query);
			st.setInt(1, idInscripcion);

			int rowsDeleted = st.executeUpdate();

			st.close();

			return rowsDeleted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
