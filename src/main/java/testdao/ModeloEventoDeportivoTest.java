package testdao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import modelo.bean.Deportes;
import modelo.bean.EventoDeportivo;
import modelo.bean.Organizador;
import modelo.dao.ModeloEventoDeportivo;

class ModeloEventoDeportivoTest {
	private ModeloEventoDeportivo modeloEventoDeportivo = new ModeloEventoDeportivo();
	private EventoDeportivo eventoDeportivo;

	@Test
	void testGetEventos() {
		modeloEventoDeportivo.getEventos();
	}

	@Test
	void testSelect() {
		modeloEventoDeportivo.select(11);
	}

	@Test
	void testCrearEventoDeportivo() {
		String nombre = "aaa";
		String descripcion = "aass";
		Deportes deportes = new Deportes();
		deportes.setId(2);
		Organizador organizador = new Organizador();
		organizador.setId(3);

		eventoDeportivo = new EventoDeportivo(nombre, descripcion, deportes, organizador);

		assertTrue(modeloEventoDeportivo.crearEventoDeportivo(eventoDeportivo));

	}

	@Test
	void testActualizarEventoDeportivo() {
		String nombre = "aaa";
		String descripcion = "aLs";
		Deportes deportes = new Deportes();
		deportes.setId(2);
		Organizador organizador = new Organizador();
		organizador.setId(3);

		eventoDeportivo = new EventoDeportivo(nombre, descripcion, deportes, organizador);
		ArrayList<EventoDeportivo>eventoDeportivos = modeloEventoDeportivo.getEventos();
		int last = eventoDeportivos.get(eventoDeportivos.size()-1).getId();
		eventoDeportivo.setId(last);
		assertTrue(modeloEventoDeportivo.actualizarEventoDeportivo(eventoDeportivo));

	}

	@Test
	void testEliminarEventoDeportivo() {
		ArrayList<EventoDeportivo>eventoDeportivos = modeloEventoDeportivo.getEventos();
		int last = eventoDeportivos.get(eventoDeportivos.size()-1).getId();
		assertTrue(modeloEventoDeportivo.eliminarEventoDeportivo(last));
		
	}

}
