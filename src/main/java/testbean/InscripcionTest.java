package testbean;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import modelo.bean.Deportista;
import modelo.bean.Edicion;
import modelo.bean.EventoDeportivo;
import modelo.bean.Inscripcion;

class InscripcionTest {
	private Inscripcion inscripcion = null;

	@Test
	void testSetAndGetId() {
		inscripcion = new Inscripcion();
		inscripcion.setId(12);
		assertEquals("error", 12, inscripcion.getId());

	}

	@Test
	void testSetAndGetDorsal() {
		inscripcion = new Inscripcion();
		inscripcion.setDorsal(1234);
		assertEquals("error", 1234, inscripcion.getDorsal());

	}

	@Test
	void testSetAndGetFechaInscripcion() {
		inscripcion = new Inscripcion();
		inscripcion.setFechaInscripcion(new java.util.Date());
		assertEquals("error", new java.util.Date(), inscripcion.getFechaInscripcion());

	}

	@Test
	void testSetAndGetDeportista() {
		inscripcion = new Inscripcion();
		Deportista deportista = new Deportista();
		inscripcion.setDeportista(deportista);
		assertEquals("error", deportista, inscripcion.getDeportista());

	}

	@Test
	void testSetAndGetEdicion() {
		inscripcion = new Inscripcion();
		Edicion edicion = new Edicion();
		inscripcion.setEdicion(edicion);
		assertEquals("error", edicion, inscripcion.getEdicion());

	}

	@Test
	void testInscripcionId() {
		int id = 12;
		int dorsal = 1234;
		Date date = new java.util.Date();
		Deportista deportista = new Deportista();
		Edicion edicion = new Edicion();

		inscripcion = new Inscripcion(id, dorsal, date, deportista, edicion);

		assertEquals("error", 12, inscripcion.getId());
		assertEquals("error", 1234, inscripcion.getDorsal());
		assertEquals("error", date, inscripcion.getFechaInscripcion());
		assertEquals("error", deportista, inscripcion.getDeportista());
		assertEquals("error", edicion, inscripcion.getEdicion());
	}

	@Test
	void testInscripcionNoID() {

		int dorsal = 1234;
		Date date = new java.util.Date();
		Deportista deportista = new Deportista();
		Edicion edicion = new Edicion();

		inscripcion = new Inscripcion(dorsal, date, deportista, edicion);

		assertEquals("error", 1234, inscripcion.getDorsal());
		assertEquals("error", date, inscripcion.getFechaInscripcion());
		assertEquals("error", deportista, inscripcion.getDeportista());
		assertEquals("error", edicion, inscripcion.getEdicion());
	}

	@Test
	void testInscripcion() {
		inscripcion = new Inscripcion();
		Inscripcion inscripcionn = new Inscripcion();
		assertEquals("error",inscripcionn, inscripcionn);
	}

}
