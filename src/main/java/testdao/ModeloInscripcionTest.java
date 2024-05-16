package testdao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import modelo.bean.Deportista;
import modelo.bean.Edicion;
import modelo.bean.Inscripcion;
import modelo.dao.ModeloInscripcion;

class ModeloInscripcionTest {
	private ModeloInscripcion modeloInscripcion = new ModeloInscripcion();
	Inscripcion inscripcion = null;
	@Test
	void testGetInscripcions() {
		modeloInscripcion.getInscripcions();
	}

	@Test
	void testSelect() {
		modeloInscripcion.select(42);
	}

	@Test
	void testCrearInscripcion() {
		int dorsal = 1234;
		Date date = new java.util.Date();
		Deportista deportista = new Deportista();
		deportista.setId(2);
		Edicion edicion = new Edicion();
		edicion.setId(14);
		
		inscripcion = new Inscripcion(dorsal, date, deportista, edicion);
		
		assertTrue(modeloInscripcion.crearInscripcion(inscripcion));
	}

	@Test
	void testActualizarInscripcion() {
		int dorsal = 1234;
		Date date = new java.util.Date();
		Deportista deportista = new Deportista();
		deportista.setId(2);
		Edicion edicion = new Edicion();
		edicion.setId(14);

		inscripcion = new Inscripcion(dorsal, date, deportista, edicion);
		ArrayList<Inscripcion>inscripcions = modeloInscripcion.getInscripcions();
		int last=inscripcions.get(inscripcions.size()-1).getId();
		inscripcion.setId(last);
		assertTrue(modeloInscripcion.actualizarInscripcion(inscripcion));
	}

	@Test
	void testEliminarInscripcion() {
		ArrayList<Inscripcion>inscripcions = modeloInscripcion.getInscripcions();
		int last=inscripcions.get(inscripcions.size()-1).getId();
		
		assertTrue(modeloInscripcion.eliminarInscripcion(last));
	}

	@Test
	void testGetMaxDorsalForEdicion() {
		modeloInscripcion.getMaxDorsalForEdicion(14);
	}

	@Test
	void testSelectByDeportistaId() {
		modeloInscripcion.selectByDeportistaId(3);
	}

	@Test
	void testSelectByEdicionId() {
		modeloInscripcion.selectByEdicionId(14);
	}

}
