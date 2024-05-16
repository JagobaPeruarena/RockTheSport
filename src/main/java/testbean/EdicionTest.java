package testbean;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import modelo.bean.Ciudad;
import modelo.bean.Edicion;
import modelo.bean.EventoDeportivo;
import servlet.edicion;

class EdicionTest {
	private Edicion edicion = null;

	@Test
	void testSetAndGetId() {
		edicion = new Edicion();
		edicion.setId(12);
		assertEquals("error", 12, edicion.getId());

	}

	@Test
	void testSetAndGetFecha() {
		edicion = new Edicion();
		edicion.setFecha(new java.util.Date());
		assertEquals("error", new java.util.Date(), edicion.getFecha());

	}

	@Test
	void testSetAndGetCuposDisponibles() {
		edicion = new Edicion();
		edicion.setCuposDisponibles(1222);
		assertEquals("error", 1222, edicion.getCuposDisponibles());

	}

	@Test
	void testSetAndGetEventoDeportivo() {
		edicion = new Edicion();
		EventoDeportivo eventoDeportivo = new EventoDeportivo();
		edicion.setEventoDeportivo(eventoDeportivo);

		assertEquals("error", eventoDeportivo, edicion.getEventoDeportivo());

	}

	@Test
	void testSetAndGetCiudad() {
		edicion = new Edicion();
		Ciudad ciudad = new Ciudad();
		edicion.setCiudad(ciudad);
		assertEquals("error", ciudad, edicion.getCiudad());

	}

	@Test
	void testEdicionId() {
		int id = 12;
		Date date = new java.util.Date();
		int cuposDisponibles = 1222;
		EventoDeportivo eventoDeportivo = new EventoDeportivo();
		Ciudad ciudad = new Ciudad();

		edicion = new Edicion(id, date, cuposDisponibles, eventoDeportivo, ciudad);

		assertEquals("error", 12, edicion.getId());
		assertEquals("error", date, edicion.getFecha());
		assertEquals("error", 1222, edicion.getCuposDisponibles());
		assertEquals("error", eventoDeportivo, edicion.getEventoDeportivo());
		assertEquals("error", ciudad, edicion.getCiudad());
	}

	@Test
	void testEdicionNoId() {

		Date date = new java.util.Date();
		int cuposDisponibles = 1222;
		EventoDeportivo eventoDeportivo = new EventoDeportivo();
		Ciudad ciudad = new Ciudad();

		edicion = new Edicion(date, cuposDisponibles, eventoDeportivo, ciudad);

		assertEquals("error", date, edicion.getFecha());
		assertEquals("error", 1222, edicion.getCuposDisponibles());
		assertEquals("error", eventoDeportivo, edicion.getEventoDeportivo());
		assertEquals("error", ciudad, edicion.getCiudad());
	}

	@Test
	void testEdicion() {
		edicion = new Edicion();
		
		Edicion edicionn = new Edicion();
		assertEquals("error",edicionn,edicionn);
	}

}
