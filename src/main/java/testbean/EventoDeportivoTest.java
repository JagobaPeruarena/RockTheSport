package testbean;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.bean.Deportes;
import modelo.bean.Edicion;
import modelo.bean.EventoDeportivo;
import modelo.bean.Organizador;

class EventoDeportivoTest {
	private EventoDeportivo eventoDeportivo = null;

	@Test
	void testSetAndGetId() {
		eventoDeportivo = new EventoDeportivo();
		eventoDeportivo.setId(12);
		assertEquals("error", 12, eventoDeportivo.getId());

	}

	@Test
	void testSetAndGetNombre() {
		eventoDeportivo = new EventoDeportivo();
		eventoDeportivo.setNombre("aaa");
		assertEquals("error", "aaa", eventoDeportivo.getNombre());

	}

	@Test
	void testSetAndGetDescripcion() {
		eventoDeportivo = new EventoDeportivo();
		eventoDeportivo.setDescripcion("aass");
		assertEquals("error", "aass", eventoDeportivo.getDescripcion());

	}

	@Test
	void testSetAndGetTipoDeporte() {
		eventoDeportivo = new EventoDeportivo();
		Deportes deportes = new Deportes();
		eventoDeportivo.setTipoDeporte(deportes);
		assertEquals("error", deportes, eventoDeportivo.getTipoDeporte());

	}

	@Test
	void testSetAndGetOrganizador() {
		eventoDeportivo = new EventoDeportivo();
		Organizador organizador = new Organizador();
		eventoDeportivo.setOrganizador(organizador);
		assertEquals("error", organizador, eventoDeportivo.getOrganizador());

	}

	@Test
	void testEventoDeportivoID() {
		int id = 12;
		String nombre = "aaa";
		String descripcion = "aass";
		Deportes deportes = new Deportes();
		Organizador organizador = new Organizador();

		eventoDeportivo = new EventoDeportivo(id, nombre, descripcion, deportes, organizador);

		assertEquals("error", 12, eventoDeportivo.getId());
		assertEquals("error", "aaa", eventoDeportivo.getNombre());
		assertEquals("error", "aass", eventoDeportivo.getDescripcion());
		assertEquals("error", deportes, eventoDeportivo.getTipoDeporte());
		assertEquals("error", organizador, eventoDeportivo.getOrganizador());
	}

	@Test
	void testEventoDeportivoNoId() {
		String nombre = "aaa";
		String descripcion = "aass";
		Deportes deportes = new Deportes();
		Organizador organizador = new Organizador();

		eventoDeportivo = new EventoDeportivo(nombre, descripcion, deportes, organizador);

		assertEquals("error", "aaa", eventoDeportivo.getNombre());
		assertEquals("error", "aass", eventoDeportivo.getDescripcion());
		assertEquals("error", deportes, eventoDeportivo.getTipoDeporte());
		assertEquals("error", organizador, eventoDeportivo.getOrganizador());
	}

	@Test
	void testEventoDeportivo() {
		eventoDeportivo = new EventoDeportivo();
		
		assertEquals("error",eventoDeportivo,eventoDeportivo);
	}

}
